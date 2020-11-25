package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@RestController
public class FileUploadDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadDemoApplication.class, args);
	}

	
	@PostMapping("/upload")
	public ResponseEntity<Object> uploadFile(@RequestParam("file")MultipartFile file) throws IOException
	{
		
		File convertFile = new File("E:\\code\\manhattan\\dev\\.settings\\"+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return new ResponseEntity<>("File uploaded successfully",HttpStatus.OK);
	}
	@GetMapping("/download")
	public ResponseEntity<Object>downloadFile() throws IOException
	{
		CSVdata csv1 = new CSVdata();
		csv1.setId("1");
		csv1.setName("Udit");
		csv1.setNumber("5432");
		
		CSVdata csv2 = new CSVdata();
		csv2.setId("2");
		csv2.setName("Joshi");
		csv2.setNumber("54321");
		
		List<CSVdata> csvDataList = new ArrayList<>();
		csvDataList.add(csv1);
		csvDataList.add(csv2);
		
		StringBuilder filecontent = new StringBuilder("ID,NAME,NUMBER\n");
		for(CSVdata csv:csvDataList) {
			filecontent.append(csv.getId()).append(",").append(csv.getName()).append(",").append(csv.getNumber()).append(",");
		}
		
		String filename = "E:\\exp\\abc.csv";
		FileWriter filewriter = new FileWriter(filename);
		filewriter.write(filecontent.toString());
		filewriter.flush();
		File file = new File(filename);
		InputStreamResource  resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Dispositon", String.format("attachment filename", file.getName()));
		
		
		ResponseEntity<Object> responseEntity=ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
		
		return responseEntity;
		
	}
	
	
}
