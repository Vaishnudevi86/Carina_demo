package com.zebrunner.carina.demo;

import com.zebrunner.carina.demo.restApi.GetAllEmployeesMethod;
import com.zebrunner.carina.demo.restApi.GetEmployeeByIdMethod;
import com.zebrunner.carina.demo.restApi.DeleteEmployeeMethod;
import com.zebrunner.carina.demo.restApi.PostEmployeeMethod;
import com.zebrunner.carina.demo.restApi.PutEmployeeMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;


import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class RestApiSampleTest implements IAbstractTest {

	@Test()
	@MethodOwner(owner = "vaishnu")
	public void testGetAllEmployees() {
		GetAllEmployeesMethod getAllEmployeesMethod = new GetAllEmployeesMethod();
		getAllEmployeesMethod.callAPIExpectSuccess();
		getAllEmployeesMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getAllEmployeesMethod.validateResponseAgainstSchema("api/employees/get/response.schema");
	}

	@Test()
	@MethodOwner(owner = "vaishnu")
	public void testGetEmployeeById() {
		GetEmployeeByIdMethod getEmployeeByIdMethod = new GetEmployeeByIdMethod(6);
		getEmployeeByIdMethod.callAPIExpectSuccess();
		getEmployeeByIdMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getEmployeeByIdMethod.validateResponseAgainstSchema("api/employees/get/response_employeeById.schema");
	}

	@Test()
	@MethodOwner(owner = "vaishnu")
	public void testCreateEmployee() {
		PostEmployeeMethod postEmployeeMethod = new PostEmployeeMethod();
		postEmployeeMethod.setProperties("api/employees/create/employee.properties");
		postEmployeeMethod.callAPIExpectSuccess();
		postEmployeeMethod.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "vaishnu")
	public void testUpdateEmployee() {
		PutEmployeeMethod putEmployeeMethod = new PutEmployeeMethod(21);
		putEmployeeMethod.callAPIExpectSuccess();
		putEmployeeMethod.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "vaishnu")
	public void testDeleteEmployee() {
		DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod(2);
		deleteEmployeeMethod.callAPIExpectSuccess();
		deleteEmployeeMethod.validateResponse();
	}
}