package com.exilant.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exilant.CommonUtils.Response;
import com.exilant.ReadUtils.DataRow;
import com.exilant.ReadUtils.DataTable;
import com.exilant.ReadUtils.ExcelTable;
import com.exilant.dao.ExcelDataDao;
import com.exilant.domain.ExcelDataDomain;



@Service
public class ExcelDataServiceImpl implements ExcelDataService{
	
	@Autowired
	ExcelDataDao excelDataDao;

	Response response;
	@Override
	public Response readExcelData(MultipartFile multipartFile) throws IOException {
	
	      try {
	    	  InputStream path=multipartFile.getInputStream();
	    	  System.out.println(path);        
	             try {	          
	                DataTable table = ExcelTable.load(() -> path);
	                int rowCount = table.rowCount();

	                for(int i=0; i < rowCount; ++i) {
	                   DataRow row = table.row(i);     
	                   String projectId = row.cell("Project ID");
	                   String projectName=row.cell("Project Name");
	                   String moduleId = row.cell("Module ID");
	                   String moduleName = row.cell("Module Name");
	                   String description= row.cell("Description");
	                   ExcelDataDomain excelDataDomain=new ExcelDataDomain();
	                   excelDataDomain.setDescription(description);
	                   excelDataDomain.setModuleId(moduleId);
	                   excelDataDomain.setModuleName(moduleName);
	                  
	                   excelDataDomain.setProjectName(projectName);
	                   excelDataDomain.setProjectId(projectId);
	                   
	                  response=excelDataDao.readExcelData(excelDataDomain);         
	             }
	          }catch (Exception e) {
				response.setMessage(e.getMessage());
			}
	      }catch (Exception e) {
	    	  response.setMessage(e.getMessage());
		}
		return response;	
	}
		
}		
		

		
		
		
		
		
		

	                   
	                
	


