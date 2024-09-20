package org.example.LearningAuthentication.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.LearningAuthentication.model.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

    @NotBlank(message = "user name cannot be null")
    private String name;

    @NotBlank(message = "Email Cannot be null")
    private String emailAddress;

    @NotBlank(message = "phone number Cannot be null")
    private String phoneNo;

    private String address;

    @NotBlank(message = "password Cannot be null")
    private String password;

    public User toUser(){
        return User.builder().
                name(this.name).
                emailAddress(this.emailAddress).
                phoneNo(this.phoneNo).
                address(this.address).
                password(this.password).
                build();
    }

}
