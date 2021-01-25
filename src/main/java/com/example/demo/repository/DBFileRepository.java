package com.example.demo.repository;

import com.example.demo.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}

