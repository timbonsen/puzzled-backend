package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.model.image.Image;
import bonsen.nl.puzzled.payload.response.ResponseMessageAndID;
import bonsen.nl.puzzled.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RequestMapping(value = "/users")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping(value = "/upload-image")
    public ResponseEntity<ResponseMessageAndID> uploadImage(@RequestParam("image") MultipartFile file) {
        String message;
        String id = null;
        try {
            Image uploadedImage = imageService.storeImage(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            id = uploadedImage.getId();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageAndID(message, id));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessageAndID(message, id));
        }
    }
}
