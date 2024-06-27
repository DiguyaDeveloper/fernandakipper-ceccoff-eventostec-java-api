package com.eventostec.ceccoff.api.service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class S3Service {

    @Value("${aws.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    public String upload(File file, String filename) {
        s3Client.putObject(bucketName, filename, file);
        return s3Client.getUrl(bucketName, filename).toString();
    }
}
