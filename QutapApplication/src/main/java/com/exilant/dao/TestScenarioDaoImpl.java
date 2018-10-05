package com.exilant.dao;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.exilant.CommonUtils.Response;
import com.exilant.CommonUtils.StatusCode;
import com.exilant.CommonUtils.Utils;
import com.exilant.test.RequirementDomain;
import com.exilant.test.TestScenarioDomain;
@Repository
public class TestScenarioDaoImpl implements TestScenarioDao {

	
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoDaoImpl.class);
	@Autowired 
	MongoTemplate mongoTemplate;
	
	@Override
	public Response saveScenario(TestScenarioDomain testScenarioDomain) {
		Response response=Utils.getResponseObject("Adding project Details");
		try {
		mongoTemplate.insert(testScenarioDomain,"Scenario");
		response.setStatus(StatusCode.SUCCESS.name());
		response.setData(testScenarioDomain);
		return response;
		}catch (Exception e) {
			log.info(e.getMessage());
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			return response;
		}
	}

	@Override
	public TestScenarioDomain getTestScenarioById(String testScenarioId) {
		try {
			return mongoTemplate.findById(testScenarioId, TestScenarioDomain.class);
			}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}

	@Override
	public List<TestScenarioDomain> getTestScenarioList() {
		try {
			return mongoTemplate.findAll(TestScenarioDomain.class, "Scenario");
			}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}

}
