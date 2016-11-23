package pl.volanto.domain.user;


import pl.volanto.domain.contact.Contact;
import pl.volanto.domain.firm.Firm;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String password;
    private String picturePath;

    @OneToOne
    private Firm firm;

    @OneToMany
    private List<Contact> contacts;

    private boolean isAdmin;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String email, Integer phoneNumber, String password, String picturePath, Firm firm, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.picturePath = picturePath;
        this.firm = firm;
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public Firm getFirm() {
        return firm;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
