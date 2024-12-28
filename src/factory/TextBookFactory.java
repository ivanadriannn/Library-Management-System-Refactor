package factory;

import model.Book;
import model.TextBook;

public class TextBookFactory extends BookFactory {
    @Override
    public Book createBook(int bookId, String title, String author, String isbn, String genre, int yearPublished, double loanFee) {
        return new TextBook(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }
}
