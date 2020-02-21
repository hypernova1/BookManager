package bookapp.repository;

import bookapp.annotation.Bean;
import bookapp.domain.BookLog;

@Bean
public class BookLogRepository extends SimpleRepository<BookLog, Long> {

}
