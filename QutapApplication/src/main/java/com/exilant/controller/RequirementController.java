package com.exilant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exilant.CommonUtils.Response;
import com.exilant.CommonUtils.StatusCode;
import com.exilant.CommonUtils.Utils;
import com.exilant.model.ProjectInfoModel;
import com.exilant.model.RequirementModel;
import com.exilant.service.ProjectInfoService;
import com.exilant.service.RequirementService;
@RestController
@RequestMapping("/QutapRequirement")
public class RequirementController {
	
org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoController.class);
	
	@Autowired
	RequirementService requirementService;
	

	@PostMapping("/saveRequirement")
	public Response saveRequirement(@RequestBody RequirementModel requirementModel,HttpServletRequest req) { 
		log.info("url of the application"+req.getRequestURL().toString());
		Response response=requirementService.saveRequirement(requirementModel);
		response.setUrl(req.getRequestURL().toString());
		return response;
		
	}

	
	
	@GetMapping("/Requirement/{requirementId}")
	public   Object getRequirementById(@PathVariable String requirementId,HttpServletRequest req) {
		Response response=Utils.getResponseObject("getting project details data");
		try {
		
			RequirementModel requirementModel=requirementService.getRequirementById(requirementId);
		if(requirementModel==null) {
			response.setStatus(StatusCode.FAILURE.name());
		}else {
			response.setStatus(StatusCode.SUCCESS.name());
			response.setUrl(req.getRequestURL().toString());
			response.setData(requirementModel);
			return   Utils.getJson(response);	
		}
		}catch(Exception e) {
			
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return null;
		
	}
	@GetMapping("/Requirements")
	public  Object getProjectListInfo(HttpServletRequest req) {
		Response response=Utils.getResponseObject("getting project details data");
		try {
		
		List<RequirementModel> requirementModelList=requirementService.getRequirementList();
		if(requirementModelList==null) {
			response.setStatus(StatusCode.FAILURE.name());
		}else {
			response.setStatus(StatusCode.SUCCESS.name());
			response.setUrl(req.getRequestURL().toString());
			response.setData(requirementModelList);
			return   Utils.getJson(response);	
		}
		}catch(Exception e) {
			
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return null;
		
	}
}




