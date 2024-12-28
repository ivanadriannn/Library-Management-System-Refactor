package state;

import model.Book;

public class LoanedState extends BookState {

    public LoanedState() {
        setName("Loaned");
    }

    @Override
    public void changeState(Book book) {
        System.out.println("The book has been returned.");
        book.setState(new ReturnedState());
    }
}
