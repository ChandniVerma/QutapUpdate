package com.exilant.dao;

import java.util.List;

import com.exilant.CommonUtils.Response;
import com.exilant.domain.ProjectInfoDomain;
import com.exilant.domain.RequirementDomain;

public interface RequirementDao {
	Response saveRequirement(RequirementDomain requirementDomain);
	RequirementDomain getRequirementById(String requirementId);
	
	public List<RequirementDomain> getRequirementList();

}
