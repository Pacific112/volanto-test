package pl.volanto.users.validator;

import org.springframework.stereotype.Component;
import pl.volanto.domain.user.UserDTO;

import java.security.Principal;

@Component
public class LoggedUserValidator {

    public void validateLoggedUserRequest(UserDTO requestedUser, Principal principal) {
        if (!requestedUser.getEmail().equals(principal.getName())) {
            throw new NotLoggedUserRequestException();
        }
    }
}
