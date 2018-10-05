package com.exilant.dao;

import java.util.List;

import com.exilant.CommonUtils.Response;
import com.exilant.test.RequirementDomain;
import com.exilant.test.TestScenarioDomain;

public interface TestScenarioDao {
	Response saveScenario(TestScenarioDomain testScenarioDomain);
	TestScenarioDomain getTestScenarioById(String testScenarioId);
	
	public List<TestScenarioDomain> getTestScenarioList();

}
