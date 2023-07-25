package com.example.booking_doc;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);

    }



    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void registerUser(String username, String password, UserRole role) {
        // Check if the user already exists
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists.");
        }

        // Encode the password before saving it in the database
        String encodedPassword = passwordEncoder.encode(password);

        // Create a new user entity and save it in the database
        User user = new User(username, encodedPassword, role);
        userRepository.save(user);
    }

    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }

        // Check if the provided password matches the encoded password in the database
        boolean isPasswordValid = passwordEncoder.matches(password, user.getPassword());

        if (!isPasswordValid) {
            throw new IllegalArgumentException("Invalid password.");
        }

        // Here, you can generate and return an authentication token using JWT or any other authentication mechanism.
        // For simplicity, we will just return a success message.
        return "User logged in successfully.";
    }
}
