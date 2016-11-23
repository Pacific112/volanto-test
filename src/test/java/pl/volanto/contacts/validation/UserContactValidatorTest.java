package pl.volanto.contacts.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.volanto.domain.contact.Contact;
import pl.volanto.domain.contact.ContactsRepository;
import pl.volanto.domain.user.UserDTO;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserContactValidatorTest {

    @InjectMocks
    private UserContactValidator testObj;
    @Mock
    private ContactsRepository contactsRepository;

    @Test
    public void shouldDoNothing_whenContactBelongsToUser() {
        // given
        UserDTO givenUser = new UserDTO();
        Contact userContact = new Contact();

        when(contactsRepository.findByUser(givenUser)).thenReturn(Collections.singletonList(userContact));

        // when
        testObj.validateIsUserContact(givenUser, userContact);
    }

    @Test(expected = NotUserContactException.class)
    public void shouldThrowNotUserContact_whenUserIsTryingToAccessOtherUserContacts() {
        // given
        UserDTO givenUser = new UserDTO();
        Contact otherContact = new Contact();
        Contact userContact = new Contact();

        when(contactsRepository.findByUser(givenUser)).thenReturn(Collections.singletonList(otherContact));

        // when
        testObj.validateIsUserContact(givenUser, userContact);
    }
}