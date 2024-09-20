package org.example.LearningAuthentication.service;


import org.example.LearningAuthentication.Exception.UserCreateException;
import org.example.LearningAuthentication.model.User;
import org.example.LearningAuthentication.repository.UserRepository;
import org.example.LearningAuthentication.request.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public void createUser(UserCreateRequest userCreateRequest) throws Exception{

        User existingUser  = userRepository.findByEmailAddress(userCreateRequest.getEmailAddress());
        if(existingUser!=null){
            throw new UserCreateException("try with new email address");
        }
        String pass = bCryptPasswordEncoder.encode(userCreateRequest.getPassword());
        userCreateRequest.setPassword(pass);
        User newUser = userCreateRequest.toUser();
        userRepository.save(newUser);
    }
}
