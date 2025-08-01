package lobodanicolae.U5_W7_D5_SpringSecureTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class U5W7D5SpringSecureTestApplication {

    private static final Logger logger = LoggerFactory.getLogger(U5W7D5SpringSecureTestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(U5W7D5SpringSecureTestApplication.class, args);
        logger.info("Applicazione avviata con successo!");
    }

}
