package bookapp.domain;

import java.time.LocalDateTime;

public class BookLog {

    private final Long seq;
    private Long bookId;
    private String bookTitle;
    private String borrower;
    private String status;
    private LocalDateTime rentalTime;
    private LocalDateTime returnTime;

    private static Long cnt;

    static {
        cnt = 0L;
    }

    public BookLog() {
        this.seq = cnt++;
    }

    public void setRental(Book book) {
        BookLog bookLog = new BookLog();
        bookLog.setBookId(book.getId());
        bookLog.setBookTitle(book.getTitle());
        bookLog.setStatus("대여");
        bookLog.setRentalTime(LocalDateTime.now());
    }

    public void setReturn(Book book) {
        BookLog bookLog = new BookLog();
        bookLog.setBookId(book.getId());
        bookLog.setBookTitle(book.getTitle());
        bookLog.setStatus("반");
        bookLog.setReturnTime(LocalDateTime.now());
    }

    public Long getSeq() {
        return seq;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(LocalDateTime rentalTime) {
        this.rentalTime = rentalTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public String toString() {
        return "["
                + "대여번호: " + seq
                + " | 도서번호: " + bookId
                + " | 도서제목: " + bookTitle
                + " | 사용자: " + borrower
                + " | 상태: " + status
                + " | 대여시간: " + rentalTime
                + " | 반납시간: " + returnTime
                + "]";
    }
}
