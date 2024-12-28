package builder;

import model.User;

public class FacultyBuilder extends BaseUserBuilder {
    public FacultyBuilder() {
        this.role = "Faculty";
    }

    @Override
    public User build() {
        return new User(userId, name, email, phone, address, role);
    }
}
