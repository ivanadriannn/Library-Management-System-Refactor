package factory;

import model.Book;
import model.Novel;

public class NovelFactory extends BookFactory {
    @Override
    public Book createBook(int bookId, String title, String author, String isbn, String genre, int yearPublished, double loanFee) {
        return new Novel(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }
}
