package com.food_shop.service_impl.others;

import com.food_shop.service.others.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FileServiceImpl implements FileService {

    private final static Logger LOGGER = Logger.getLogger(FileServiceImpl.class.getName());

    @Value("spring.upload.folder-upload")
    String folderName;

    @Override
    public String saveFileToResoucesFolder(MultipartFile file, String url) {
        if (file.isEmpty()) {
            return null;
        }
        try {
            String fileName = LocalDateTime.now().getNano() + file.getOriginalFilename();
            File uploadedFile = new File(folderName + url, fileName);
            OutputStream stream;
            uploadedFile.createNewFile();
            stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
            stream.write(file.getBytes());
            stream.flush();
            stream.close();
            return fileName;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "saveFileToResourceFolder : {0}", e.getMessage());
            return null;
        }
    }
}
