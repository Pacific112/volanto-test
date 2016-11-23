package pl.volanto.users.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import pl.volanto.domain.firm.Firm;
import pl.volanto.domain.user.UserDTO;

import java.security.Principal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoggedUserValidatorTest {

    private LoggedUserValidator testObj = new LoggedUserValidator();

    @Test(expected = NotLoggedUserRequestException.class)
    public void shouldThrowNotLoggedUserRequestException_whenUserIsTryingToAccessNotHisData() {
        // given
        Principal principal = mock(Principal.class);
        String givenMail = "given@mail.com";
        String otherMail = "other@mail.eu";

        UserDTO givenUser = new UserDTO(1L, "first", "last", givenMail, 123456789, "pass", "profile/path", new Firm(), false);
        when(principal.getName()).thenReturn(otherMail);

        // when
        testObj.validateLoggedUserRequest(givenUser, principal);

    }

    @Test
    public void shouldDoNothing_whenRequestedUserIsSameAsLoggedIn() {
        // given
        Principal principal = mock(Principal.class);
        String givenMail = "given@mail.com";

        UserDTO givenUser = new UserDTO(1L, "first", "last", givenMail, 123456789, "pass", "profile/path", new Firm(), false);
        when(principal.getName()).thenReturn(givenMail);

        // when
        testObj.validateLoggedUserRequest(givenUser, principal);
    }
}