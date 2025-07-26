package com.example.demo;

import java.util.Map;

// Validation zinciri
public class ValidationChain {
    private Validator head;

    // Yeni bir validation adımı ekler
    public void addValidator(Validator validator) {
        if (head == null) {
            head = validator;
        } else {
            Validator current = head;
            while (current.nextValidator != null) {
                current = current.nextValidator;
            }
            current.setNext(validator);
        }
    }

    // Veriyi zincir boyunca doğrular
    public ValidationResult validate(Map<String, String> data) {
        if (head == null) {
            return new ValidationResult(true, null);
        }
        return head.validate(data);
    }
}