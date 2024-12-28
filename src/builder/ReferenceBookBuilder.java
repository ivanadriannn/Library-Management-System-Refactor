package builder;

import model.ReferenceBook;

public class ReferenceBookBuilder extends BaseBookBuilder {

    @Override
    public ReferenceBook build() {
        return new ReferenceBook(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }
}
