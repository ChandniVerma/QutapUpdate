package com.exilant.service;

import java.util.List;

import com.exilant.CommonUtils.Response;
import com.exilant.domain.TestScenarioDomain;
import com.exilant.model.TestScenarioModel;

public interface TestScenarioService  {
	Response saveScenario(TestScenarioModel testScenarioModel);
	TestScenarioModel getTestScenarioById(String testScenarioId);
	
	public List<TestScenarioModel> getTestScenarioList();

}
