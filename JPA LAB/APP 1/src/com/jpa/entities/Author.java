package com.jpa.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Author")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer authorId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNo;
	
public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Author() {

	}

	public Author(Integer authorId, String firstName, String middleName, String lastName, String phoneNo) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", phoneNo=" + phoneNo + "]";
	}
	
}
//CREATE TABLE Author (
//        authorId NUMBER(25) ,
//        firstName VARCHAR2(15),
//        middleName VARCHAR2(15),
//        lastName VARCHAR2(10),
//        phoneNo NUMBER(15));
//
//select * from Author
//
//desc Author
//drop table Author
//INSERT INTO Author (authorId , firstName , middleName ,lastName ,phoneNo )
//VALUES (123, 'abc', 'abc','xyz',12780);
