package com.schoolproj2.schoolproj2.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@RestController
@RequestMapping(value = "/api/file")
public class FileController {
    @CrossOrigin("*")
    @PostMapping(value = "/upload/profile-img")
    public @ResponseBody
    String requestUploadFile(@RequestParam("fileList") List<MultipartFile> fileList) {
        try {
            for (MultipartFile multipartFile : fileList) {
                FileOutputStream writer = new FileOutputStream("./images/" + multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();
            }
        } catch (Exception e) {
            return "upload fail";
        }
        return "upload success";
    }
}
