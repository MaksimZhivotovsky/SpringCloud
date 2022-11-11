package com.bookservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.bookservice.config.ServiceConfig;
import com.bookservice.model.Book;
import com.bookservice.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private MessageSource messages;

	@Autowired
	private ServiceConfig config;
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book getBook(String bookId, String libraryId) {
		Book book = bookRepository.findByLibraryIdAndBookId(libraryId, bookId);
		if(book == null) {
			throw new IllegalArgumentException(String.format(messages.getMessage("book.search.error.message", null, null), bookId, libraryId));
		}
		return book.withComment(config.getProperty());
	}
	
	public Book createBook(Book book) {
		book.setBookId(UUID.randomUUID().toString());
		bookRepository.save(book);
		return book.withComment(config.getProperty());
	}
	
	public Book updateBook(Book book) {
		bookRepository.save(book);
		return book.withComment(config.getProperty());
	}
	
	public String deleteBook(String bookId) {
		String message = null;
		Book book = new Book();
		book.setBookId(bookId);
		bookRepository.delete(book);
		message = String.format(messages.getMessage("license.delete.message", null, null),bookId);
		return message;
	}
}
