package lobodanicolae.U5_W7_D5_SpringSecureTest.records;

public record UserRegistrationRequest(
        String username,
        String email,
        String password,
        String tipoUtente
) {
}

