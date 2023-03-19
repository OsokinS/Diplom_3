package com.model;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class FakeUser {

    static Faker faker = new Faker(new Locale("en_EN"));

    private String email;
    private String password;
    private String name;

    public FakeUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;

    }


    //Хелпер-метод, генерирующий данные
    public static FakeUser getRandom(int charPass) {
        final String email = faker.internet().emailAddress();
        final String password = RandomStringUtils.randomAlphabetic(charPass);
        final String name = faker.name().firstName();
        return new FakeUser(email, password, name);

    }


    public String getEmail() {
        return email;
    }

    public FakeUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public FakeUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public FakeUser setName(String name) {
        this.name = name;
        return this;
    }
}
