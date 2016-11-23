package pl.volanto.registration.validator;

import org.springframework.stereotype.Component;
import pl.volanto.domain.user.UserRepository;
import pl.volanto.registration.model.RegistrationUserRest;
import pl.volanto.users.model.UserRest;

@Component
public class UserNotExistsValidator {

    private final UserRepository userRepository;

    public UserNotExistsValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateUserNotExists(RegistrationUserRest user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserExistsException();
        }
    }
}