package pl.volanto.registration;

import org.springframework.web.bind.annotation.*;
import pl.volanto.registration.model.RegistrationUserRest;
import pl.volanto.registration.validator.UserNotExistsValidator;
import pl.volanto.users.model.UserRest;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private final UserNotExistsValidator userNotExistsValidator;
    private final UserCreator userCreator;

    public RegistrationController(UserNotExistsValidator userNotExistsValidator, UserCreator userCreator) {
        this.userNotExistsValidator = userNotExistsValidator;
        this.userCreator = userCreator;
    }

    @PostMapping(value = "/registration")
    public void registerUser(@RequestBody @Valid RegistrationUserRest user) {
        userNotExistsValidator.validateUserNotExists(user);
        userCreator.createNewUser(user);
    }
}