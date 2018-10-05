package com.exilant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exilant.CommonUtils.Response;
import com.exilant.dao.ProjectInfoDao;
import com.exilant.dao.RequirementDao;
import com.exilant.model.ProjectInfoModel;
import com.exilant.model.RequirementModel;
import com.exilant.test.ProjectInfoDomain;
import com.exilant.test.RequirementDomain;

@Service
public class RequirementServiceImpl implements RequirementService {
	org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoServiceImpl.class);
	@Autowired
	RequirementDao requirementDao;
	
	@Override
	public Response saveRequirement(RequirementModel requirementModel) {
		
		try {
			RequirementDomain requirementDomain=new RequirementDomain();
			requirementModel.setRequirementId(UUID.randomUUID().toString().substring(0, 8));
		 BeanUtils.copyProperties(requirementModel, requirementDomain);
		  Response response=requirementDao.saveRequirement(requirementDomain);
		  return response;
		}catch (Exception e) {	
			log.info(e.getMessage());
		}return null;
	}

	@Override
	public RequirementModel getRequirementById(String requirementId) {
		try {
			RequirementModel requirementModel=new RequirementModel();
			RequirementDomain requirementDomain=requirementDao.getRequirementById(requirementId);
			BeanUtils.copyProperties(requirementDomain, requirementModel);
			return requirementModel;
			}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	}

	@Override
	public List<RequirementModel> getRequirementList() {
		try {
			List<RequirementModel> requirementModelList=new ArrayList<>();
			
			 List<RequirementDomain> requirementDomainList=requirementDao.getRequirementList();
			 for(RequirementDomain requirementDomain:requirementDomainList)
			 {
				 RequirementModel requirementModel=new RequirementModel();
			BeanUtils.copyProperties(requirementDomain, requirementModel);
			requirementModelList.add(requirementModel);
			
			}
			 
			 return requirementModelList;
		}
			catch (Exception e) {
				log.info(e.getMessage());
				return null;
			}
	
	}
	
	
}
