package builder;

import model.User;

public class PublicMemberBuilder extends BaseUserBuilder {
    public PublicMemberBuilder() {
        this.role = "Public Member";
    }

    @Override
    public User build() {
        return new User(userId, name, email, phone, address, role);
    }
}
