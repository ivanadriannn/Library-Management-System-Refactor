package observer;

import model.Book;

public class BookLogger implements BookObserver {

	@Override
	public void getUpdate(Book book) {
		 System.out.println("New book added: " + book.getTitle() + " by " + book.getAuthor());
	}  
}
