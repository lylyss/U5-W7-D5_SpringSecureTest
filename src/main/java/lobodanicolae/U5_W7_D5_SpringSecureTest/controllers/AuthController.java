package lobodanicolae.U5_W7_D5_SpringSecureTest.controllers;

import lobodanicolae.U5_W7_D5_SpringSecureTest.entities.Event;
import lobodanicolae.U5_W7_D5_SpringSecureTest.entities.User;
import lobodanicolae.U5_W7_D5_SpringSecureTest.records.UserLoginRequest;
import lobodanicolae.U5_W7_D5_SpringSecureTest.records.UserRegistrationRequest;
import lobodanicolae.U5_W7_D5_SpringSecureTest.repositories.EventRepository;
import lobodanicolae.U5_W7_D5_SpringSecureTest.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegistrationRequest request) {
        try {
            User user = authService.register(request);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest request) {
        try {
            String token = authService.login(request.username(), request.password());
            return ResponseEntity.ok(token);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return ResponseEntity.ok(events);
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event savedEvent = eventRepository.save(event);
        return ResponseEntity.ok(savedEvent);
    }
}
