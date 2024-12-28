package model;

public class Novel extends Book {
    public Novel(int bookId, String title, String author, String isbn, String genre, int yearPublished, double loanFee) {
        super(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }

	@Override
	public double calculateLoan(int loanDays) {
		double loan = getLoanFee();
        return loan; 	
	}
}
