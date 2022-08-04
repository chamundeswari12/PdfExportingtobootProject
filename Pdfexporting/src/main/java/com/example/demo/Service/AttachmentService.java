package com.example.demo.Service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Attachment;

public interface AttachmentService {

	Attachment saveAttachment(MultipartFile file) throws Exception;

	Attachment getAttachment(Integer id) throws Exception;

}
