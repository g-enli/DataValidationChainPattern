package com.example.demo;

import java.util.Map;

// Kullanıcı adı doğrulama sınıfı
public class UsernameValidator extends Validator {
    @Override
    public ValidationResult validate(Map<String, String> data) {
        // Kullanıcı adı uzunluğunu kontrol et
        String username = data.getOrDefault("username", "");
        if (username.length() < 3) {
            return new ValidationResult(false, "Kullanıcı adı en az 3 karakter olmalı");
        }
        // Sonraki doğrulayıcıyı çağır
        if (nextValidator != null) {
            return nextValidator.validate(data);
        }
        return new ValidationResult(true, null);
    }
}