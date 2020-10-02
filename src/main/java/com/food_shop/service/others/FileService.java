package com.food_shop.service.others;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface FileService {

    String saveFileToResoucesFolder(MultipartFile file, String url);
}
