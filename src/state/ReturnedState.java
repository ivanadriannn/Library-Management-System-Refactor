package state;

import model.Book;

public class ReturnedState extends BookState {

    public ReturnedState() {
        setName("Returned");
    }

    @Override
    public void changeState(Book book) {
        System.out.println("The book is now available for loan.");
        book.setState(new AvailableState());
    }
}
