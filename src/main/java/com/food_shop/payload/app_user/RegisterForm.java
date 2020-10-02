package com.food_shop.payload.app_user;

import lombok.Data;

@Data
public class RegisterForm {

    private String fullname;

    private String username;

    private String password;

    private String address;

    private String email;

    private String phone;
}
