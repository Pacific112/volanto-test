package pl.volanto.users;

import org.springframework.stereotype.Component;
import pl.volanto.files.FilesWrapper;
import pl.volanto.properties.PropertiesProvider;

import java.nio.file.Path;
import java.util.UUID;

@Component
public class PictureMover {

    private final FilesWrapper filesWrapper;
    private final PropertiesProvider propertiesProvider;

    public PictureMover(FilesWrapper filesWrapper, PropertiesProvider propertiesProvider) {
        this.filesWrapper = filesWrapper;
        this.propertiesProvider = propertiesProvider;
    }

    public Path movePicture(Path picturePath) {

        Path tempPath = propertiesProvider.getTempPath();
        Path picturesPath = propertiesProvider.getProfilePicturesPath();
        Path newPicturePath = picturesPath.resolve(UUID.randomUUID().toString());

        Path tempPicure = tempPath.resolve(picturePath);
        return filesWrapper.move(tempPicure, newPicturePath);
    }

}
