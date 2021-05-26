package bonsen.nl.puzzled.service;

import bonsen.nl.puzzled.model.image.Image;
import bonsen.nl.puzzled.repository.ImageRepository;
import bonsen.nl.puzzled.service.image.ImageService;
import bonsen.nl.puzzled.service.image.ImageServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ImageServiceImplTest {

    @InjectMocks
    private final ImageService imageService = new ImageServiceImpl();

    @Mock
    private ImageRepository imageRepository;

    private Image image;

    @BeforeEach
    void setUp() {
        image = new Image();
    }

    @Test
    void test_getImage() {
        Mockito.when(imageRepository.findById(image.getId())).thenReturn(java.util.Optional.ofNullable(image));

        Image responseImage = imageService.getImage(image.getId());

        Assertions.assertEquals(responseImage, image);
        Assertions.assertNotNull(responseImage);
    }
}
