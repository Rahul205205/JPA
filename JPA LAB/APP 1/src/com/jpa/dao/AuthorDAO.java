package com.jpa.dao;

import com.jpa.entities.Author;

public interface AuthorDAO {
	public boolean addAuthor(Author author);
	public boolean deleteAuthor(Author author);
	public Author updateAuthor(Author author);
	public Author findAuthor(Integer id);
}
