package model;

import java.util.ArrayList;

public class User {
    private int userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private double totalLoanFee; 
    private String role;
    private ArrayList<Book> loanedBooks;  

    public User(int userId, String name, String email, String phoneNumber, String address, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
        this.loanedBooks = new ArrayList<>();  
        this.totalLoanFee = 0.0;
    }

    public void loanBook(Book book, double loanFee) {
        loanedBooks.add(book);
        setTotalLoanFee(getTotalLoanFee() + loanFee); 
    }

    public String getName() {
        return name;
    }

    public double getTotalLoanFee() {
        return totalLoanFee;
    }

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setTotalLoanFee(double totalLoanFee) {
        this.totalLoanFee = totalLoanFee;
    }

    public void displayInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("-------------------------");
    }
}
