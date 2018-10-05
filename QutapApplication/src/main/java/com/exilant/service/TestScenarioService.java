package com.exilant.service;

import java.util.List;

import com.exilant.CommonUtils.Response;
import com.exilant.model.TestScenarioModel;
import com.exilant.test.TestScenarioDomain;

public interface TestScenarioService  {
	Response saveScenario(TestScenarioModel testScenarioModel);
	TestScenarioModel getTestScenarioById(String testScenarioId);
	
	public List<TestScenarioModel> getTestScenarioList();

}
