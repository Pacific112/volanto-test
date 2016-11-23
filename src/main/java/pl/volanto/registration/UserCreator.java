package pl.volanto.registration;

import org.springframework.stereotype.Component;
import pl.volanto.domain.firm.Firm;
import pl.volanto.domain.firm.FirmProvider;
import pl.volanto.domain.user.UserDTO;
import pl.volanto.domain.user.UserDtoBuilder;
import pl.volanto.domain.user.UserRepository;
import pl.volanto.registration.model.RegistrationUserRest;
import pl.volanto.users.model.UserRest;

@Component
public class UserCreator {

    private final FirmProvider firmProvider;
    private final UserRepository userRepository;

    public UserCreator(FirmProvider firmProvider, UserRepository userRepository) {
        this.firmProvider = firmProvider;
        this.userRepository = userRepository;
    }

    public void createNewUser(RegistrationUserRest user) {
        Firm currentFirm = firmProvider.getCurrentFirm();
        UserDTO crmUserToRegister = new UserDtoBuilder()
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmail(user.getEmail())
                .withPassword(user.getPassword())
                .withPhoneNumber(user.getPhoneNumber())
                .withFirm(currentFirm)
                .build();

        userRepository.save(crmUserToRegister);
    }
}
