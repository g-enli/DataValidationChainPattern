package com.example.demo.controller;

import com.example.demo.EmailValidator;
import com.example.demo.PasswordValidator;
import com.example.demo.UsernameValidator;
// Spring Boot REST controller
import com.example.demo.ValidationChain;
import com.example.demo.ValidationResult;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final ValidationChain validationChain;

    // Doğrulama zincirini başlat
    public UserController() {
        validationChain = new ValidationChain();
        validationChain.addValidator(new EmailValidator());
        validationChain.addValidator(new PasswordValidator());
        validationChain.addValidator(new UsernameValidator());
    }

    // Kullanıcı kaydı için REST uç noktası
    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String, String> data) {
        // Gelen JSON verisini doğrula
        ValidationResult result = validationChain.validate(data);
        if (result.isValid()) {
            return "Kayıt başarılı!\n";
        } else {
            return "Kayıt başarısız: \n" + result.getErrorMessage()+"\n";
        }
    }
}