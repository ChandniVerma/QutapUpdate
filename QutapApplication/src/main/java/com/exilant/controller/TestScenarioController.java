package com.exilant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exilant.CommonUtils.Response;
import com.exilant.CommonUtils.StatusCode;
import com.exilant.CommonUtils.Utils;
import com.exilant.model.RequirementModel;
import com.exilant.model.TestScenarioModel;
import com.exilant.service.RequirementService;
import com.exilant.service.TestScenarioService;
@RestController
@RequestMapping("/QutapScenario")
public class TestScenarioController {
org.slf4j.Logger log= LoggerFactory.getLogger(ProjectInfoController.class);
	
	@Autowired
	TestScenarioService testScenarioService;
	

	@PostMapping("/saveScenario")
	public Response saveScenario(@RequestBody TestScenarioModel testScenarioModel,HttpServletRequest req) { 
		log.info("url of the application"+req.getRequestURL().toString());
		Response response=testScenarioService.saveScenario(testScenarioModel);
		response.setUrl(req.getRequestURL().toString());
		return response;
		
	}

	
	
	@GetMapping("/Scenario/{testScenarioId}")
	public   Object getRequirementById(@PathVariable String testScenarioId,HttpServletRequest req) {
		Response response=Utils.getResponseObject("getting project details data");
		try {
		
			TestScenarioModel testScenarioModel=testScenarioService.getTestScenarioById(testScenarioId);
		if(testScenarioModel==null) {
			response.setStatus(StatusCode.FAILURE.name());
		}else {
			response.setStatus(StatusCode.SUCCESS.name());
			response.setUrl(req.getRequestURL().toString());
			response.setData(testScenarioModel);
			return   Utils.getJson(response);	
		}
		}catch(Exception e) {
			
			response.setStatus(StatusCode.FAILURE.name());
			response.setErrors(e.getMessage());
			log.info(e.getMessage());
		}
		return null;
		
	}
	@GetMapping("/Scenarios")
	public  Object getProjectListInfo(HttpServletRequest req) {
		Response response=Utils.getResponseObject("getting project details data");
		try {
		
		List<TestScenarioModel> testScenarioModellList=testScenarioService.getTestScenarioList();
		if(testScenarioModellList==null) {
			response.setStatus(StatusCode.FAILURE.name());
		}else {
			response.setStatus(StatusCode.SUCCESS.name());
			response.setUrl(req.getRequestURL().toString());
			response.setData(testScenarioModellList);
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
