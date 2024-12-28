package builder;

import model.User;

public abstract class BaseUserBuilder {
    protected int userId;
    protected String name;
    protected String email;
    protected String phone;
    protected String address;
    protected String role;

    public BaseUserBuilder withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public BaseUserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BaseUserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public BaseUserBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public BaseUserBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public abstract User build();
}
