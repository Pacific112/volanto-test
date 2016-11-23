package pl.volanto.users.pictures;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pl.volanto.files.FilesWrapper;
import pl.volanto.files.MultipartFileWrapper;
import pl.volanto.paths.ApplicationPathsProvider;
import pl.volanto.properties.PropertiesProvider;

import java.nio.file.Path;
import java.util.UUID;

@Component
public class PicturesUploader {

    private final PropertiesProvider propertiesProvider;
    private final FilesWrapper filesWrapper;
    private final MultipartFileWrapper multipartFileWrapper;
    private final ApplicationPathsProvider pathsProvider;

    public PicturesUploader(PropertiesProvider propertiesProvider, FilesWrapper filesWrapper, MultipartFileWrapper multipartFileWrapper, ApplicationPathsProvider pathsProvider) {
        this.propertiesProvider = propertiesProvider;
        this.filesWrapper = filesWrapper;
        this.multipartFileWrapper = multipartFileWrapper;
        this.pathsProvider = pathsProvider;
    }

    public PictureRestModel uploadPicture(MultipartFile file) {

        Path picturesPath = propertiesProvider.getTempPath();
        Path resolve = picturesPath.resolve(UUID.randomUUID().toString());
        Path pictureFile = filesWrapper.createFile(resolve);

        multipartFileWrapper.transferTo(file, pictureFile.toFile());

        Path relativized = pathsProvider.relativizeToTemp(pictureFile);
        return new PictureRestModel(relativized.toString());
    }
}
