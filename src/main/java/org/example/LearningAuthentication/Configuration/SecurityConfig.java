package org.example.LearningAuthentication.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF protection (for testing, enable in production)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/signup", "/user/login").permitAll()  // Allow access to signup and login
                        .anyRequest().authenticated()
                );
//                .httpBasic(Customizer.withDefaults());  // Updated HTTP Basic Authentication config

        return http.build();
    }
}

