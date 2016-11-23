package pl.volanto.contacts.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactRest {

    private final String firstName;
    private final String lastName;
    private final String firmName;
    private final String email;
    private final Integer phoneNumber;

    @JsonCreator
    public ContactRest(@JsonProperty("firstName") String firstName,
                       @JsonProperty("lastName") String lastName,
                       @JsonProperty("firmName") String firmName,
                       @JsonProperty("email") String email,
                       @JsonProperty("phoneNumber") Integer phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.firmName = firmName;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
}
