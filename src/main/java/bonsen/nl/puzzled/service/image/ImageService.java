package bonsen.nl.puzzled.service.image;

import bonsen.nl.puzzled.model.image.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    Image storeImage(MultipartFile file) throws IOException;
    Image getImage(String id);
}
