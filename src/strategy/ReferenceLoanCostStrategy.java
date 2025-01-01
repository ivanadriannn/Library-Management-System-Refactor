package strategy;

import model.Book;

public class ReferenceLoanCostStrategy implements LoanCostStrategy {
	@Override
	public double calculateLoanCost(Book book, int loanDays) {
		return 0.0; // ReferenceBook cannot be loaned
	}
}

