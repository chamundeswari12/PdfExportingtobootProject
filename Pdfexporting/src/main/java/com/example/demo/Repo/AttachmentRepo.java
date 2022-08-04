package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Attachment;

public interface AttachmentRepo extends JpaRepository<Attachment, Integer> {

}