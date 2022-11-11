package com.libraryservice.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.libraryservice.model.Library;
import com.libraryservice.repository.LibraryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibraryService {

	private final LibraryRepository libraryRepository;
	
	public Library findByLibraryId(String libraryId) {
		Optional<Library> library = libraryRepository.findByLibraryId(libraryId);
		return (library.isPresent()) ? library.get() : null;
	}
	
	public Library create(Library library) {
		library.setLibraryId(UUID.randomUUID().toString());
		library = libraryRepository.save(library);
		return library;
	}
	
	public void update(Library library) {
		libraryRepository.save(library);
	}
	
	public void delete(Library library) {
		libraryRepository.deleteById(library.getLibraryId());
	}
}
