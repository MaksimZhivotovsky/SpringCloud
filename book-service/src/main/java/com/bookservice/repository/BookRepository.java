package com.bookservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookservice.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	public List<Book> findByLibraryId(String libraryId);
	public Book findByLibraryIdAndBookId(String libraryId, String bookId);
}
