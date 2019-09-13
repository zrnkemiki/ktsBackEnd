package com.smv.AirSpace.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smv.AirSpace.service.FileService;
 
@RestController
@RequestMapping(value = "file")
public class FileController {
 
 
	@Autowired
	FileService fileService;
 
	@RequestMapping(value = "/addImage", method = RequestMethod.POST, consumes = "multipart/form-data")
	public void addImage(@RequestParam("file") MultipartFile file, @RequestParam("documentName") String documentName) throws IOException {
		System.out.println(documentName);
		
		
		fileService.storeFile(file);
	}
 
}