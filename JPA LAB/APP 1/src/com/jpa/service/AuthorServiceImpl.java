package com.jpa.service;

import com.jpa.dao.AuthorDAOImpl;
import com.jpa.entities.Author;

public class AuthorServiceImpl implements AuthorService {

	AuthorDAOImpl dao = new AuthorDAOImpl();

	public boolean addAuthor(Author author) {
		return dao.addAuthor(author);
	}

	public Author updateAuthor(Author author) {
		return dao.updateAuthor(author);
	}

	public boolean deleteAuthor(Integer id) {
		return dao.deleteAuthor(dao.findAuthor(id));
	}

	public Author findAuthor(Integer id) {
		return dao.findAuthor(id);
	}

}
