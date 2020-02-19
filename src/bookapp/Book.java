package bookapp;

import bookapp.constant.GenreCode;

public class Book {

	private final int id;
	private String title;
	private String writer;
	private int genre;
	private boolean isAvailable;

	private static int cnt;

	static {
		cnt = 0;
	}

	public Book()  {
		this.id = cnt++;
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
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "[" +
				"도서번호: " + id
				+ " | 책제목: " + title
				+ " | 저자: " + writer
				+ " | 장르: " + GenreCode.getName(genre)
				+ " | 대여가능여부: " + isAvailable
				+ "]";
	}

}
