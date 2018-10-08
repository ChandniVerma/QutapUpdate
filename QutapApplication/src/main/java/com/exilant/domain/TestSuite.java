package com.exilant.domain;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="TestSuite")
public class TestSuite {

	private String testSuiteName;
	private String moduleId;
	private ArrayList<TestCase> testCase;
	public String getTestSuiteName() {
		return testSuiteName;
	}
	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public ArrayList<TestCase> getTestCase() {
		return testCase;
	}
	public void setTestCase(ArrayList<TestCase> testCase) {
		this.testCase = testCase;
	}

	
}
