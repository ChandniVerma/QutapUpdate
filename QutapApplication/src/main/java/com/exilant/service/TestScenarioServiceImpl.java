package com.exilant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exilant.CommonUtils.Response;
import com.exilant.dao.RequirementDao;
import com.exilant.dao.TestScenarioDao;
import com.exilant.model.RequirementModel;
import com.exilant.model.TestScenarioModel;
import com.exilant.test.RequirementDomain;
import com.exilant.test.TestScenarioDomain;
@Service
public class TestScenarioServiceImpl  implements TestScenarioService{
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoServiceImpl.class);
	@Autowired
	TestScenarioDao testScenarioDao;
	
	@Override
	public Response saveScenario(TestScenarioModel testScenarioModel) {
		try {
			TestScenarioDomain testScenarioDomain=new TestScenarioDomain();
			testScenarioModel.setTestScenarioId(UUID.randomUUID().toString().substring(0, 8));
		
		 BeanUtils.copyProperties(testScenarioModel, testScenarioDomain);
		  Response response=testScenarioDao.saveScenario(testScenarioDomain);
		  return response;
		}catch (Exception e) {	
			log.info(e.getMessage());
		}return null;
	}

	@Override
	public TestScenarioModel getTestScenarioById(String testScenarioId) {
		try {
			TestScenarioModel testScenarioModel=new TestScenarioModel();
			TestScenarioDomain testScenarioDomain=testScenarioDao.getTestScenarioById(testScenarioId);
			BeanUtils.copyProperties(testScenarioDomain, testScenarioModel);
			return testScenarioModel;
			}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}

	@Override
	public List<TestScenarioModel> getTestScenarioList() {
		try {
			List<TestScenarioModel> TestScenarioModellList=new ArrayList<>();
			
			 List<TestScenarioDomain> testScenarioDomainList=testScenarioDao.getTestScenarioList();
			 for(TestScenarioDomain requirementDomain:testScenarioDomainList)
			 {
				 TestScenarioModel testScenarioModel=new TestScenarioModel();
			BeanUtils.copyProperties(requirementDomain, testScenarioModel);
			TestScenarioModellList.add(testScenarioModel);
			
			}
			 
			 return TestScenarioModellList;
		}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	
	}

}
