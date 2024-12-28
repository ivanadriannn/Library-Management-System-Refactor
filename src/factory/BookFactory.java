package factory;

import model.Book;

public abstract class BookFactory {
    public abstract Book createBook(int bookId, String title, String author, String isbn, String genre, int yearPublished, double loanFee);
}
