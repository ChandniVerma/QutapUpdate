package com.exilant.dao;

import java.util.List;

import com.exilant.CommonUtils.Response;
import com.exilant.domain.RequirementDomain;
import com.exilant.domain.TestScenarioDomain;

public interface TestScenarioDao {
	Response saveScenario(TestScenarioDomain testScenarioDomain);
	TestScenarioDomain getTestScenarioById(String testScenarioId);
	
	public List<TestScenarioDomain> getTestScenarioList();

}
