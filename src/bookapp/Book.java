package bookapp;

public class Book {

	private final int seq;
	private String title;
	private String writer;
	private int genre;
	private boolean isAvailable;

	private static int cnt;

	static {
		cnt = 0;
	}

	public Book()  {
		this.seq = cnt++;
		this.isAvailable = true;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean available) {
		isAvailable = available;
	}
	public int getSeq() {
		return seq;
	}

	@Override
	public String toString() {
		return "[" +
				"대여번호: " + seq
				+ " 책제목: " + title
				+ " 저자" + writer
				+ " 장르: " + genre
				+ " 대여가능여부: " + isAvailable
				+ "]";
	}

}
