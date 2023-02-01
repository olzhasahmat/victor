package com.example.victorcrud.service;

import com.example.victorcrud.entity.MetaDocument;
import com.example.victorcrud.repository.MetaDocumentRepository;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServerService {

    private final MinioClient minioClient;
    private final MetaDocumentRepository metaDocumentRepository;

    @Value("${spring.minio.bucket}")
    private String bucketName;

    public MetaDocument upload(MultipartFile file) {
        try {
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(file.getOriginalFilename())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .build());
        } catch (Exception e) {
            log.error("Happened error when upload file: ", e);
        }

        MetaDocument metaDocument = MetaDocument.builder()
                .fileName(file.getName())
                .fileSize(file.getSize())
                .fileOriginalName(file.getOriginalFilename())
                .contentType(file.getContentType())
                .build();

        return metaDocumentRepository.save(metaDocument);
    }
}
