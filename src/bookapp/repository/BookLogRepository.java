package bookapp.repository;

import bookapp.domain.BookLog;

public class BookLogRepository extends SimpleRepository<BookLog, Long> {

    private static BookLogRepository bookLogRepository;

    public static BookLogRepository getInstance() {
        if (bookLogRepository == null) bookLogRepository = new BookLogRepository();
        return bookLogRepository;
    }

}
