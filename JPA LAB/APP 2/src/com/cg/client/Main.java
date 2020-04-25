package com.capg.client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.capg.entities.Author;
import com.capg.entities.Book;
import com.capg.service.AuthorBookServiceImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		AuthorBookServiceImpl service = new AuthorBookServiceImpl();
		List<Book> list;
		List<String> list1;
		String choice;
		String authorName;
		double min,max;
		while(true) {
		
			System.out.println("Enter your choice");
			System.out.println("Press1) Get all the books");
			System.out.println("Press2) Get books by author");
			System.out.println("Press3) Get books by price range");
			System.out.println("Press4) Get author name");
			System.out.println("Press5) Exit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice=br.readLine();
			switch(choice) {
					
					
			case "1": list=service.getAllBooks();//Get all the books
						for(Book b: list)
							System.out.println(b.getBookIsbn()+"\t"+b.getPrice()+"\t"+b.getTitle());
					  break;
			
			case "2": System.out.println("Enter the author name");//Get book by author
					  authorName=br.readLine();
					  list=service.getBooksByAuthor(authorName);
						for(Book b: list)
						System.out.println(b.getTitle());
					  break;
			case "3": System.out.println("Enter the price range");//Get Books by price range
						min=Double.parseDouble(br.readLine());
						max=Double.parseDouble(br.readLine());
						list=service.getBooksByPriceRange(min, max);
						for(Book b: list)
							System.out.println(b.getBookIsbn()+"\t"+b.getPrice()+"\t"+b.getTitle());
						break;
			case "4": 	System.out.println("Enter the book id");//Get book by Id
						list1=service.getAuthorName(Long.parseLong(br.readLine()));
						for(String s: list1)
							System.out.println(s);
						break;
			case "5":   System.exit(0);//Exit program

			default:    System.out.println("Enter Valid Choice");
			}
			
			
		}
			
	}

}
