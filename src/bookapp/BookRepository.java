package bookapp;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        init();
    }

    private void init() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setTitle("도서" + i);
            book.setWriter("아무개");
            book.setGenre(1);
            books.add(book);
        }
    }

    public void save(Book book) {
        books.add(book);
    }

    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        if (result.size() == 0) return null;
        return result;
    }

    public List<Book> findByWriter(String writer) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getWriter().equals(writer)) {
                result.add(book);
            }
        }
        if (result.size() == 0) return null;
        return result;
    }

    public List<Book> findByGenre(int genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre() == genre) {
                result.add(book);
            }
        }
        if (result.size() == 0) return null;
        return result;
    }

    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findByAvailable(boolean available) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable() == available) {
                result.add(book);
            }
        }
        if (result.size() == 0) return null;
        return result;
    }

    public List<Book> findAll() {
        return this.books;
    }

    public boolean update(Book book) {
        for (Book value : books) {
            if (value.getId() == book.getId()) {
                value.setTitle(book.getTitle());
                value.setWriter(book.getWriter());
                value.setGenre(book.getGenre());
                value.setAvailable(book.isAvailable());
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            books.remove(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
