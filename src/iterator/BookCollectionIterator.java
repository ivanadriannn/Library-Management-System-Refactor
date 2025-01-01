package iterator;

import java.util.List;
import model.Book;

public class BookCollectionIterator implements BookIterator<Book> {

    private List<Book> books;
    private int position;

    public BookCollectionIterator(List<Book> books) {
        this.books = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Book next() {
        if (hasNext()) {
            return books.get(position++);
        }
        return null;
    }
}
