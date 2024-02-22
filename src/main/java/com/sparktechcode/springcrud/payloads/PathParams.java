package com.sparktechcode.springcrud.payloads;

import java.util.HashMap;
import java.util.Map;

public interface PathParams extends Map<String, String> {

    static PathParams getInstance() {
        class PathParamsImpl extends HashMap<String, String> implements PathParams {}
        return new PathParamsImpl();
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
