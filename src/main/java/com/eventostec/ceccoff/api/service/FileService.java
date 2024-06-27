package com.eventostec.ceccoff.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    private S3Service storage;

    public String uploadImg(MultipartFile multipartFile) {
        String filename = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        File file = null;

        try {
            file = this.convertMultipartToFile(multipartFile);
            var url = storage.upload(file, filename);
            file.deleteOnExit();
            return url;
        } catch (Exception e) {
            System.out.println("Erro ao subir arquivo");
            assert file != null;
            file.deleteOnExit();
            return "";
        }
    }

    private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(multipartFile.getBytes());
        outputStream.close();

        return file;
    }
}
