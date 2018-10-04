package com.exilant.dao;

import com.exilant.CommonUtils.Response;
import com.exilant.domain.ExcelDataDomain;

public interface ExcelDataDao {

	Response readExcelData(ExcelDataDomain excelDataDomain);

}
