package com.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.entities.Author;

public class AuthorDAOImpl implements AuthorDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPALab1");
	EntityManager manager = factory.createEntityManager();

	@Override
	public boolean addAuthor(Author author) {
		try {
			manager.getTransaction().begin();
			manager.persist(author);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	// method for deleting an author
	@Override
	public boolean deleteAuthor(Author author) {
		try {
			manager.remove(author);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	// method for updating an author
	@Override
	public Author updateAuthor(Author author) {
		try {
			Author obj = findAuthor(author.getAuthorId());
			obj.setFirstName(author.getFirstName());
			obj.setLastName(author.getLastName());
			obj.setMiddleName(author.getMiddleName());
			obj.setPhoneNo(author.getPhoneNo());
			manager.getTransaction().begin();
			manager.persist(obj);
			manager.getTransaction().commit();
			
			return obj;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// method for finding an author

	@Override
	public Author findAuthor(Integer id) {
		return manager.find(Author.class, id);
	}

}
