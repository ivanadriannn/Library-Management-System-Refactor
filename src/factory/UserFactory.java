package factory;

import model.User;

public abstract class UserFactory {
    public abstract User createUser(int userId, String name, String email, String phoneNumber, String address);
}
