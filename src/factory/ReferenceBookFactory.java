package factory;

import model.Book;
import model.ReferenceBook;

public class ReferenceBookFactory extends BookFactory {
    @Override
    public Book createBook(int bookId, String title, String author, String isbn, String genre, int yearPublished, double loanFee) {
        return new ReferenceBook(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }
}
