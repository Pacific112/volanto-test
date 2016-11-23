package pl.volanto.users;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.volanto.domain.user.UserDTO;
import pl.volanto.domain.user.UserRepository;
import pl.volanto.users.model.UserMapper;
import pl.volanto.users.model.UserRest;
import pl.volanto.users.pictures.PicturesUploader;
import pl.volanto.users.validator.LoggedUserValidator;

import java.security.Principal;
import java.util.List;

@RestController
public class UsersController {

    private final UserUpdater userUpdater;
    private final LoggedUserValidator loggedUserValidator;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UsersController(UserUpdater userUpdater, LoggedUserValidator loggedUserValidator, UserRepository userRepository, UserMapper userMapper) {
        this.userUpdater = userUpdater;
        this.loggedUserValidator = loggedUserValidator;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @PutMapping(value = "/api/users/{id}")
    public void updateUser(@RequestBody UserRest userRest,
                           @PathVariable("id") UserDTO userToUpdate,
                           Principal principal) {
        loggedUserValidator.validateLoggedUserRequest(userToUpdate, principal);
        userUpdater.updateUser(userRest, userToUpdate);
    }

    @GetMapping(value = "/api/users/{id}")
    public UserRest getUserDetails(@PathVariable("id") UserDTO userToGet, Principal principal) {
        loggedUserValidator.validateLoggedUserRequest(userToGet, principal);

        return userMapper.mapToRest(userToGet);
    }

    @GetMapping(value = "/api/admin/users")
    @Secured("ROLE_ADMIN")
    public List<UserRest> getUsers() {
        List<UserDTO> all = userRepository.findAll();
        return userMapper.mapToRest(all);
    }
}