package builder;

import model.User;

public class UserBuilder {
    private int userId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String role;

    public UserBuilder withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder withAddress(String address) {
        this.address = address;
        return this;
    }
    
    public UserBuilder withRole(String role) {
        this.role = role;
        return this;
    }

    public User build() {
        return new User(userId, name, email, phone, address, role);
    }
}
