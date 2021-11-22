package com.books.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.books.entities.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
	
	List<Book> findByTitleContaining(String title);

	List<Book> findByAuthor(String name);
}
