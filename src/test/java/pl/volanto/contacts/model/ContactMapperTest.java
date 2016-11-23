package pl.volanto.contacts.model;

import org.junit.Test;
import pl.volanto.domain.contact.Contact;
import pl.volanto.domain.user.UserDTO;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactMapperTest {

    private ContactMapper testObj = new ContactMapper();

    @Test
    public void shouldMapContacts() {
        // given
        ContactRest contactRest = new ContactRest("first", "last", "firm", "email", 123456879);
        UserDTO givenUser = new UserDTO();

        // when
        Contact result = testObj.mapToContact(contactRest, givenUser);

        // then
        assertThat(result.getFirstName()).isEqualTo(contactRest.getFirstName());
        assertThat(result.getLastName()).isEqualTo(contactRest.getLastName());
        assertThat(result.getFirmName()).isEqualTo(contactRest.getFirmName());
        assertThat(result.getEmail()).isEqualTo(contactRest.getEmail());
        assertThat(result.getUser()).isEqualTo(givenUser);
    }
}