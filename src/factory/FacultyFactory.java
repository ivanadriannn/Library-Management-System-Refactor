package factory;

import model.User;

public class FacultyFactory extends UserFactory {
    @Override
    public User createUser(int userId, String name, String email, String phoneNumber, String address) {
        return new User(userId, name, email, phoneNumber, address, "Faculty"); 
    }
}
