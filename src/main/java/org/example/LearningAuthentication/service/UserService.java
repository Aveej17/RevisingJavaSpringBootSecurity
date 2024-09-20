package org.example.LearningAuthentication.service;


import org.example.LearningAuthentication.Configuration.JwtUtil;
import org.example.LearningAuthentication.Exception.UserCreateException;
import org.example.LearningAuthentication.model.User;
import org.example.LearningAuthentication.repository.UserRepository;
import org.example.LearningAuthentication.request.UserCreateRequest;
import org.example.LearningAuthentication.request.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private org.example.LearningAuthentication.Configuration.JwtUtil jwtUtil;


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

    public String loginUser(UserLoginRequest userLoginRequest) throws Exception{
        User checkUser = userRepository.findByEmailAddress(userLoginRequest.getEmailAddress());
        if(checkUser==null){
            throw new Exception("Check Email Address or password");
        }
        if(!bCryptPasswordEncoder.matches(userLoginRequest.getPassword(), checkUser.getPassword())){
            throw new Exception("Check Email Address or password");
        }

        org.example.LearningAuthentication.Configuration.JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.generateToken(checkUser.getEmailAddress());

        return token;
    }
}
