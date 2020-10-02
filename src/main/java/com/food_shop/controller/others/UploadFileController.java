package com.food_shop.controller.others;

import com.food_shop.entities.json.JsonResult;
import com.food_shop.service.others.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/public/file")
public class UploadFileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload/prod-img")
    public ResponseEntity<JsonResult> updateProduct(@RequestParam MultipartFile imageFile) {
        return Optional.ofNullable(fileService.saveFileToResoucesFolder(imageFile, "img\\back-end\\"))
                .map(JsonResult::uploaded)
                .orElse(JsonResult.saveError("File"));
    }
}
