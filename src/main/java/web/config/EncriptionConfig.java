package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptionConfig {
    @Bean
    public PasswordEncoder getPasswordEncode() {
        return new MessageDigestPasswordEncoder("MD5");
    }
}
