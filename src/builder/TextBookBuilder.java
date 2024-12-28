package builder;

import model.TextBook;

public class TextBookBuilder extends BaseBookBuilder {

    @Override
    public TextBook build() {
        return new TextBook(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }
}
