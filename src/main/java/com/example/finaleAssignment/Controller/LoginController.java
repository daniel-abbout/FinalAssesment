package com.example.finaleAssignment.Controller;

import com.example.finaleAssignment.Repository.UserRepository;
import com.example.finaleAssignment.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController {

    private final UserRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RestTemplate restTemplate;

    public LoginController(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> importUsersFromJsonLink() {
        try {
            // Fetch users data from the JSON link
            Users[] users = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", Users[].class);

            // Save all fetched users to the database
            for (Users user : users) {
                String hashPassword = passwordEncoder.encode(user.getPwd());
                user.setPwd(hashPassword);
                usersRepository.save(user);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Users imported successfully.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to import users: " + ex.getMessage());
        }
    }
}