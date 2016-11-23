package pl.volanto.contacts.validation;

import org.springframework.stereotype.Component;
import pl.volanto.domain.contact.Contact;
import pl.volanto.domain.contact.ContactsRepository;
import pl.volanto.domain.user.UserDTO;

import java.util.List;

@Component
public class UserContactValidator {

    private final ContactsRepository contactsRepository;

    public UserContactValidator(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public void validateIsUserContact(UserDTO userDTO, Contact contact) {
        List<Contact> contacts = contactsRepository.findByUser(userDTO);
        if (!contacts.contains(contact)) {
            throw new NotUserContactException();
        }
    }
}
