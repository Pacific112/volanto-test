package pl.volanto.contacts;

import org.springframework.stereotype.Component;
import pl.volanto.contacts.model.ContactRest;
import pl.volanto.domain.contact.Contact;
import pl.volanto.domain.contact.ContactBuilder;
import pl.volanto.domain.contact.ContactsRepository;

@Component
public class ContactUpdater {

    private final ContactsRepository contactsRepository;

    public ContactUpdater(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public void updateContact(Contact contactToUpdate, ContactRest contactRest) {

        Contact contact = new ContactBuilder()
                .withId(contactToUpdate.getId())
                .withFirstName(contactRest.getFirstName())
                .withLastName(contactRest.getLastName())
                .withFirmName(contactRest.getFirmName())
                .withEmail(contactToUpdate.getEmail())
                .withPhoneNumber(contactRest.getPhoneNumber())
                .withUser(contactToUpdate.getUser())
                .build();

        contactsRepository.save(contact);
    }
}
