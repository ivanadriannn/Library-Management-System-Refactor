package singleton;

import model.Book;
import model.Loan;
import model.Novel;
import model.ReferenceBook;
import model.TextBook;
import model.User;
import observer.BookLogger;
import observer.BookSubject;
import observer.RoleNotifier;
import state.AvailableState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {
    private static Database instance;
    private List<Book> books;
    private List<User> users;
    private List<Loan> loans;
    private BookSubject publisher;
    private RoleNotifier roleNotifier;

    private Database() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loans = new ArrayList<>();

        publisher = new BookSubject();
        publisher.addObserver(new BookLogger());

        if (roleNotifier == null) {
            roleNotifier = new RoleNotifier(users);
            publisher.addObserver(roleNotifier);
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void setPublisher(BookSubject publisher) {
        this.publisher = publisher;
    }

    public void addBook(Book book) {
        if (findBookById(book.getBookId()) != null) {
            System.out.println("Book with ID " + book.getBookId() + " already exists.");
            return;
        }

        books.add(book);
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());

        publisher.notifyObservers(book);
    }

    public void addUser(User user) {
        if (findUserById(user.getUserId()) != null) {
            System.out.println("User with ID " + user.getUserId() + " already exists.");
            return;
        }

        users.add(user);
        System.out.println("User added: " + user.getName() + " (" + user.getRole() + ")");
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getBookId() == bookId);
        System.out.println("Book removed successfully.");
    }

    public void printBooks() {
    	System.out.println("Available Books:");
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            book.displayInfo(); 
        }
    }

    public void printUsers() {
        System.out.println("Registered Users:");
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
        	User user = iterator.next();
            user.displayInfo(); 
        }
    }

    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void loanBook(int userId, int bookId, int loanDays) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user != null && book != null) {
            if (!(book.getState() instanceof AvailableState)) {
                System.out.println("The book '" + book.getTitle() + "' is not available for loan.");
                return;
            }

            if (book instanceof ReferenceBook) {
                System.out.println("The book '" + book.getTitle() + "' is a reference book and cannot be loaned.");
                return;
            }

            double loanFee = 0.0;

            if (book instanceof Novel) {
                Novel novel = (Novel) book; // Casting ke Novel
                loanFee = novel.calculateLoan(loanDays); 
            } else if (book instanceof TextBook) {
                TextBook textbook = (TextBook) book; // Casting ke TextBook
                loanFee = textbook.calculateLoan(loanDays); 
            } else if (book instanceof ReferenceBook) {
                ReferenceBook referenceBook = (ReferenceBook) book; // Casting ke ReferenceBook
                loanFee = referenceBook.calculateLoan(loanDays);
                if (loanFee == 0.0) {
                    System.out.println("This reference book cannot be loaned.");
                    return;
                }
            } else {
                System.out.println("Unknown book type.");
                return;
            }

            Loan loan = new Loan(user, book, loanDays);
            loans.add(loan);
            book.changeState();

            System.out.println("Book '" + book.getTitle() + "' has been loaned to " + user.getName());
            System.out.println("Total loan fee: $" + loanFee);
        } else {
            System.out.println("Invalid User ID or Book ID.");
        }
    }


    public void returnBook(int userId, int bookId, int daysLate) {
        Loan loanToReturn = null;
        for (Loan loan : loans) {
            if (loan.getUser().getUserId() == userId && loan.getBook().getBookId() == bookId) {
                loanToReturn = loan;

                double lateFee = loan.calculateLateFee(daysLate);
                System.out.println("Late fee for returning book '" + loan.getBook().getTitle() + "': $" + lateFee);

                loans.remove(loan);

                loan.getBook().setState(new AvailableState());  

                System.out.println("Book returned successfully and is now available.");
                break;
            }
        }

        if (loanToReturn == null) {
            System.out.println("No such loan found.");
        }
    }
    
    public void printLoans(int userId) {
        System.out.println("Loan Details for User ID: " + userId);
        for (Loan loan : loans) {
            if (loan.getUser().getUserId() == userId) {
                loan.displayLoanDetails();
            }
        }
    }
}
