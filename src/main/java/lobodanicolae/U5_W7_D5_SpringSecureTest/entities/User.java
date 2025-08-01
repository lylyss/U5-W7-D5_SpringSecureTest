package lobodanicolae.U5_W7_D5_SpringSecureTest.entities;

import jakarta.persistence.*;
import lobodanicolae.U5_W7_D5_SpringSecureTest.enums.TipoUtente;

import java.util.List;

@Entity
@Table(name = "users")
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


    public User() {
    }

    public User(String username, String email, String password, TipoUtente tipoUtente) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tipoUtente = tipoUtente;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUtente getTipoUtente() {
        return tipoUtente;
    }

    public void setTipoUtente(TipoUtente tipoUtente) {
        this.tipoUtente = tipoUtente;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipoUtente=" + tipoUtente +
                ", events=" + events +
                '}';
    }
}
