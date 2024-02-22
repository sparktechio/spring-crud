package com.sparktechcode.springcrud.payloads;

import java.util.HashMap;
import java.util.Map;

public interface PathParams extends Map<String, String> {

    static PathParams getInstance() {
        class PathParamsImpl extends HashMap<String, String> implements PathParams {}
        return new PathParamsImpl();
    }

    static PathParams of(Map<String, String> params) {
        var instance = getInstance();
        instance.putAll(params);
        return instance;
    }

    default String getId() {
        return get("id");
    }

    default String getTenantId() {
        return get("tenantId");
    }

    default String getCompanyId() {
        return get("companyId");
    }

    default String getUserId() {
        return get("userId");
    }
}
