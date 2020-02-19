package bookapp;

import java.time.LocalDateTime;

public class BookRentalLog {

    private final int seq;
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

    public int getSeq() {
        return seq;
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
                + " 책제목: " + bookTitle
                + " 사용자: " + borrower
                + " 대여시간: " + rentalTime
                + " 반납시간: " + returnTime
                + "]";
    }
}
