package builder;

import model.Book;

public abstract class BaseBookBuilder {
    protected int bookId;
    protected String title;
    protected String author;
    protected String isbn;
    protected String genre;
    protected int yearPublished;
    protected double loanFee;

    public BaseBookBuilder withBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public BaseBookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BaseBookBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public BaseBookBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BaseBookBuilder withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public BaseBookBuilder withYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
        return this;
    }

    public BaseBookBuilder withLoanFee(double loanFee) {
        this.loanFee = loanFee;
        return this;
    }

    public abstract Book build(); 
}
