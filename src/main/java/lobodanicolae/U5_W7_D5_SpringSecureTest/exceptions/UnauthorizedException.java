package lobodanicolae.U5_W7_D5_SpringSecureTest.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
