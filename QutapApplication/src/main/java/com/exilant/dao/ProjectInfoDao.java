package com.exilant.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.exilant.CommonUtils.Response;
import com.exilant.model.ProjectInfoModel;
import com.exilant.test.ProjectInfoDomain;

public interface ProjectInfoDao {

	Response saveProjectInfo(ProjectInfoDomain projectInfoDomain);

	ProjectInfoDomain getProjectInfo(String projectId);
	
	public List<ProjectInfoDomain> getProjectListInfo();

	Response updateProjectInfo(ProjectInfoDomain projectInfoDomain);

	Response deleteProjectInfo(String projectId);

}
