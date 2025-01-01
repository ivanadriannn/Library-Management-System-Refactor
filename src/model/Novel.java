package model;

import strategy.LoanCostStrategy;
import strategy.NovelLoanCostStrategy;

public class Novel extends Book {
    public Novel(int bookId, String title, String author, String isbn, String genre, int yearPublished, double loanFee) {
        super(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }

    @Override
    protected LoanCostStrategy setLoanCostStrategy() {
        return new NovelLoanCostStrategy();
    }
}
