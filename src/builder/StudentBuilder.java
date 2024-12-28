package builder;

import model.User;

public class StudentBuilder extends BaseUserBuilder {
    public StudentBuilder() {
        this.role = "Student";
    }

    @Override
    public User build() {
        return new User(userId, name, email, phone, address, role);
    }
}
