package bookapp;

import java.time.LocalDateTime;

public class BookRentalLog {

    private final int seq;
    private int bookId;
    private String bookTitle;
    private String borrower;
    private LocalDateTime rentalTime;
    private LocalDateTime returnTime;

    private static int cnt;

    static {
        cnt = 0;
    }

    public BookRentalLog() {
        this.seq = cnt++;
    }

    public void set(Book book) {
        this.bookId = book.getId();
        this.bookTitle = book.getTitle();
        this.rentalTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "["
                + "대여번호: " + seq
                + " | 도서번호: " + bookId
                + " | 도서제목: " + bookTitle
                + " | 사용자: " + borrower
                + " | 대여시간: " + rentalTime
                + " | 반납시간: " + returnTime
                + "]";
    }
}
