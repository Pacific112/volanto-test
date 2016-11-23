package pl.volanto.users;

import org.springframework.stereotype.Component;
import pl.volanto.domain.user.UserDTO;
import pl.volanto.domain.user.UserDtoBuilder;
import pl.volanto.domain.user.UserRepository;
import pl.volanto.files.FilesWrapper;
import pl.volanto.properties.PropertiesProvider;
import pl.volanto.users.model.UserRest;

import java.nio.file.Path;
import java.util.UUID;

@Component
public class UserUpdater {

    private final UserRepository userRepository;
    private final FilesWrapper filesWrapper;
    private final PropertiesProvider propertiesProvider;

    public UserUpdater(UserRepository userRepository, FilesWrapper filesWrapper, PropertiesProvider propertiesProvider) {
        this.userRepository = userRepository;
        this.filesWrapper = filesWrapper;
        this.propertiesProvider = propertiesProvider;
    }

    public void updateUser(UserRest user, UserDTO userToUpdate) {

        Path tempPath = propertiesProvider.getTempPath();
        Path picturesPath = propertiesProvider.getProfilePicturesPath();
        Path newPicturePath = picturesPath.resolve(UUID.randomUUID().toString());

        Path tempPicure = tempPath.resolve(user.getPicturePath());
        Path movedPicture = filesWrapper.move(tempPicure, newPicturePath);


        UserDTO userDTO = new UserDtoBuilder()
                .withId(userToUpdate.getId())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmail(user.getEmail())
                .withPhoneNumber(user.getPhoneNumber())
                .withFirm(userToUpdate.getFirm())
                .withPicturePath(movedPicture.getFileName().toString())
                .build();

        userRepository.save(userDTO);
    }


}
