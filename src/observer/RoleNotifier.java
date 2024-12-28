package observer;

import model.Book;
import model.User;

import java.util.List;

public class RoleNotifier implements BookObserver {
    private List<User> users;

    public RoleNotifier(List<User> users) {
        this.users = users;
    }

    @Override
    public void getUpdate(Book book) {
        for (User user : users) {
            if ("student".equalsIgnoreCase(user.getRole()) || "faculty".equalsIgnoreCase(user.getRole())) {
                System.out.println("Notification to " + user.getRole() + " (" + user.getName() + "): "
                                   + "New book added: " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public void notifyUsersForNewBook(Book book) {
        for (User user : users) {
            if ("student".equalsIgnoreCase(user.getRole()) || "faculty".equalsIgnoreCase(user.getRole())) {
                System.out.println(user.getName() + " with role " + user.getRole() + " was notified of the new book: "
                                   + book.getTitle());
            }
        }
    }
}
