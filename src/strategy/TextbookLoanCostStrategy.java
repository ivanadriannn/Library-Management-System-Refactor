package strategy;

import model.Book;

public class TextbookLoanCostStrategy implements LoanCostStrategy {
	@Override
	public double calculateLoanCost(Book book, int loanDays) {
		double loan = book.getLoanFee() + (loanDays * 2);
		return loan;
	}
}

