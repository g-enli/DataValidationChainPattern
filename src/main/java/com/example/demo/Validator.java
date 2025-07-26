package com.example.demo;

import java.util.Map;

// Abstract Validator sınıfı
abstract class Validator {
    protected Validator nextValidator;

    // Sonraki validator nodeu ayarlar
    public Validator setNext(Validator validator) {
        this.nextValidator = validator;
        return validator;
    }

    // Veriyi doğrulamak için abstract metot - inherit implelent etmeli
    public abstract ValidationResult validate(Map<String, String> data);
}