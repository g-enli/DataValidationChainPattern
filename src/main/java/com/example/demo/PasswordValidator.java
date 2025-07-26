package com.example.demo;

import java.util.Map;

// Parola doğrulama sınıfı
public class PasswordValidator extends Validator {
    @Override
    public ValidationResult validate(Map<String, String> data) {
        // Parola uzunluğunu kontrol et
        String password = data.getOrDefault("password", "");
        if (password.length() < 8) {
            return new ValidationResult(false, "Parola en az 8 karakter olmalı");
        }
        // Sonraki doğrulayıcıyı çağır
        if (nextValidator != null) {
            return nextValidator.validate(data);
        }
        return new ValidationResult(true, null);
    }
}

