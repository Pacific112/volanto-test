package pl.volanto.users;

import org.springframework.stereotype.Component;
import pl.volanto.domain.user.UserDTO;
import pl.volanto.domain.user.UserDtoBuilder;
import pl.volanto.domain.user.UserRepository;
import pl.volanto.users.model.UserRest;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class UserUpdater {

    private final UserRepository userRepository;
    private final PictureMover pictureMover;

    public UserUpdater(UserRepository userRepository, PictureMover pictureMover) {
        this.userRepository = userRepository;
        this.pictureMover = pictureMover;
    }

    public void updateUser(UserRest user, UserDTO userToUpdate) {

        Path movedPicture = pictureMover.movePicture(Paths.get(user.getPicturePath()));

        UserDTO userDTO = new UserDtoBuilder()
                .withId(userToUpdate.getId())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmail(userToUpdate.getEmail())
                .withPhoneNumber(user.getPhoneNumber())
                .withFirm(userToUpdate.getFirm())
                .withPicturePath(movedPicture.getFileName().toString())
                .withAdmin(userToUpdate.isAdmin())
                .build();

        userRepository.save(userDTO);
    }
}
