package com.libraryservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.libraryservice.model.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, String> {
	
	public Optional<Library> findByLibraryId(String organizationId);
}
