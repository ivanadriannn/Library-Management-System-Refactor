package observer;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookSubject {
    private List<BookObserver> observers = new ArrayList<>();

    public void addObserver(BookObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Book book) {
        for (BookObserver observer : observers) {
            observer.getUpdate(book);
        }
    }
}
