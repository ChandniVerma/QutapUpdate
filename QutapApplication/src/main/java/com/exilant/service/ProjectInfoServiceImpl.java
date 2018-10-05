package com.exilant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exilant.CommonUtils.Response;
import com.exilant.controller.ProjectInfoController;
import com.exilant.dao.ProjectInfoDao;
import com.exilant.model.ProjectInfoModel;
import com.exilant.model.RequirementModel;
import com.exilant.test.ProjectInfoDomain;
import com.exilant.test.RequirementDomain;

@Service
public class ProjectInfoServiceImpl implements ProjectInfoService{
	
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoServiceImpl.class);

	@Autowired
	ProjectInfoDao projectInfoDao;

	@Override
	public Response saveProjectInfo(ProjectInfoModel projectInfoModel) {
		
		try {
		ProjectInfoDomain projectInfoDomain=new ProjectInfoDomain();
		projectInfoModel.setProjectId(UUID.randomUUID().toString().substring(0, 8));
		BeanUtils.copyProperties(projectInfoModel, projectInfoDomain);
		Response response=projectInfoDao.saveProjectInfo(projectInfoDomain);
		return response;
		}catch (Exception e) {	
			log.info(e.getMessage());
		}return null;
	}
	
	@Override
	public ProjectInfoModel getProjectInfo(String projectId) {
		try {
		ProjectInfoModel projectInfoModel=new ProjectInfoModel();
		ProjectInfoDomain projectInfoDomain=projectInfoDao.getProjectInfo(projectId);
		BeanUtils.copyProperties(projectInfoDomain, projectInfoModel);
		return projectInfoModel;
		}
		catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public List<ProjectInfoModel> getProjectListInfo() {
		try {
			List<ProjectInfoModel> requirementModelList=new ArrayList<>();
			List<ProjectInfoDomain> projectInfoDomainList=projectInfoDao.getProjectListInfo();
			for(ProjectInfoDomain projectInfoDomain:projectInfoDomainList)
			{
				 ProjectInfoModel projectInfoModel=new ProjectInfoModel();
				 BeanUtils.copyProperties(projectInfoDomain, projectInfoModel);
				 requirementModelList.add(projectInfoModel);
			}
			 return requirementModelList;
		}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	
	}

	@Override
	public Response updateProjectInfo(ProjectInfoModel projectInfoModel) {
		try {
			ProjectInfoDomain projectInfoDomain=new ProjectInfoDomain();
			BeanUtils.copyProperties(projectInfoModel, projectInfoDomain);
			Response response=projectInfoDao.updateProjectInfo(projectInfoDomain);
			return response;
			}catch (Exception e) {	
				log.info(e.getMessage());
			}return null;
	}

	@Override
	public Response deleteProjectInfo(String projectId) {
		try {
			
			Response response=projectInfoDao.deleteProjectInfo(projectId);
			return response;
			}catch (Exception e) {	
				log.info(e.getMessage());
			}return null;
	}
	
	
	
}
