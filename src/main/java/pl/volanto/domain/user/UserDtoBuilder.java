package pl.volanto.domain.user;

import pl.volanto.domain.firm.Firm;

public class UserDtoBuilder {

    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String password;
    private Firm firm;
    private String picturePath;
    private boolean isAdmin;

    public UserDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UserDtoBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDtoBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDtoBuilder withPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserDtoBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDtoBuilder withFirm(Firm firm) {
        this.firm = firm;
        return this;
    }

    public UserDtoBuilder withPicturePath(String picturePath) {
        this.picturePath = picturePath;
        return this;
    }

    public UserDtoBuilder withAdmin(boolean admin) {
        isAdmin = admin;
        return this;
    }

    public UserDTO build() {
        return new UserDTO(id, firstName, lastName, email, phoneNumber, password, picturePath, firm, isAdmin);
    }
}
