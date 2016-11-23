package pl.volanto.registration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.volanto.domain.firm.Firm;
import pl.volanto.domain.firm.FirmProvider;
import pl.volanto.domain.user.UserDTO;
import pl.volanto.domain.user.UserRepository;
import pl.volanto.registration.model.RegistrationUserRest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserCreatorTest {

    @InjectMocks
    private UserCreator testObj;
    @Mock
    private FirmProvider firmProvider;
    @Mock
    private UserRepository userRepository;
    @Captor
    private ArgumentCaptor<UserDTO> userCaptor;

    @Test
    public void shouldCreateNewUser() {
        // given
        Firm currentFirm = new Firm("currentFirm");
        when(firmProvider.getCurrentFirm()).thenReturn(currentFirm);

        RegistrationUserRest userToRegister = new RegistrationUserRest("firstName", "lastName", "mail@mail", 123456, "password");

        // when
        testObj.createNewUser(userToRegister);

        // then
        verify(userRepository).save(userCaptor.capture());

        UserDTO savedUser = userCaptor.getValue();
        assertThat(savedUser.getFirstName()).isEqualTo(userToRegister.getFirstName());
        assertThat(savedUser.getLastName()).isEqualTo(userToRegister.getLastName());
        assertThat(savedUser.getEmail()).isEqualTo(userToRegister.getEmail());
        assertThat(savedUser.getPhoneNumber()).isEqualTo(userToRegister.getPhoneNumber());
        assertThat(savedUser.getPassword()).isEqualTo(userToRegister.getPassword());
        assertThat(savedUser.getFirm()).isEqualTo(currentFirm);
    }
}