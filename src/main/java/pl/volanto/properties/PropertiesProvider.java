package pl.volanto.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class PropertiesProvider {

    @Value("${path.pictures}")
    private String profilePicturesPath;

    @Value("${path.temp}")
    private String tempPath;


    public Path getProfilePicturesPath() {
        return Paths.get(profilePicturesPath);
    }

    public Path getTempPath() {
        return Paths.get(tempPath);
    }
}
