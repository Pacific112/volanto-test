package pl.volanto.registration.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.volanto.domain.user.UserDTO;
import pl.volanto.domain.user.UserRepository;
import pl.volanto.registration.model.RegistrationUserRest;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserNotExistsValidatorTest {

    @InjectMocks
    private UserNotExistsValidator testObj;
    @Mock
    private UserRepository userRepository;

    @Test
    public void shouldDoNothing_whenUserDoesNotExists() {
        // given
        String givenEmail = "given@email.pl";
        RegistrationUserRest registrationUser = new RegistrationUserRest("first", "last", givenEmail, 123456789, "pass");

        when(userRepository.findByEmail(givenEmail)).thenReturn(Optional.empty());

        // when
        testObj.validateUserNotExists(registrationUser);

    }

    @Test(expected = UserExistsException.class)
    public void shouldThrowException_whenUserAlreadyExists() {
        // given
        String givenEmail = "given@email.pl";
        RegistrationUserRest registrationUser = new RegistrationUserRest("first", "last", givenEmail, 123456789, "pass");

        when(userRepository.findByEmail(givenEmail)).thenReturn(Optional.of(new UserDTO()));

        // when
        testObj.validateUserNotExists(registrationUser);

    }
}