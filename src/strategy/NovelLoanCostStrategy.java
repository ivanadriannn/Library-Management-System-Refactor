package strategy;

import model.Book;

public class NovelLoanCostStrategy implements LoanCostStrategy {

	@Override
	public double calculateLoanCost(Book book, int loanDays) {
		double loan = book.getLoanFee();
        return loan;  
	}
}

