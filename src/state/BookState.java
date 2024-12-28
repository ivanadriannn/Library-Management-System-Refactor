package state;

import model.Book;

public abstract class BookState {
	private String name;
	
	public abstract void changeState(Book book);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

