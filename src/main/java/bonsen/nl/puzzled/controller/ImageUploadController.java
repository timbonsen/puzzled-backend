package bonsen.nl.puzzled.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ImageUploadController {

    private static final String storageLocation = "D:/Werk/NOVI/Eindopdracht/PuzzleImages";

    @RequestMapping(value = "/file-upload", method = RequestMethod.POST)

    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        multipartFile.transferTo(new File(storageLocation + multipartFile.getOriginalFilename()));
        return "Image successfully uploaded!";
    }
}
