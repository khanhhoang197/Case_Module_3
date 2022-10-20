package com.khanhhoang.demo.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class User {
    private String username;
    private String password;
    private String fullName;
    private int gender;
    private LocalDate birthday;
    private String email;
    private String phone;
    private int country;
    private String img;

    public User() {
    }

    public User(String password, String fullName, int gender, LocalDate birthday, String email, String phone, int country, String img) {
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.img = img;
    }

    public User(String username, String password, String fullName, int gender, LocalDate birthday, String email, String phone, int country, String img) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.img = img;
    }
    @NotEmpty(message = "Tên sản phẩm không được để trống")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", country=" + country +
                ", img='" + img + '\'' +
                '}';
    }
}
