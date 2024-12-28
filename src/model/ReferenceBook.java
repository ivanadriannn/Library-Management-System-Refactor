package model;

public class ReferenceBook extends Book {
    public ReferenceBook(int bookId, String title, String author, String isbn, String genre, int yearPublished, double loanFee) {
        super(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }

	@Override
	public double calculateLoan(int loanDays) {
		return 0.0; 	
	}
}