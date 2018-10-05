package com.exilant.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exilant.CommonUtils.ErrorObject;
import com.exilant.CommonUtils.Response;
import com.exilant.CommonUtils.StatusCode;
import com.exilant.CommonUtils.Utils;
import com.exilant.controller.ProjectInfoController;
import com.exilant.model.ProjectInfoModel;
import com.exilant.test.ProjectInfoDomain;

@Repository
@Transactional
public class ProjectInfoDaoImpl implements ProjectInfoDao{

	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoDaoImpl.class);
	@Autowired 
	MongoTemplate mongoTemplate;
	
	@Override
	public Response saveProjectInfo(ProjectInfoDomain projectInfoDomain) {
		Response response=Utils.getResponseObject("Adding project Details");
		try {
		mongoTemplate.insert(projectInfoDomain,"ProjectInfo");
		response.setStatus(StatusCode.SUCCESS.name());
		response.setData(projectInfoDomain);
		return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
		
	}
	
	public ProjectInfoDomain getProjectInfo(String projectId) {
		try {
		return mongoTemplate.findById(projectId, ProjectInfoDomain.class);
		}
		catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}
	
	public List<ProjectInfoDomain> getProjectListInfo() {
		try {
		return mongoTemplate.findAll(ProjectInfoDomain.class, "ProjectInfo");
		}
		catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}
	
	@Override
	public Response updateProjectInfo(ProjectInfoDomain projectInfoDomain) {
		Response response=Utils.getResponseObject("updating project Details");
		try {
		ProjectInfoDomain InfoDomain=getProjectInfo(projectInfoDomain.getProjectId());
		InfoDomain.setDescription(projectInfoDomain.getDescription());
		InfoDomain.setModuleName(projectInfoDomain.getModuleName());
		InfoDomain.setProjectName(projectInfoDomain.getProjectName());
		mongoTemplate.save(InfoDomain);
		response.setStatus(StatusCode.SUCCESS.name());
		response.setData(InfoDomain);
		return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
		
	}

	@Override
	public Response deleteProjectInfo(String projectId) {
		Response response=Utils.getResponseObject("deleting project Details");
		ErrorObject err=Utils.getErrorResponse("deleting project", "project id  not found");
		try {
			ProjectInfoDomain projectInfoDomain=getProjectInfo(projectId);
			mongoTemplate.remove(projectInfoDomain);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(projectInfoDomain);
			return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(err);
			return response;
		}
	}
}

