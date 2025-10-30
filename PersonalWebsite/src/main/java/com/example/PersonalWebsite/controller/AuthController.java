package com.example.PersonalWebsite.controller;

import com.example.PersonalWebsite.model.User;
import com.example.PersonalWebsite.repository.UserRepository;
import com.example.PersonalWebsite.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody User user){
        Optional<User> existing = userRepository.findByUsername(user.getUsername());
        if(existing.isPresent() && passwordEncoder.matches(user.getPassword(),existing.get().getPassword())){
            String token = jwtService.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        }else{
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }


}
