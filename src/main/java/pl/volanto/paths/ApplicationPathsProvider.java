package pl.volanto.paths;

import org.springframework.stereotype.Component;
import pl.volanto.properties.PropertiesProvider;

import java.nio.file.Path;

@Component
public class ApplicationPathsProvider {

    private final PropertiesProvider propertiesProvider;

    public ApplicationPathsProvider(PropertiesProvider propertiesProvider) {
        this.propertiesProvider = propertiesProvider;
    }

    public Path relativizeToTemp(Path fileInTemp) {
        return propertiesProvider.getTempPath().relativize(fileInTemp);
    }

    public Path relativizeToPictures(Path fileInPictures) {
        return propertiesProvider.getProfilePicturesPath().relativize(fileInPictures);
    }
}
