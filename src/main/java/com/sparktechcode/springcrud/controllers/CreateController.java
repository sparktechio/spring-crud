package com.sparktechcode.springcrud.controllers;


import com.sparktechcode.springcrud.actions.CreateAction;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;
import jakarta.transaction.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface CreateController<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        CreateAction<Id, Request, Entity, Response> {

    @PostMapping()
    @Transactional()
    default Response create(
            @Validated @RequestBody Request payload,
            @PathVariable(required = false) Map<String, String> pathParams
    ) {
        return create(payload, PathParams.of(pathParams));
    }
}
