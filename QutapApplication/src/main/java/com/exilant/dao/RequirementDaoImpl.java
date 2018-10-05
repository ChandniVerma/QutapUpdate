package com.exilant.dao;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.exilant.CommonUtils.Response;
import com.exilant.CommonUtils.StatusCode;
import com.exilant.CommonUtils.Utils;
import com.exilant.test.ProjectInfoDomain;
import com.exilant.test.RequirementDomain;

@Repository
public class RequirementDaoImpl implements RequirementDao {
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoDaoImpl.class);
	@Autowired 
	MongoTemplate mongoTemplate;
	@Override
	public Response saveRequirement(RequirementDomain requirementDomain) {
		
			Response response=Utils.getResponseObject("Adding project Details");
			try {
			mongoTemplate.insert(requirementDomain,"Requirement");
			response.setStatus(StatusCode.SUCCESS.name());
			response.setData(requirementDomain);
			return response;
			}catch (Exception e) {
				log.info(e.getMessage());
				response.setStatus(StatusCode.FAILURE.name());
				response.setErrors(e.getMessage());
				return response;
			
			
		}
	}
	@Override
	public RequirementDomain getRequirementById(String requirementId) {
		try {
			return mongoTemplate.findById(requirementId, RequirementDomain.class);
			}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}
	@Override
	public List<RequirementDomain> getRequirementList() {
		try {
			return mongoTemplate.findAll(RequirementDomain.class, "Requirement");
			}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}

}
