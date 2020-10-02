package com.food_shop.controller.app_user.authorized;


import com.food_shop.entities.app_user.AppUser;
import com.food_shop.entities.json.JsonResult;
import com.food_shop.service.app_user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin/app-user")
public class AppUserAdminController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/id")
    public ResponseEntity<JsonResult> findById(@RequestParam("id") Integer idUser) {
        return appUserService.findById(idUser)
                .map(JsonResult::found)
                .orElse(JsonResult.idNotFound());
    }

    @GetMapping("/all")
    public ResponseEntity<JsonResult> findAll() {
        return Optional.ofNullable(appUserService.findAll())
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Category not found"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }

    @GetMapping("/username")
    public ResponseEntity<JsonResult> findByUsername(@RequestParam("username") String username) {
        return appUserService.findByUsername(username)
                .map(JsonResult::found)
                .orElse(JsonResult.notFound(username));
    }

    @GetMapping("/email")
    public ResponseEntity<JsonResult> findByEmail(@RequestParam("email") String email) {
        return appUserService.findByEmail(email)
                .map(JsonResult::found)
                .orElse(JsonResult.idNotFound());
    }

    @PostMapping("/upload")
    public ResponseEntity<JsonResult> upload(@RequestBody AppUser appUser) {
        return appUserService.upload(appUser)
                .map(saved -> {
                    saved.setPassword(null);
                    return JsonResult.uploaded(saved);
                })
                .orElse(JsonResult.saveError("Internal Error"));
    }

    @PutMapping("/update")
    public ResponseEntity<JsonResult> update(@RequestBody AppUser appUser) {
        return appUserService.upload(appUser)
                .map(JsonResult::uploaded)
                .orElse(JsonResult.saveError("Internal Error"));
    }

}
