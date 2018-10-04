package com.exilant.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.exilant.CommonUtils.Response;

public interface ExcelDataService {

	Response readExcelData(MultipartFile multipartFile) throws IOException;

}
