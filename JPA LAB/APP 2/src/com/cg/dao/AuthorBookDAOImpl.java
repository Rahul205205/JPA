package com.capg.dao;
import com.capg.DBUtil.Db;
import com.capg.entities.Book;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



public class AuthorBookDAOImpl implements AuthorBookDAO {
	
	Db con;
	EntityManager manager;
	
	public AuthorBookDAOImpl() {
		con=new Db();
		manager=con.getManager();
	}
	@Override
	public List<Book> getAllBooks() {//Get all the books
		String query= "select b from Book b";
		TypedQuery<Book> t= manager.createQuery(query, Book.class);
		return t.getResultList();
	}

	@Override
	public List<Book> getBooksByAuthor(String author_name) {//Get books by Author
		Query query=  manager.createQuery("select b from Book b join b.authorList a where a.authorName=:author_name");
		query.setParameter("author_name",author_name);
		return query.getResultList();
	}

	@Override
	public List<Book> getBooksByPriceRange(double min, double max) {//Get books by price range
		String query= "select b from Book b where price between "+min+" and "+max;
		TypedQuery<Book> t= manager.createQuery(query, Book.class);
		return t.getResultList();
	}

	@Override
	public List<String> getAuthorName(long b_id) {//Get Author name
		Query query=  manager.createQuery("select a.authorName from Author a join a.bookList b where b.bookIsbn=:b_id");
		query.setParameter("b_id",b_id);
		return query.getResultList();
	}

}