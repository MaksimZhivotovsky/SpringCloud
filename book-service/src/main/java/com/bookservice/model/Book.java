package com.bookservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {

	@Id
	@Column(name = "book_id", nullable = false)
	private String bookId;
	@Column(name = "library_id")
	private String libraryId;
	@Column(name = "name")
	private String name;
	@Column(name = "author")
	private String author;
	@Column(name = "pages")
	private int pages;
	@Column(name="comment")
	private String comment;
	
	public Book withComment(String comment) {
		this.setComment(comment);
		return this;
	}
}
