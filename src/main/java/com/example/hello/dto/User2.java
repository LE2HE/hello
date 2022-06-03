package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User2 {
    private String name;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;

    public User2() {
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }

    public User2(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // getDefaultUser2 로 method 를 생성하면 오류
    public User2 defaultUser2() {
        return new User2("default", 0, null);
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
