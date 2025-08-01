package lobodanicolae.U5_W7_D5_SpringSecureTest.services;

import lobodanicolae.U5_W7_D5_SpringSecureTest.entities.User;
import lobodanicolae.U5_W7_D5_SpringSecureTest.enums.TipoUtente;
import lobodanicolae.U5_W7_D5_SpringSecureTest.exceptions.UnauthorizedException;
import lobodanicolae.U5_W7_D5_SpringSecureTest.records.UserRegistrationRequest;
import lobodanicolae.U5_W7_D5_SpringSecureTest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTTools jwtTools;

    public User register(UserRegistrationRequest request) {
        if (userRepository.findByUsername(request.username()).isPresent()) {
            throw new RuntimeException("Username già esistente");
        }
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("Email già esistente");
        }
        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setTipoUtente(TipoUtente.valueOf(request.tipoUtente()));

        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public String login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            throw new UnauthorizedException("Credenziali errate!");
        }
        User user = userOpt.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException("Credenziali errate!");
        }
        return jwtTools.createToken(user);
    }
}
