package com.ranty.automation.utils;

import java.util.UUID;

public class DataGenerator {

    // Generates a unique email using UUID
    public static String generateRandomEmail() {
        return "user_" + UUID.randomUUID() + "@mail.com";
    }

    // Generates a random first name (basic version)
    public static String generateFirstName() {
        return "John_" + UUID.randomUUID().toString().substring(0, 5);
    }

    // Generates a random last name (basic version)
    public static String generateLastName() {
        return "Doe_" + UUID.randomUUID().toString().substring(0, 5);
    }

    // Generates a strong password for testing
    public static String generatePassword() {
        return "Test@" + UUID.randomUUID().toString().substring(0, 8);
    }
}
