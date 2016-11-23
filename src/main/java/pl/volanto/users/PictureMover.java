package pl.volanto.users;

import org.springframework.stereotype.Component;
import pl.volanto.files.FilesWrapper;
import pl.volanto.paths.ApplicationPathsProvider;
import pl.volanto.properties.PropertiesProvider;

import java.nio.file.Path;
import java.util.UUID;

@Component
public class PictureMover {

    private final FilesWrapper filesWrapper;
    private final ApplicationPathsProvider applicationPathsProvider;

    public PictureMover(FilesWrapper filesWrapper, ApplicationPathsProvider applicationPathsProvider) {
        this.filesWrapper = filesWrapper;
        this.applicationPathsProvider = applicationPathsProvider;
    }

    public Path movePicture(Path picturePath) {

        String randomFileName = UUID.randomUUID().toString();
        Path newPicturePath = applicationPathsProvider.resolveWithPicturePath(randomFileName);

        Path tempPicure = applicationPathsProvider.resolveWithTempPath(picturePath);
        return filesWrapper.move(tempPicure, newPicturePath);
    }

}
