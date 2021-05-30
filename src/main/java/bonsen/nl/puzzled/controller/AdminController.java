package bonsen.nl.puzzled.controller;

import bonsen.nl.puzzled.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/all-users")
    public ResponseEntity<Object> getUsers() {
        Set<String> allUsernames = userService.getUsers();
        return ResponseEntity.ok().body(allUsernames);
    }
}