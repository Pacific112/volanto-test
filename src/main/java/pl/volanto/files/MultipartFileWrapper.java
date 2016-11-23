package pl.volanto.files;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class MultipartFileWrapper {

    public void transferTo(MultipartFile multipartFile, File dest) {

        try {
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }




}
