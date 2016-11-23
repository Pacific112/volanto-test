package pl.volanto.domain.contact;

import pl.volanto.domain.user.UserDTO;

import javax.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String firmName;
    private String email;
    private Integer phoneNumber;

    @ManyToOne
    @JoinColumn
    private UserDTO user;

    public Contact() {
    }

    public Contact(Long id, String firstName, String lastName, String firmName, String email, Integer phoneNumber, UserDTO user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.firmName = firmName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirmName() {
        return firmName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public UserDTO getUser() {
        return user;
    }
}
