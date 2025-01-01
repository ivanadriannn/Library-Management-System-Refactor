package strategy;

import model.Book;

public interface LoanCostStrategy {
    double calculateLoanCost(Book book, int loanDays);  
}
