package com.exilant.service;

import java.util.List;

import com.exilant.CommonUtils.Response;
import com.exilant.model.RequirementModel;
import com.exilant.test.RequirementDomain;

public interface RequirementService {
	Response saveRequirement(RequirementModel RequirementModel);
	RequirementModel getRequirementById(String requirementId);
	
	public List<RequirementModel> getRequirementList();

}
