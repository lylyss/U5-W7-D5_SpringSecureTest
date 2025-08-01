package lobodanicolae.U5_W7_D5_SpringSecureTest.entities;

import jakarta.persistence.*;
import lobodanicolae.U5_W7_D5_SpringSecureTest.enums.TipoUtente;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUtente tipoUtente;

    @OneToMany(mappedBy = "creatore")
    private List<Event> events;


    // Getters e Setters
    // ...
}

