package pl.volanto.registration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class RegistrationUserRest {

    @NotNull
    @NotEmpty
    private final String firstName;

    @NotNull
    @NotEmpty
    private final String lastName;

    @NotNull
    @NotEmpty
    private final String email;

    private final Integer phoneNumber;

    @NotNull
    @NotEmpty
    private final String password;

    public RegistrationUserRest(@JsonProperty("firstName") String firstName,
                                @JsonProperty("lastName") String lastName,
                                @JsonProperty("email") String email,
                                @JsonProperty("phoneNumber") Integer phoneNumber,
                                @JsonProperty("password") String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
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
}
