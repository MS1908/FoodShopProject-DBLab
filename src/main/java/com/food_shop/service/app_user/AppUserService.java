package com.food_shop.service.app_user;

import com.food_shop.entities.app_user.AppUser;
import com.food_shop.entities.json.LoginForm;
import com.food_shop.payload.app_user.RegisterForm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface AppUserService {

    String getRoleFromCookie(HttpServletRequest request);

    Optional<AppUser> findById(Integer idUser);

    List<AppUser> findAll();

    Optional<AppUser> findByUsername(String username);

    Optional<AppUser> findByEmail(String email);

    Boolean checkUsernameExisted(String username);

    Boolean checkEmailExisted(String email);

    AppUser register(RegisterForm registerForm);

    Optional<AppUser> login(LoginForm loginForm);

    Optional<AppUser> upload(AppUser appUser);

    Optional<AppUser> update(AppUser appUser);
}
