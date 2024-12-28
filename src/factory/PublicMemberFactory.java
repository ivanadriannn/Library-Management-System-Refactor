package factory;

import model.PublicMember;

public class PublicMemberFactory extends UserFactory {
    @Override
    public PublicMember createUser(int userId, String name, String email, String phoneNumber, String address) {
        return new PublicMember(userId, name, email, phoneNumber, address, "Public Member");  // Return PublicMember instead of User
    }
}
