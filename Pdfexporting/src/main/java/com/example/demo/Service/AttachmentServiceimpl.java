package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repo.AttachmentRepo;
import com.example.demo.entity.Attachment;


@Service
public class AttachmentServiceimpl implements AttachmentService {
	
	@Autowired
	AttachmentRepo attachmentRepo;

	@Override
	public Attachment saveAttachment(MultipartFile file) throws Exception {
		
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains(".."))
			{
				throw new Exception("filename contains the invalid path sequence");
			}
			Attachment attachment=new Attachment(fileName,file.getContentType(),file.getBytes());
			 return attachmentRepo.save(attachment);
			
		}
		catch (Exception e) {
			 throw new Exception("file not saved"+fileName);
		}
		

	
	}

	@Override
	public Attachment getAttachment(Integer id) throws Exception {
	    return attachmentRepo
                .findById(id)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + id));
	}

	
}
