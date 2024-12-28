package facade;

import java.util.Scanner;

import builder.FacultyBuilder;
import builder.NovelBuilder;
import builder.PublicMemberBuilder;
import builder.ReferenceBookBuilder;
import builder.StudentBuilder;
import builder.TextBookBuilder;
import factory.BookFactory;
import factory.FacultyFactory;
import factory.NovelFactory;
import factory.PublicMemberFactory;
import factory.ReferenceBookFactory;
import factory.StudentFactory;
import factory.TextBookFactory;
import factory.UserFactory;
import model.Book;
import model.User;
import singleton.Database;

public class LibraryFacade implements ILibraryFacade {
    private final Database library;
    Scanner sc = new Scanner(System.in);

    public LibraryFacade() {
        this.library = Database.getInstance();
    }
    
    @Override
    public void addDefaultData() {
        Book novel = new NovelBuilder()
                .withBookId(1)
                .withTitle("Great Expectations")
                .withAuthor("Charles Dickens")
                .withIsbn("ISBN1234")
                .withGenre("Novel")
                .withYearPublished(1970)
                .withLoanFee(150.00) 
                .build();

        Book textbook = new TextBookBuilder()
                .withBookId(2)
                .withTitle("Physics")
                .withAuthor("Isaac Newton")
                .withIsbn("ISBN2345")
                .withGenre("Education")
                .withYearPublished(1880)
                .withLoanFee(300.00)
                .build();

        Book referenceBook = new ReferenceBookBuilder()
                .withBookId(3)
                .withTitle("Glossary")
                .withAuthor("William Shakespeare")
                .withIsbn("ISBN6789")
                .withGenre("Reference")
                .withYearPublished(1600)
                .withLoanFee(250.00)
                .build();

        User student = new StudentBuilder()
                .withUserId(1)
                .withName("Anas")
                .withEmail("anas@nu.edu.pk")
                .withPhone("03000000000")
                .withAddress("Islamabad")
                .build();

        User faculty = new FacultyBuilder()
                .withUserId(2)
                .withName("Babar")
                .withEmail("babar@nu.edu.pk")
                .withPhone("03111111111")
                .withAddress("Lahore")
                .build();

        User publicMember = new PublicMemberBuilder()
                .withUserId(3)
                .withName("Shadab")
                .withEmail("shadab@nu.edu.pk")
                .withPhone("03222222222")
                .withAddress("Rawalpindi")
                .build();

        
        library.addBook(novel);
        library.addBook(textbook);
        library.addBook(referenceBook);

        library.addUser(student);
        library.addUser(faculty);
        library.addUser(publicMember);
    }

    @Override
    public void addBook() {
    	System.out.print("\nEnter the Type of Book:\n\"1\" for TextBook, \"2\" for Novel, \"3\" for ReferenceBook: ");
        int ty = sc.nextInt();

        while (ty > 3 || ty < 1) {
            System.out.print("Invalid Input! Enter again: ");
            ty = sc.nextInt();
        }

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter Book Publication Year: ");
        int yearPublished = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Base Loan Fee: ");
        double loanFee = sc.nextDouble();

        Book book = null;
        BookFactory bookFactory;

        switch (ty) {
            case 1:
                bookFactory = new TextBookFactory();
                book = bookFactory.createBook(bookId, title, author, isbn, genre, yearPublished, loanFee);
                break;
            case 2:
                bookFactory = new NovelFactory();
                book = bookFactory.createBook(bookId, title, author, isbn, genre, yearPublished, loanFee);
                break;
            case 3:
                bookFactory = new ReferenceBookFactory();
                book = bookFactory.createBook(bookId, title, author, isbn, genre, yearPublished, loanFee);
                break;
        }

        if (book != null) {
            library.addBook(book);
        }
    }

    @Override
    public void displayBooks() {
        System.out.println("Available books in the library:");
        library.printBooks();
    }

    @Override
    public void removeBook() {
    	System.out.print("Enter the ID of the book you want to remove: ");
        int removeBookId = sc.nextInt();
        library.removeBook(removeBookId);
    }

    @Override
    public void addUser() {
    	System.out.println("\nEnter the Type of User:");
        System.out.println("1. Student");
        System.out.println("2. Faculty");
        System.out.println("3. Public Member");
        System.out.print("Enter your choice: ");
        int userType = sc.nextInt();
        sc.nextLine();
        
        while (userType > 3 || userType< 1) 
        {
            System.out.println("Invalid Input!");
            userType = sc.nextInt();
        }

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();
        System.out.print("Enter User Email: ");
        String email = sc.nextLine();
        System.out.print("Enter User Phone Number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter User Address: ");
        String address = sc.nextLine();

        UserFactory userFactory;
        switch (userType) {
            case 1:
                userFactory = new StudentFactory();
                break;
            case 2:
                userFactory = new FacultyFactory();
                break;
            case 3:
                userFactory = new PublicMemberFactory();
                break;
            default:
                System.out.println("Invalid user type! Defaulting to Public Member.");
                userFactory = new PublicMemberFactory();
        }

        User newUser = userFactory.createUser(userId, name, email, phoneNumber, address);
        library.addUser(newUser);
    }

    @Override
    public void displayUsers() {
        System.out.println("Users in the system:");
        library.printUsers();
    }

    @Override
    public void loanBook() {
    	System.out.print("Enter User ID: ");
        int loanUserId = sc.nextInt();
        System.out.print("Enter Book ID: ");
        int loanBookId = sc.nextInt();
        System.out.print("Enter Loan Duration (days): ");
        int loanDays = sc.nextInt();
        library.loanBook(loanUserId, loanBookId, loanDays);
    }

    @Override
    public void displayUserLoans() {
    	System.out.print("Enter User ID to Print Loans: ");
        int printLoanUserId = sc.nextInt();
        library.printLoans(printLoanUserId);
    }

    @Override
    public void returnBook() {
    	System.out.print("Enter User ID: ");
        int returnUserId = sc.nextInt();
        System.out.print("Enter Book ID: ");
        int returnBookId = sc.nextInt();
        System.out.print("Enter Number of Days Late (if any): ");
        int daysLate = sc.nextInt();
        library.returnBook(returnUserId, returnBookId, daysLate);
    }
}
