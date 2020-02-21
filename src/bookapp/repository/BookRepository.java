package bookapp.repository;

import bookapp.annotation.Bean;
import bookapp.domain.Book;

import java.util.ArrayList;
import java.util.List;

@Bean
public class BookRepository extends SimpleRepository<Book, Long> {

    public BookRepository() {
        //init();
    }

    private void init() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setTitle("도서" + i);
            book.setWriter("아무개");
            book.setGenre(1);
            super.items.add(book);
        }
    }

    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : super.items) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        if (result.size() == 0) return null;
        return result;
    }

    public List<Book> findByWriter(String writer) {
        List<Book> result = new ArrayList<>();
        for (Book book : super.items) {
            if (book.getWriter().equals(writer)) {
                result.add(book);
            }
        }
        if (result.size() == 0) return null;
        return result;
    }

    public List<Book> findByGenre(int genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : super.items) {
            if (book.getGenre() == genre) {
                result.add(book);
            }
        }
        if (result.size() == 0) return null;
        return result;
    }

    public List<Book> findByAvailable(boolean available) {
        List<Book> result = new ArrayList<>();
        for (Book book : super.items) {
            if (book.isAvailable() == available) {
                result.add(book);
            }
        }
        if (result.size() == 0) return null;
        return result;
    }

    public boolean delete(Book book) {
        try {
            super.items.remove(book);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteById(Long id) {
        try {
            super.items.remove(id.intValue());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
