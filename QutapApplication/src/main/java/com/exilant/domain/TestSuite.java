package com.exilant.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="TestSuite")
public class TestSuite {

	private String testSuiteName;
	private Module moduleLis;
	private TestCase testCase;
	public String getTestSuiteName() {
		return testSuiteName;
	}
	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}
	public Module getModuleLis() {
		return moduleLis;
	}
	public void setModuleLis(Module moduleLis) {
		this.moduleLis = moduleLis;
	}
	public TestCase getTestCase() {
		return testCase;
	}
	public void setTestCase(TestCase testCase) {
		this.testCase = testCase;
	}
	
}
