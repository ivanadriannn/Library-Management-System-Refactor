package model;

public class PublicMember extends User {
    private double basefee; 

    public PublicMember(int id, String name, String email, String phoneNumber, String address, String role) {
        super(id, name, email, phoneNumber, address, "Public Member");
        this.basefee = 1.5;  
    }
}
