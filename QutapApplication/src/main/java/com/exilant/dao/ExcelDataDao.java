package com.exilant.dao;

import com.exilant.CommonUtils.Response;
import com.exilant.domain.ProjectInfo;
import com.exilant.domain.Requirement;
import com.exilant.domain.TestSuite;
import com.exilant.test.ExcelDataDomain;

public interface ExcelDataDao {

	Response readExcelData(ProjectInfo projectInfo);
	Response requirementData(Requirement requirement);
	Response testSuitData(TestSuite testSuite);
}
