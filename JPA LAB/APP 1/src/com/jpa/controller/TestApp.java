package com.jpa.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.jpa.entities.Author;
import com.jpa.service.AuthorServiceImpl;

public class TestApp {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		AuthorServiceImpl service = new AuthorServiceImpl();
		try {
			while(true) {
				System.out.println("Press1) Enter New Author");
				System.out.println("Press2) Update Author");
				System.out.println("Press3) Delete Author");
				System.out.println("Press4) Exit");
				System.out.println("Enter your choice:-");
				String choice = null;
				choice = br.readLine();
				switch(choice) {
					case "1":
					//Adding Author
						Author authorobj = new Author();
						System.out.println("Enter firstname");
						authorobj.setFirstName(br.readLine());
						System.out.println("Enter middlename");
						authorobj.setMiddleName(br.readLine());
						System.out.println("Enter lastname");
						authorobj.setLastName(br.readLine());
						System.out.println("Enter phone number");
						authorobj.setPhoneNo(br.readLine());
						if(service.addAuthor(authorobj)) {
							System.out.println("author added");
						}else {
							System.out.println("author not added");
						}
						break;
					case "2":
						System.out.println("Enter author id");
						Integer id = Integer.parseInt(br.readLine());
						authorobj = service.findAuthor(id);
						if(authorobj != null) {
							System.out.println("Author eixst");
							System.out.println(authorobj.toString());
							Author temp = new Author();
							temp.setAuthorId(authorobj.getAuthorId());
							System.out.println("Enter firstname");
							temp.setFirstName(br.readLine());
							System.out.println("Enter middlename");
							temp.setMiddleName(br.readLine());
							System.out.println("Enter lastname");
							temp.setLastName(br.readLine());
							System.out.println("Enter phone number");
							temp.setPhoneNo(br.readLine());
							if(service.updateAuthor(temp)!=null) {
								System.out.println("Author updated");
							}else {
								System.out.println("Not updated");
							}
						}else {
							System.out.println("Author does not exist");
						}
						break;
					case "3":
					
						System.out.println("Enter author id");
						id = Integer.parseInt(br.readLine());
						if(service.deleteAuthor(id)) {
							System.out.println("Author deleted succesfully");
						}else {
							System.out.println("Author not deleted");
						}
						break;
					default:
						System.exit(0);
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
