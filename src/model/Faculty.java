package model;

public class Faculty extends User {
    public Faculty(int id, String name, String email, String phoneNumber, String address, String role) {
        super(id, name, email, phoneNumber, address, "Faculty");
    }
}
