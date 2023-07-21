package com.zebrunner.carina.demo.restApi;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/api/v1/delete/${id}", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/employees/delete/request.json")
@ResponseTemplatePath(path = "api/employees/delete/response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteEmployeeMethod extends AbstractApiMethodV2 {

    public DeleteEmployeeMethod(int employeeId) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("base"));
        replaceUrlPlaceholder("id", String.valueOf(employeeId));
    }
}