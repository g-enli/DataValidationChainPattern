package com.example.demo;

import java.util.Map;

// Email doğrulama sınıfı
public class EmailValidator extends Validator {
    @Override
    public ValidationResult validate(Map<String, String> data) {
        // Email formatını kontrol et
        String email = data.getOrDefault("email", "");
        if (!email.contains("@") || !email.contains(".")) {
            return new ValidationResult(false, "Geçersiz email formatı");
        }
        // Sonraki doğrulayıcıyı çağır
        if (nextValidator != null) {
            return nextValidator.validate(data);
        }
        return new ValidationResult(true, null);
    }
}
