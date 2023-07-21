package com.zebrunner.carina.demo.restApi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/api/v1/employee/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/employees/get/response_employeeById.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetEmployeeByIdMethod extends AbstractApiMethodV2 {

    public GetEmployeeByIdMethod(int employeeId) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("base"));
        replaceUrlPlaceholder("id", String.valueOf(employeeId));
    }
}