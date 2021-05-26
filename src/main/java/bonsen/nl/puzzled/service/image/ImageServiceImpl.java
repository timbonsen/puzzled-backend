package bonsen.nl.puzzled.service.image;

import bonsen.nl.puzzled.exceptions.BadRequestException;
import org.springframework.util.StringUtils;
import bonsen.nl.puzzled.model.image.Image;
import bonsen.nl.puzzled.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image storeImage(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Image image = new Image(fileName, file.getContentType(), file.getBytes());

        return imageRepository.save(image);
    }

    @Override
    public Image getImage(String id) {
        Image image = imageRepository.findById(id).orElse(null);
        if (image != null) {
            return image;
        }
        throw new BadRequestException();
    }
}
