package com.libraryservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.libraryservice.model.Library;
import com.libraryservice.service.LibraryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/library")
public class LibraryController {

	public final LibraryService libraryService;
	
	@GetMapping(value = "/{libraryId}")
	public ResponseEntity<Library> getLibrary(@PathVariable("libraryId") String libraryId) {
		return ResponseEntity.ok(libraryService.findByLibraryId(libraryId));
	}
	
	@PutMapping(value = "/{libraryId}")
	public void updateLibrary(@PathVariable("libraryId") String libraryId, @RequestBody Library library) {
		libraryService.update(library);
	}
	
	@PostMapping
	public ResponseEntity<Library> saveLibrary(@RequestBody Library library) {
		return ResponseEntity.ok(libraryService.create(library));
	}
	
	@DeleteMapping(value = "/{libraryId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLibrary(@PathVariable("libraryId") String libraryId, @RequestBody Library library) {
		libraryService.delete(library);
	}
}
