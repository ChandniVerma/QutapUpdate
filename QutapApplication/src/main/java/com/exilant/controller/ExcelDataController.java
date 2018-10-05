package com.exilant.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exilant.CommonUtils.Response;
import com.exilant.model.ProjectInfoModel;
import com.exilant.service.ExcelDataService;
import com.exilant.service.ExcelDataServiceImpl;
import com.exilant.service.ProjectInfoService;

@RestController
@RequestMapping("/Qutap")
public class ExcelDataController {
	
org.slf4j.Logger log= LoggerFactory.getLogger(ExcelDataController.class);
	
	@Autowired
	ExcelDataService excelDataService;
	
	
	@PostMapping("/excel")
	public Response readExcelData(@RequestParam("file") MultipartFile multipartFile,HttpServletRequest req) throws IOException { 
		log.info("url of the application"+req.getRequestURL().toString());
		System.out.println("multipart"+multipartFile.isEmpty());
		Response response=excelDataService.readExcelData(multipartFile);
		
		System.out.println("url:::::"+req.getRequestURL().toString());
		response.setUrl(req.getRequestURL().toString());
		return response;
		
	}

	
}
