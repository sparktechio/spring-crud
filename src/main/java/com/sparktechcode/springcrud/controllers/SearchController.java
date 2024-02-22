package com.sparktechcode.springcrud.controllers;

import com.sparktechcode.springcrud.actions.SearchAction;
import com.sparktechcode.springcrud.payloads.PageData;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springcrud.payloads.QueryParams;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface SearchController<Id, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        SearchAction<Id, Entity, Response> {

    @GetMapping()
    @Transactional()
    default PageData<Response> search(
            @RequestParam(required = false) List<String> filter,
            @RequestParam(required = false) List<String> order,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit,
            @RequestParam(required = false) Boolean allData,
            @PathVariable(required = false) Map<String, String> pathParams,
            @RequestParam(required = false) MultiValueMap<String, String> queryParams) {
        return search(QueryParams.of(queryParams), PathParams.of(pathParams));
    }
}
