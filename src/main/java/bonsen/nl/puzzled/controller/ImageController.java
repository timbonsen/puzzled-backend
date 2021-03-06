package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.model.image.Image;
import bonsen.nl.puzzled.payload.response.ResponseMessageAndID;
import bonsen.nl.puzzled.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
            message = file.getOriginalFilename() + " is succesvol toegevoegd!";
            id = uploadedImage.getId();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageAndID(message, id));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessageAndID(message, id));
        }
    }

    @GetMapping(value = "/puzzles/{image-id}")
    public ResponseEntity<Object> getImage(@PathVariable("image-id") String id) {
        Image requestedImage = imageService.getImage(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(requestedImage.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + requestedImage.getName())
                .body(new ByteArrayResource(requestedImage.getData()));
    }
}
