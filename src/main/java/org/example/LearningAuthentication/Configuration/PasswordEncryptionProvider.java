package org.example.LearningAuthentication.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncryptionProvider{
    @Bean
    public BCryptPasswordEncoder EncryptionProvider(){
        return new BCryptPasswordEncoder();
    }
}
