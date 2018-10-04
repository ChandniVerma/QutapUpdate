package com.exilant.domain;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="QutapData")
public class ExcelDataDomain {
	
	@Id
	private String projectId;
	
	private String projectName;
	private String moduleId;

	private String moduleName;
	private String description;
	private RequirementDomain[] requirementDomain;
	private TestCaseDomain[] testCaseDomain;
	private TestScenarioDomain[] testScenarioDomain;
	
	
	
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
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RequirementDomain[] getRequirementDomain() {
		return requirementDomain;
	}
	public void setRequirementDomain(RequirementDomain[] requirementDomain) {
		this.requirementDomain = requirementDomain;
	}
	public TestCaseDomain[] getTestCaseDomain() {
		return testCaseDomain;
	}
	public void setTestCaseDomain(TestCaseDomain[] testCaseDomain) {
		this.testCaseDomain = testCaseDomain;
	}
	public TestScenarioDomain[] getTestScenarioDomain() {
		return testScenarioDomain;
	}
	public void setTestScenarioDomain(TestScenarioDomain[] testScenarioDomain) {
		this.testScenarioDomain = testScenarioDomain;
	}
	
	
}
