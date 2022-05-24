package com.schoolproj2.schoolproj2.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/file")
public class FileController {
    @CrossOrigin("*")
    @PostMapping(value = "/upload/image", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Object uploadImage(@RequestParam("fileList") MultipartFile img) {
        System.out.println(img.getOriginalFilename());
        return img.getOriginalFilename();
    }

    @CrossOrigin("*")
    @PostMapping(value = "/upload/audio", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Object uploadAudio(@RequestParam("fileList") MultipartFile img) {
        System.out.println(img.getOriginalFilename());
        return img.getOriginalFilename();
    }
}
