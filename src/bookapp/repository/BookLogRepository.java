package bookapp.repository;

import bookapp.domain.BookLog;

import java.util.List;

public class BookLogRepository implements Repository<BookLog> {

    private static BookLogRepository bookLogRepository;

    private List<BookLog> bookLogs;

    public static BookLogRepository getInstance() {
        if (bookLogRepository == null) bookLogRepository = new BookLogRepository();
        return bookLogRepository;
    }

    public List<BookLog> findAll() {
        return bookLogs;
    }

    public void save(BookLog bookLog) {
        this.bookLogs.add(bookLog);
    }

    @Override
    public boolean update(BookLog bookLog) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }


}
