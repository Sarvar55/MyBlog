package com.example.myblog.service.Impl;

import com.example.myblog.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @project: MyBlog
 * @author: Sarvar55
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        String randomId = UUID.randomUUID().toString();
        String changedFileName = randomId.concat(fileName.substring(fileName.lastIndexOf(".")));

        String filePath = path + File.separator + changedFileName;

        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return changedFileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream stream = new FileInputStream(fullPath);
        return stream;
    }
}
