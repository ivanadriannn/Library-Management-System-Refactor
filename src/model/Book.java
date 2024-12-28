package model;

import state.AvailableState;
import state.BookState;

public abstract class Book {
    private int bookId;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private int yearPublished;
    private double loanFee;
    private BookState state;

    public Book(int bookId, String title, String author, String isbn, String genre, int yearPublished, double loanFee) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.loanFee = loanFee;
        this.state = new AvailableState(); // Initial state
    }

    public abstract double calculateLoan(int loanDays);

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public double getLoanFee() {
        return loanFee;
    }

    public void setLoanFee(double loanFee) {
        this.loanFee = loanFee;
    }

    public BookState getState() {
        return state;
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public void changeState() {
        state.changeState(this);
    }

    public void displayInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Genre: " + genre);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Loan Fee: " + loanFee);
        System.out.println("State: " + state.getName());
        System.out.println("-------------------------");
    }
}
