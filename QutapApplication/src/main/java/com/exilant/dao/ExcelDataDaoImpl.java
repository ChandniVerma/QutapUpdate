package com.exilant.dao;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exilant.CommonUtils.Response;
import com.exilant.CommonUtils.StatusCode;
import com.exilant.CommonUtils.Utils;
import com.exilant.domain.ProjectInfo;
import com.exilant.test.ExcelDataDomain;

@Repository
@Transactional
public class ExcelDataDaoImpl implements ExcelDataDao{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	org.slf4j.Logger log= LoggerFactory.getLogger(ExcelDataDaoImpl.class);

	@Override
	public Response readExcelData(ProjectInfo projectInfo) {
		Response response=Utils.getResponseObject("Adding project Details");
		try {
			
			System.out.println("db projectdata::::"+projectInfo.getProjectName());
		mongoTemplate.insert(projectInfo,"projectInfo");
		response.setStatus(StatusCode.SUCCESS.name());
		response.setData(projectInfo);
		return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
	}

}
