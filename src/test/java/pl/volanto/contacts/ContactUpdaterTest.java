package pl.volanto.contacts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.volanto.contacts.model.ContactRest;
import pl.volanto.domain.contact.Contact;
import pl.volanto.domain.contact.ContactsRepository;
import pl.volanto.domain.user.UserDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ContactUpdaterTest {

    @InjectMocks
    private ContactUpdater testObj;
    @Mock
    private ContactsRepository contactsRepository;
    @Captor
    private ArgumentCaptor<Contact> contactCaptor;

    @Test
    public void shouldUpdateContactWithProperData() {
        // given
        long givenId = 5L;
        UserDTO givenUser = new UserDTO();

        Contact existingContact = new Contact(givenId, "first", "last", "firmName", "mail", 123456789, givenUser);
        ContactRest newContact = new ContactRest( "newFirst", "newLast", "newFirmName", "newMail", 223456789);

        // when
        testObj.updateContact(existingContact, newContact);

        // then
        verify(contactsRepository).save(contactCaptor.capture());

        Contact savedContact = contactCaptor.getValue();
        assertThat(savedContact.getFirstName()).isEqualTo(newContact.getFirstName());
        assertThat(savedContact.getLastName()).isEqualTo(newContact.getLastName());
        assertThat(savedContact.getFirmName()).isEqualTo(newContact.getFirmName());
        assertThat(savedContact.getEmail()).isEqualTo(existingContact.getEmail());
        assertThat(savedContact.getPhoneNumber()).isEqualTo(newContact.getPhoneNumber());
        assertThat(savedContact.getUser()).isEqualTo(givenUser);
        assertThat(savedContact.getId()).isEqualTo(givenId);
    }
}