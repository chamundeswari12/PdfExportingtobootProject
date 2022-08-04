package com.example.demo.controller;

import org.apache.http.protocol.ResponseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Service.AttachmentService;
import com.example.demo.Service.AttachmentServiceimpl;
import com.example.demo.entity.Attachment;
import com.example.demo.model.ResponseData;

@RestController
public class AttachmentController {
	
	@Autowired
	AttachmentService attachmentService;
	
	@PostMapping("upload")
	public ResponseData uploadfile(@RequestParam("file") MultipartFile file) throws Exception
	{
		
		Attachment attachment=attachmentService.saveAttachment(file);
		
		String s=Integer.toString(attachment.getId());
		
				
		//ServletUriComponentsBuilder  :   it is used to build the links based on the currentcontext
		String downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/download/")
	                .path(s)
	                .toUriString();
		
		return new ResponseData(attachment.getFileName(),downloadURl,file.getContentType(),file.getSize());
		
		
	}
	
	 @GetMapping("/download/{fileId}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable int fileId) throws Exception {
	        Attachment attachment = null;
	        attachment = attachmentService.getAttachment(fileId);
	        return  ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(attachment.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION,
	                        "attachment; filename=\"" + "hello"+attachment.getFileName()
	                + "\"")
	                .body(new ByteArrayResource(attachment.getData()));
	    }
	
	
	
	
	

}
