package lobodanicolae.U5_W7_D5_SpringSecureTest.controllers;

import lobodanicolae.U5_W7_D5_SpringSecureTest.entities.User;
import lobodanicolae.U5_W7_D5_SpringSecureTest.records.UserRegistrationRequest;
import lobodanicolae.U5_W7_D5_SpringSecureTest.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegistrationRequest request) {
        try {
            User user = authService.register(request);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint di login da implementare 
}

