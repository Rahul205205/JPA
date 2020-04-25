package com.jpa.service;
import com.jpa.entities.*;
public interface AuthorService {
	public  boolean addAuthor(Author author);
	public Author updateAuthor(Author author);
	public boolean deleteAuthor(Integer id);

}
