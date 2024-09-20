package org.example.LearningAuthentication.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginRequest {

    @NotBlank(message = "Email should not be null")
    private String emailAddress;
    @NotBlank(message = "password should not be null")
    private String password;
}
