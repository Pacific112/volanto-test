package pl.volanto.users.pictures;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PictureController {

    private final PicturesUploader picturesUploader;

    public PictureController(PicturesUploader picturesUploader) {
        this.picturesUploader = picturesUploader;
    }

    @PostMapping(value = "/api/pictures")
    public PictureRestModel updateUserWithImage(@RequestPart("file") MultipartFile image) {
        return picturesUploader.uploadPicture(image);
    }
}
