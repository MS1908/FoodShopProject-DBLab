package com.food_shop.controller.app_user.authorized;


import com.food_shop.entities.app_user.AppUser;
import com.food_shop.entities.json.JsonResult;
import com.food_shop.service.app_user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

@RestController
@RequestMapping("api/v1/customer/app-user")
public class AppUserCustomerController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/basic-info")
    public ResponseEntity<JsonResult> getBasicInfo(@RequestParam("username") String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            if (!currentUsername.equals(username)) return JsonResult.badRequest("Get the fuck out boo!");
        }

        return appUserService.findByUsername(username)
                .map(JsonResult::found)
                .orElse(JsonResult.serverError("Internal Server Error"));
    }


    @PutMapping("/update")
    public ResponseEntity<JsonResult> update(@RequestBody AppUser appUser) {
        return JsonResult.badRequest("Can't update user profile");
//        return appUserService.update(appUser)
//                .map(JsonResult::updated)
//                .orElse(JsonResult.saveError("Internal Server Error"));
    }

    @PutMapping("/update-password")
    public ResponseEntity<JsonResult> updatePassword(@RequestBody String newPassword) {
        return JsonResult.badRequest("Can't update new password");
    }



}
