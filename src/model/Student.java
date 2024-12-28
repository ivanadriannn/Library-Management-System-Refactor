package model;

public class Student extends User {
    public Student(int id, String name, String email, String phoneNumber, String address, String role) {
        super(id, name, email, phoneNumber, address, "Student");
    }
}
