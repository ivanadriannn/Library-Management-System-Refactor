package model;

public class TextBook extends Book {
    public TextBook(int bookId, String title, String author, String isbn, String genre, int yearPublished, double loanFee) {
        super(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }

	@Override
	public double calculateLoan(int loanDays) {
		double loan = getLoanFee() + (loanDays * 2);
		return loan;
	}
}
