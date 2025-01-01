package model;

import strategy.LoanCostStrategy;
import strategy.TextbookLoanCostStrategy;

public class TextBook extends Book {
    public TextBook(int bookId, String title, String author, String isbn, String genre, int yearPublished, double loanFee) {
        super(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }

    @Override
    protected LoanCostStrategy setLoanCostStrategy() {
        return new TextbookLoanCostStrategy();
    }
}
