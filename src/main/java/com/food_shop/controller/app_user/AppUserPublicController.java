package com.food_shop.controller.app_user;

import com.food_shop.entities.app_user.AppUser;
import com.food_shop.entities.json.JsonResult;
import com.food_shop.entities.json.LoginForm;
import com.food_shop.entities.json.ForgetPasswordForm;
import com.food_shop.payload.app_user.LoginResult;
import com.food_shop.payload.app_user.RegisterForm;
import com.food_shop.security.JWTService;
import com.food_shop.security.SecurityConstants;
import com.food_shop.service.app_user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;

@RestController
@RequestMapping("api/v1/public/app-user")
public class AppUserPublicController {

    @Autowired
    private JWTService jwtService;
    
    @Autowired
    private AppUserService appUserService;
    
    @PostMapping("/register")
    public ResponseEntity<JsonResult> register(@RequestBody RegisterForm registerForm) {
        if ((registerForm.getEmail() != null && registerForm.getUsername() != null && registerForm.getPassword() != null)) {
            boolean isUsernameExisted = appUserService.checkUsernameExisted(registerForm.getUsername());
            boolean isEmailExisted = appUserService.checkEmailExisted(registerForm.getEmail());
            StringBuilder failRegisterMsg = new StringBuilder();
            if (isUsernameExisted || isEmailExisted) {
                if (isUsernameExisted) failRegisterMsg.append("Username ");
                if (failRegisterMsg.length() != 0 && isEmailExisted) failRegisterMsg.append("and ");
                if (isEmailExisted) failRegisterMsg.append("Email ");
                failRegisterMsg.append("existed");
                System.out.println(failRegisterMsg);
                return ResponseEntity.ok(JsonResult.build("Register failed", failRegisterMsg));
            }
            AppUser newAppUser = appUserService.register(registerForm);
            if (newAppUser != null) {
                newAppUser.setPassword(null);
                return ResponseEntity.ok(JsonResult.build("Register succeeded", newAppUser));
            }
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/login")
    public ResponseEntity<JsonResult> login(@RequestBody LoginForm loginForm) {
        if (loginForm.getUsername() != null && loginForm.getPassword() != null ) {
            return appUserService.login(loginForm)
                    .map(appUser -> JsonResult.success(new LoginResult(appUser.getRole(), jwtService.generateToken(appUser.getUsername(), SecurityConstants.EXPIRATION_TIME))))
                    .orElse(JsonResult.notFound("Invalid Authentication Information"));
        }
        return ResponseEntity.badRequest().build();
    }

//    @PostMapping("/forget-password")
//    public ResponseEntity<JsonResult> forgetPassword(@RequestBody ForgetPasswordForm ForgetPasswordForm) {
//        if (ForgetPasswordForm.getUsername() != null && loginForm.getPassword() != null ) {
//            return appUserService.login(loginForm)
//                    .map(appUser -> ResponseEntity.ok(JsonResult.build("Login succeeded", jwtService.generateToken(appUser.getUsername(), SecurityConstants.EXPIRATION_TIME))))
//                    .orElse(ResponseEntity.ok(JsonResult.build("Login failed", "Invalid Authentication Information")));
//        }
//        return ResponseEntity.badRequest().build();
//    }
}
