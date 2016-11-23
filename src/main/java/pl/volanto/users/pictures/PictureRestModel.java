package pl.volanto.users.pictures;

public class PictureRestModel {

    private String path;

    public PictureRestModel(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
