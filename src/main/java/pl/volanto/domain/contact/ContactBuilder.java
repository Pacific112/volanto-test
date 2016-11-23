package pl.volanto.domain.contact;

import pl.volanto.domain.user.UserDTO;

public class ContactBuilder {

    private Long id;
    private String firstName;
    private String lastName;
    private String firmName;
    private String email;
    private Integer phoneNumber;
    private UserDTO user;

    public ContactBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ContactBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactBuilder withFirmName(String firmName) {
        this.firmName = firmName;
        return this;
    }

    public ContactBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactBuilder withPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ContactBuilder withUser(UserDTO user) {
        this.user = user;
        return this;
    }

    public Contact build() {
        return new Contact(id, firstName, lastName, firmName, email, phoneNumber, user);
    }
}
