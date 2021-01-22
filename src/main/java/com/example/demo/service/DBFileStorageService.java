package com.example.demo.service;

import com.example.demo.model.DBFile;
import com.example.demo.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class DBFileStorageService {


    @Autowired
    private DBFileRepository DBfileRepository;

    public DBFile store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        DBFile DBFile = new DBFile(fileName, file.getContentType(), file.getBytes());

        return DBfileRepository.save(DBFile);
    }

    public DBFile getFile(String id) {
        return DBfileRepository.findById(id).get();
    }

    public Stream<DBFile> getAllFiles() {
        return DBfileRepository.findAll().stream();
    }
}
