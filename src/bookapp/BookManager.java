package bookapp;

import bookapp.domain.Book;
import bookapp.domain.BookLog;
import bookapp.repository.BookRepository;
import bookapp.repository.BookLogRepository;

import java.util.List;
import java.util.Scanner;

public class BookManager {

	private Scanner scanner = new Scanner(System.in);
	private final BookRepository bookRepository;
	private final BookLogRepository bookLogRepository;

	private static BookManager bookManager;

	private BookManager() {
		this.bookRepository = BookRepository.getInstance();
		this.bookLogRepository = BookLogRepository.getInstance();
	}

	public static BookManager getInstance() {
		if (bookManager == null) bookManager = new BookManager();
		return bookManager;
	}

	public void register() {
		Book book = new Book();
		String title;
		String writer;
		int genre;
		while (true) {
			try {
				System.out.println("책 제목 입력> ");
				title = scanner.next();
				System.out.println("저자 입력> ");
				writer = scanner.next();
				System.out.println("장르 번호 입력 [1. 시 | 2. 소설 | 3. 만화]> ");
				genre = scanner.nextInt();

				if (genre > 3 || genre < 1) throw new Exception();

				book.setTitle(title);
				book.setWriter(writer);
				book.setGenre(genre);

				System.out.println("도서 등록 정보");
				System.out.println("========================================================================");
				System.out.println();
				System.out.println(book.toString());
				System.out.println();
				System.out.println("========================================================================");

				String isRegister;
				while (true) {
					System.out.println("등록하시겠습니까? (y/n)");
					isRegister = scanner.next().toLowerCase();
					if (isRegister.equals("y") || isRegister.equals("n")) {
						break;
					}
					System.out.println("y/n 중에 하나만 입력해주세요.");
				}

				if (isRegister.toLowerCase().equals("n")) {
					System.out.println("도서를 등록하지 않았습니다.");
					return;
				}
				bookRepository.save(book);
				System.out.println("도서가 등록되었습니다.");
				break;
			} catch (Exception e) {
				System.out.println("잘못된 값이 입력되었습니다. 처음부터 다시 입력해주세요.");
				scanner = new Scanner(System.in);
			}
		}
	}

	public void rental() {
		while (true) {
			try {
				System.out.println("대여할 도서의 도서번호를 입력해주세요.");
				int selectedId = scanner.nextInt();
				Book book = bookRepository.findById(selectedId);

				if (book == null) {
					System.out.println("해당 도서가 존재하지 않습니다.");
					continue;
				}

				if (!book.isAvailable()) {
					System.out.println("이미 대여중인 도서입니다.");
					continue;
				}
				book.setAvailable(false);

				System.out.println(book.getTitle() + "을(를) 대여했습니다.");
				BookLog bookLog = new BookLog();
				bookLog.setRental(book);
				bookLogRepository.save(bookLog);
				return;
			} catch (Exception e) {
				System.out.println("잘못된 값이 입력되었습니다.");
				scanner = new Scanner(System.in);
			}
		}
	}

	public void _return() {
		while(true) {
			try {
				List<Book> byAvailable = bookRepository.findByAvailable(false);
				if (byAvailable == null) {
					System.out.println("대여중인 도서가 없습니다.");
					return;
				}
				print(byAvailable);
				System.out.println("반납할 도서의 id를 입력하세요. 모두 반납하시려면 'all'라고 입력해주세요\n나가시려면 'exit'를 입력해주세요.");
				String selected = scanner.next();

				if (selected.equals("all")) {
					for (Book book : byAvailable) {
						book.setAvailable(true);
						bookRepository.update(book);
					}
					System.out.println("모든 책이 반납되었습니다.");
					return;
				}

				if (selected.equals("exit")) return;

				int selectedId = Integer.parseInt(selected);
				Book book = bookRepository.findById(selectedId);
				if (book.isAvailable()) {
					System.out.println("반납할 수 없는 도서입니다.");
					continue;
				}
				book.setAvailable(true);
				bookRepository.update(book);
				System.out.println("반납이 완료되었습니다.");
				BookLog bookLog = new BookLog();
				bookLog.setReturn(book);
				bookLogRepository.save(bookLog);
				return;
			} catch (Exception e) {
				System.out.println("잘못된 값이 입력되었습니다.");
				scanner = new Scanner(System.in);
			}

		}
	}

	public void remove() {
		System.out.println("삭제할 도서의 id를 입력해주세요.");
		try {
			int id = scanner.nextInt();
			Book byId = bookRepository.findById(id);
			if (byId == null) {
				System.out.println("헤당 id 값과 일치하는 도서가 없습니다.");
				return;
			}
			System.out.println("========================================================================");
			System.out.println("삭제할 도서 정보");
			System.out.println(byId);
			System.out.println();
			System.out.println("========================================================================");
			System.out.println("정말 삭제하시겠습니까?(y/n)");
			String isDelete = scanner.next().toLowerCase();
			if (!(isDelete.equals("n") || isDelete.equals("y"))) throw new Exception();
			if (isDelete.equals("y")) bookRepository.delete(id);
		} catch (Exception e) {
			System.out.println("잘못된 값이 입력되었습니다.");
			scanner = new Scanner(System.in);
		}
	}

	public void search() {
		List<Book> result = null;
		while (true) {
			try {
				System.out.println("1. 제목으로 검색 | 2. 작가로 검색 | 3. 장르로 검색 | 4. 모든 책 보기 | 5. 나가기");
				int orderNo = scanner.nextInt();
				switch (orderNo) {
					case 1:
						System.out.print("검색할 도서의 제목을 입력해주세요.");
						String title = scanner.next();
						result = bookRepository.findByTitle(title);
						break;
					case 2:
						System.out.print("검색할 작가의 이름을 입력해주세요.");
						String writer = scanner.next();
						result = bookRepository.findByWriter(writer);
						break;
					case 3:
						System.out.print("검색할 도서의 제목을 입력해주세요.");
						int genreNo = scanner.nextInt();
						result = bookRepository.findByGenre(genreNo);
						break;
					case 4:
						print(bookRepository.findAll());
						break;
					case 5:
						return;
					default:
						throw new Exception();
				}
				if (result == null) {
					System.out.println("검색된 결과가 없습니다.");
					continue;
				}
				print(result);
				System.out.println("계속 검색하시겠습니까?(y/n)");
				String isContinue = scanner.next().toLowerCase();
				if (!(isContinue.equals("n") || isContinue.equals("y"))) throw new Exception();
				if (isContinue.equals("n")) {
					return;
				}
			} catch (Exception e) {
				System.out.println("잘못된 값이 입력되었습니다.");
				scanner = new Scanner(System.in);
			}
		}

	}

	public void print(List<Book> books) {
		if (books.size() == 0) {
			System.out.println("도서 목록이 없습니다.");
			return;
		}
		System.out.println("========================================================================");
		System.out.println();
		for (Book book : books) {
			System.out.println(book.toString());
		}
		System.out.println();
		System.out.println("========================================================================");
	}

	public void printRentalLog() {
		List<BookLog> bookLogs = bookLogRepository.findAll();
		if (bookLogs.size() == 0) {
			System.out.println("대여 이력이 없습니다.");
			return;
		}
		System.out.println("========================================================================");
		System.out.println();
		for (BookLog bookLog : bookLogs) {
			System.out.println(bookLog.toString());
		}
		System.out.println();
		System.out.println("========================================================================");
	}

}
		

