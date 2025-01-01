package iterator;

import java.util.List;
import model.User;

public class UserCollectionIterator implements UserIterator<User> {

    private List<User> users;
    private int position;

    public UserCollectionIterator(List<User> users) {
        this.users = users;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < users.size();
    }

    @Override
    public User next() {
        if (hasNext()) {
            return users.get(position++);
        }
        return null;
    }
}
