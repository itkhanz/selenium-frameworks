package com.itkhanz.utils.json;

import com.github.javafaker.Faker;

import java.util.Locale;

import static com.itkhanz.config.ConfigurationManager.configuration;

public class FakerUtils {
    private static final Faker faker = new Faker(new Locale(configuration().faker()));

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getPassword() {
        return faker.internet().password();
    }
}
