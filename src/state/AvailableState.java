package state;

import model.Book;

public class AvailableState extends BookState {

    public AvailableState() {
        setName("Available");
    }

    @Override
    public void changeState(Book book) {
        System.out.println("The book is now loaned.");
        book.setState(new LoanedState());
    }
}
