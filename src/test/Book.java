package test;

import java.sql.SQLException;

public class Book {
	private int id;
	private String title;
	private String isbn;
	private int year;
	private String publisher;
	private int author_id;
	private String fileName;

	public Book(int id, String title, String isbn, int year, String publisher, int author_id, String fileName) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.year = year;
		this.publisher = publisher;
		this.author_id = author_id;
		this.fileName = fileName;
	}
	
	public Author getAuthor() throws SQLException {
		return AuthorRepo.getRepo().getByID(author_id);	
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Book() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	
}