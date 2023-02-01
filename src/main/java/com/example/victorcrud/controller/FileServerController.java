package com.example.victorcrud.controller;

import com.example.victorcrud.entity.MetaDocument;
import com.example.victorcrud.service.FileServerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fs")
public class FileServerController {

    private final FileServerService fileServerService;

    @PostMapping("/upload")
    @Operation(description = "Метод для сохранения файла в min.io")
    public MetaDocument upload(@RequestParam(value = "file") MultipartFile file) {
        log.info("REST request to upload - {}", file);
        return fileServerService.upload(file);
    }
}
