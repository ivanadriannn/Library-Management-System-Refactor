package model;

import java.time.LocalDate;

public class Loan {
    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate dueDate;
    
    public Loan(User user, Book book, int loanDays) {
        this.user = user;
        this.book = book;
        this.loanDate = LocalDate.now();
        this.dueDate = loanDate.plusDays(loanDays);
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double calculateLateFee(int daysLate) {

	    double lateFee = 0.0;
	    
	    if (daysLate > 0) { 
	        lateFee = daysLate * 10.00;  
	        user.setTotalLoanFee(user.getTotalLoanFee() + lateFee);  
	    }

	    System.out.println("Book '" + book.getTitle() + "' has been returned by " + user.getName());

	    return lateFee;  
	}

    public void displayLoanDetails() {
        System.out.println("Loan Details:");
        System.out.println("User: " + user.getName());
        System.out.println("Book: " + book.getBookId() + " - " + book.getTitle());
        System.out.println("Loan Date: " + loanDate);
        System.out.println("Due Date: " + dueDate);
    }
}
