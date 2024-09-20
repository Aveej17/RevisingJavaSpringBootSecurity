package org.example.LearningAuthentication.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(unique = true, nullable = false)
    private String emailAddress;

    @Column(length = 10, nullable = false)
    private String phoneNo;

    private String address;

    @Column(nullable = false)
    private String password;

}
