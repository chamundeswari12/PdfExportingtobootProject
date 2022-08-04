package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Attachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name="uuid",strategy = "uuid2")
	private Integer id;
	private String fileName;
	private String fileType;
	@Lob
	private byte[] data;
	
	
	public Attachment(String fileName, String fileType, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
	
	
	
	
	
	

}
