package com.exilant.domain;


import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="projectInfo")
public class ProjectInfo {

	private String projectId;
	private String projectName;
	private String projDescri;
    
	private ArrayList<Module> moduleList;
	//private ArrayList<Requirement> requirList;
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjDescri() {
		return projDescri;
	}

	public void setProjDescri(String projDescri) {
		this.projDescri = projDescri;
	}

	public ArrayList<Module> getModuleList() {
		return moduleList;
	}

	public void setModuleList(ArrayList<Module> moduleList) {
		this.moduleList = moduleList;
	}

//	public ArrayList<Requirement> getRequirList() {
//		return requirList;
//	}
//
//	public void setRequirList(ArrayList<Requirement> requirList) {
//		this.requirList = requirList;
//	}

	
	
	
	
	
}
