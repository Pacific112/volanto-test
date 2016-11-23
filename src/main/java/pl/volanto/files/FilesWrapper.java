package pl.volanto.files;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class FilesWrapper {

    public Path createFile(Path path) {
        try {
            return Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public Path move(Path fileToMove, Path path) {
        try {
            return Files.move(fileToMove, path);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


}
