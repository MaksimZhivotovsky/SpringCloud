package com.bookservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.model.Book;
import com.bookservice.service.BookService;

@RestController
@RequestMapping(value = "v1/library/{libraryId}/book")
public class BookController {

	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping(value = "/{bookId}")
	public ResponseEntity<Book> getBook(
			@PathVariable("libraryId") String libraryId,
			@PathVariable("bookId") String bookId) {
		
		Book book = bookService.getBook(bookId, libraryId);
		return ResponseEntity.ok(book);
	}
	
	@PutMapping
	public ResponseEntity<Book> updateBook(@RequestBody Book request) {
		return ResponseEntity.ok(bookService.updateBook(request));
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book requst) {
		return ResponseEntity.ok(bookService.createBook(requst));
	}
	
	@DeleteMapping(value = "/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable("bookId") String bookId) {
		return ResponseEntity.ok(bookService.deleteBook(bookId));
	}
}
