package pl.volanto.contacts.model;

import org.springframework.stereotype.Component;
import pl.volanto.domain.contact.Contact;
import pl.volanto.domain.contact.ContactBuilder;
import pl.volanto.domain.user.UserDTO;

@Component
public class ContactMapper {

    public Contact mapToContact(ContactRest contactRest, UserDTO userDTO) {
        return new ContactBuilder()
                .withFirstName(contactRest.getFirstName())
                .withLastName(contactRest.getLastName())
                .withFirmName(contactRest.getFirmName())
                .withEmail(contactRest.getEmail())
                .withPhoneNumber(contactRest.getPhoneNumber())
                .withUser(userDTO)
                .build();
    }
}
