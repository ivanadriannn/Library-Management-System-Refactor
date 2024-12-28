package facade;

public interface ILibraryFacade {
	void addDefaultData();
    void addBook();
    void displayBooks();
    void removeBook();
    void addUser();
    void displayUsers();
    void loanBook();
    void displayUserLoans();
    void returnBook();
}
