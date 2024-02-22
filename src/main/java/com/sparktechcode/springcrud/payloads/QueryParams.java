package com.sparktechcode.springcrud.payloads;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public interface QueryParams extends MultiValueMap<String, String> {

    static QueryParams getInstance() {
        class QueryParamsImpl extends LinkedMultiValueMap<String, String> implements QueryParams {}
        return new QueryParamsImpl();
    }
}
