package com.exilant.service;



import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exilant.CommonUtils.Response;

import com.exilant.dao.ExcelDataDao;
import com.exilant.domain.Module;
import com.exilant.domain.ProjectInfo;
import com.exilant.domain.Requirement;
import com.exilant.domain.TestCase;
import com.exilant.domain.TestScenario;
import com.exilant.domain.TestSuite;




@Service
public class ExcelDataServiceImpl1 implements ExcelDataService{
	
	@Autowired
	ExcelDataDao excelDataDao;

	Response response;
	@Override
	public Response readExcelData(MultipartFile multipartFile) throws IOException {
	
	      try {
//	    	  InputStream path=multipartFile.getInputStream();
	    	  System.out.println(multipartFile);        
	             try {	          
	            	 System.out.println("i am service::::::;"); 
	            	 

	            	 
	            	 System.out.println("**********1**********");
	            	 Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream());
	                 Sheet worksheet = workbook.getSheetAt(0);
	                 System.out.println("**********2**********");
	                 
	                 System.out.println("rows:::::"+worksheet.getPhysicalNumberOfRows());
	                 
	                 
	                 ProjectInfo projectInf = new ProjectInfo();
	                
	                 //Module m1=new Module();
	                 
	                ArrayList<Module> modList=new ArrayList<Module>();
	               // ArrayList<Requirement> requirList=new ArrayList<Requirement>();
	               // ArrayList<TestScenario> testSceList=new  ArrayList<TestScenario>();
	              //  ArrayList<TestCase> testCaseList=new ArrayList<TestCase>();
	                System.out.println("no.of::::"+worksheet.getPhysicalNumberOfRows());
	                
	               
	                
	       	          for(int i=1;i<worksheet.getPhysicalNumberOfRows();i++) {
	       	        	  
	       	        	System.out.println("no.of============::i:value:"+i);
	       	        	System.out.println("no.of cells========:::"+ worksheet.getRow(i).getPhysicalNumberOfCells());
	       	        	
	       	              Row row = worksheet.getRow(i);
	       	              DataFormatter formatter = new DataFormatter();
	       	           //row.cellIterator();
	       	              System.out.println("rowname::type::"+formatter.formatCellValue(worksheet.getRow(i).getCell(9)));
	       	           
	       	              String str="";
	       	              //str.is
	       	          if(!((formatter.formatCellValue(worksheet.getRow(i).getCell(0))).isEmpty()))
	       	          {	       	             	       	             
	       	        	  System.out.println("not empty row ::::"+formatter.formatCellValue(worksheet.getRow(i).getCell(0)));
	       	        	  	projectInf.setProjectId(formatter.formatCellValue(worksheet.getRow(i).getCell(0)));
	       	             	projectInf.setProjectName(formatter.formatCellValue(worksheet.getRow(i).getCell(1)));
	       	            	projectInf.setProjDescri(formatter.formatCellValue(worksheet.getRow(i).getCell(2)));
	       	          }
	       	              if(formatter.formatCellValue(worksheet.getRow(i).getCell(3))!=null)
	       	              {
	       	              Module m1=new Module();
	       	              m1.setModuleId(formatter.formatCellValue(worksheet.getRow(i).getCell(3)));
	       	              m1.setModuleName(formatter.formatCellValue(worksheet.getRow(i).getCell(4)));
	       	              // modList.add(m1);
	       	               modList.add(m1);
	       	               }
	       	            
	       	             projectInf.setModuleList(modList);	
	       	             
	       	            requiremnetMethod(worksheet,i);//get RequirementDetails
	      	              System.out.println("first column room::::::"+projectInf.getProjectName());      
	      	              
	      	            response= excelDataDao.readExcelData(projectInf);  
	      	          System.out.println("object of tessuite::::123:::");
	      	          testSuiteMethod(worksheet,i);
	      	        System.out.println("object of tessuite::::321:::");
	             }	       	     
	       	      
	       	          
	          }catch (Exception e) {
				response.setMessage(e.getMessage());
			}
	      }catch (Exception e) {
	    	  response.setMessage(e.getMessage());
		}
		return response;	
	}
		
	
	public Response requiremnetMethod(Sheet worksheet,int i) {
		
		
	            	 
		DataFormatter formatter = new DataFormatter();
		
		 if(formatter.formatCellValue(worksheet.getRow(i).getCell(5))!=null)
            { 
            Requirement r1=new Requirement();
            r1.setRequirementId(formatter.formatCellValue(worksheet.getRow(i).getCell(5)));
            r1.setRequirementName(formatter.formatCellValue(worksheet.getRow(i).getCell(6)));
            r1.setRequirementCases(formatter.formatCellValue(worksheet.getRow(i).getCell(7)));
            r1.setRequirDescri(formatter.formatCellValue(worksheet.getRow(i).getCell(8)));
            //requirList.add(r1);
             //    m1.setRequirement(r1);
         if(formatter.formatCellValue(worksheet.getRow(i).getCell(9))!=null)
            {  TestScenario ts1=new TestScenario();
            
            ts1.setTestScenId(formatter.formatCellValue(worksheet.getRow(i).getCell(9)));
            ts1.setTestScenName(formatter.formatCellValue(worksheet.getRow(i).getCell(10)));
            ts1.setTestScenDesc(formatter.formatCellValue(worksheet.getRow(i).getCell(11)));
           // testSceList.add(ts1);
             r1.setTestSceList(ts1);
            if(formatter.formatCellValue(worksheet.getRow(i).getCell(12))!=null)
             {    TestCase t1=new TestCase();
           
              t1.setTestcaseId(formatter.formatCellValue(worksheet.getRow(i).getCell(12)));
              t1.setTestCaseDesc(formatter.formatCellValue(worksheet.getRow(i).getCell(13)));
              t1.setTestCaseCatgry(formatter.formatCellValue(worksheet.getRow(i).getCell(14)));
              t1.setTestCasePrity(formatter.formatCellValue(worksheet.getRow(i).getCell(15)));
             t1.setTestCaseTag(formatter.formatCellValue(worksheet.getRow(i).getCell(16)));
             t1.setTestCaseSteps(formatter.formatCellValue(worksheet.getRow(i).getCell(17)));
             t1.setTestCaseData(formatter.formatCellValue(worksheet.getRow(i).getCell(18)));
          t1.setExpectedResult(formatter.formatCellValue(worksheet.getRow(i).getCell(19)));
         
            ts1.setTestCaseList(t1);
             }
           }  
         System.out.println("moduleID:::::"+formatter.formatCellValue(worksheet.getRow(i).getCell(9)));
         r1.setModuleId(formatter.formatCellValue(worksheet.getRow(i).getCell(3)));
         
         response= excelDataDao.requirementData(r1);
         
         
         
          }
		 
		return response;
	
     }		
	public Response testSuiteMethod(Sheet worksheet,int i) {
		
		 TestSuite testSuite=new TestSuite();
		 ArrayList<TestCase> testCaseList=new ArrayList<TestCase>();
	            	 
		DataFormatter formatter = new DataFormatter();
		testSuite.setModuleId(formatter.formatCellValue(worksheet.getRow(i).getCell(3)));
		
        testSuite.setTestSuiteName(formatter.formatCellValue(worksheet.getRow(i).getCell(20)));
        System.out.println("object of tessuite::name:::::"+formatter.formatCellValue(worksheet.getRow(i).getCell(20)));
		
        if(formatter.formatCellValue(worksheet.getRow(i).getCell(3))!=null)
        {
          
           if(formatter.formatCellValue(worksheet.getRow(i).getCell(12))!=null)
            {    TestCase t1=new TestCase();
          
             t1.setTestcaseId(formatter.formatCellValue(worksheet.getRow(i).getCell(12)));
             t1.setTestCaseDesc(formatter.formatCellValue(worksheet.getRow(i).getCell(13)));
             t1.setTestCaseCatgry(formatter.formatCellValue(worksheet.getRow(i).getCell(14)));
             t1.setTestCasePrity(formatter.formatCellValue(worksheet.getRow(i).getCell(15)));
            t1.setTestCaseTag(formatter.formatCellValue(worksheet.getRow(i).getCell(16)));
            t1.setTestCaseSteps(formatter.formatCellValue(worksheet.getRow(i).getCell(17)));
            t1.setTestCaseData(formatter.formatCellValue(worksheet.getRow(i).getCell(18)));
         t1.setExpectedResult(formatter.formatCellValue(worksheet.getRow(i).getCell(19)));
        
         testCaseList.add(t1);
            }
           testSuite.setTestCase(testCaseList);
           
          }  
       
        
        System.out.println("object of tessuite:::::::"+testSuite.getTestSuiteName());
        
        response=excelDataDao.testSuitData(testSuite);
        
        System.out.println("object of tessuite::::after:::");
		 
		return response;
	
    }		
	
   
}