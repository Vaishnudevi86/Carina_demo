package com.zebrunner.carina.demo.restApi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/api/v1/create", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/employees/create/request.json")
@ResponseTemplatePath(path = "api/employees/create/response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostEmployeeMethod extends AbstractApiMethodV2 {

    public PostEmployeeMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("base"));
    }
}