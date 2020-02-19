package bookapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {

	private Scanner scanner = new Scanner(System.in);
	private final List<Book> books;
	private final List<BookRentalLog> bookRentalLogs;

	public BookManager() {
		this.books = new ArrayList<>();
		this.bookRentalLogs = new ArrayList<>();
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

				book.setTitle(title);
				book.setWriter(writer);
				book.setGenre(genre);

				System.out.println("도서 등록 정보");
				System.out.println("==========================================================");
				System.out.println(book.toString());
				System.out.println("==========================================================");

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
				books.add(book);
				System.out.println("도서가 등록되었습니다.");
				break;
			} catch (Exception e) {
				System.out.println("잘못된 값이 입력되었습니다. 처음부터 다시 입력해주세요.");
				scanner = new Scanner(System.in);
			}
		}
	}

	public void _return() {

	}

	public void printList() {
		if (books.size() == 0) {
			System.out.println("도서 목록이 없습니다. 도서를 등록 후 사용해주세요.");
			return;
		}
		System.out.println("==========================================================");
		for (Book book : books) {
			System.out.println(book.toString());
		}
		System.out.println("==========================================================");
	}

	public void rental() {

	}

	public void remove() {

	}

	public void printRentalLog() {
		if (bookRentalLogs.size() == 0) {
			System.out.println("대여 이력이 없습니다.");
			return;
		}
		System.out.println("==========================================================");
		for (BookRentalLog rentalLog : bookRentalLogs) {
			System.out.println(rentalLog.toString());
		}
		System.out.println("==========================================================");
	}
}
		

