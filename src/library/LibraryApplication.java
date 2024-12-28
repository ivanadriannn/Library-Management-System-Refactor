package library;

import facade.ILibraryFacade;
import facade.LibraryFacade;

import java.util.Scanner;

public class LibraryApplication {
    public static void main(String[] args) {
    	ILibraryFacade libraryFacade = new LibraryFacade();
    	Scanner sc = new Scanner(System.in);

        System.out.println("Prepopulating the Library!\n");
        libraryFacade.addDefaultData();
        
        int choice;

        do {
            System.out.println("\n~~~ Library Management System ~~~");
            System.out.println("1. Add new Book");
            System.out.println("2. Display available books");
            System.out.println("3. Remove a Book");
            System.out.println("4. Add new User");
            System.out.println("5. Display user details ");
            System.out.println("6. Loan a book to a user");
            System.out.println("7. Display loan details");
            System.out.println("8. Return a book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                	libraryFacade.addBook();
                    break;

                case 2:
                    libraryFacade.displayBooks();
                    break;

                case 3:
                	libraryFacade.removeBook();
                    break;

                case 4:
                    libraryFacade.addUser();
                    break;

                case 5:
                    libraryFacade.displayUsers();
                    break;

                case 6:
                    libraryFacade.loanBook();
                    break;

                case 7:
                	libraryFacade.displayUserLoans();
                    break;

                case 8:
                    libraryFacade.returnBook();
                    break;

                case 9:
                    System.out.println("Exiting the System!");
                    break;

                default:
                    System.out.println("Invalid Input!");
            }
        } while (choice != 9);
        sc.close();
    }
}

