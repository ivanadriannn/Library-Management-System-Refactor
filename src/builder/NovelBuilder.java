package builder;

import model.Novel;

public class NovelBuilder extends BaseBookBuilder {

    @Override
    public Novel build() {
        return new Novel(bookId, title, author, isbn, genre, yearPublished, loanFee);
    }
}
