package pl.volanto.contacts;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.volanto.contacts.model.ContactMapper;
import pl.volanto.contacts.model.ContactRest;
import pl.volanto.contacts.validation.UserContactValidator;
import pl.volanto.domain.contact.Contact;
import pl.volanto.domain.contact.ContactsRepository;
import pl.volanto.domain.user.UserDTO;
import pl.volanto.users.validator.LoggedUserValidator;

import java.security.Principal;
import java.util.List;

@RestController
public class ContactsController {

    private final ContactsRepository contactsRepository;
    private final LoggedUserValidator loggedUserValidator;
    private final UserContactValidator userContactValidator;
    private final ContactMapper contactMapper;
    private final ContactUpdater contactUpdater;

    public ContactsController(ContactsRepository contactsRepository, LoggedUserValidator loggedUserValidator, UserContactValidator userContactValidator, ContactMapper contactMapper, ContactUpdater contactUpdater) {
        this.contactsRepository = contactsRepository;
        this.loggedUserValidator = loggedUserValidator;
        this.userContactValidator = userContactValidator;
        this.contactMapper = contactMapper;
        this.contactUpdater = contactUpdater;
    }

    @GetMapping(value = "/api/users/{id}/contacts")
    public List<Contact> getContacts(@PathVariable("id") UserDTO userDTO, Principal principal) {
        loggedUserValidator.validateLoggedUserRequest(userDTO, principal);

        return contactsRepository.findByUser(userDTO);
    }

    @PostMapping(value = "/api/users/{id}/contacts")
    public void createContact(@RequestBody ContactRest contactRest, @PathVariable("id") UserDTO userDTO, Principal principal) {
        loggedUserValidator.validateLoggedUserRequest(userDTO, principal);

        Contact contact = contactMapper.mapToContact(contactRest, userDTO);
        contactsRepository.save(contact);
    }

    @PutMapping(value = "/api/users/{id}/contacts/{contact_id}")
    public void updateContact(@PathVariable("id") UserDTO userDTO,
                              @PathVariable("contact_id") Contact contactDto,
                              @RequestBody ContactRest contactRest,
                              Principal principal) {
        loggedUserValidator.validateLoggedUserRequest(userDTO, principal);
        userContactValidator.validateIsUserContact(userDTO, contactDto);

        contactUpdater.updateContact(contactDto, contactRest);
    }

    @DeleteMapping(value = "/api/users/{id}/contacts/{contact_id}")
    public void deleteContact(@PathVariable("id") UserDTO userDTO, @PathVariable("contact_id") Contact contact, Principal principal) {
        loggedUserValidator.validateLoggedUserRequest(userDTO, principal);
        userContactValidator.validateIsUserContact(userDTO, contact);

        contactsRepository.delete(contact);
    }
}
