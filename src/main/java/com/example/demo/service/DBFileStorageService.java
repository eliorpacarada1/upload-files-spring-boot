package com.example.demo.service;

import com.example.demo.exceptions.FileStorageException;
import com.example.demo.exceptions.MyFileNotFoundException;
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
    //normalize the name
    public DBFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return DBfileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }


    public DBFile getFile(String fileId) {
        return DBfileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }

    public Stream<DBFile> getAllFiles()
    {
        return DBfileRepository.findAll().stream();
    }
}
