package com.sparktechcode.springcrud.controllers;

import com.sparktechcode.springcrud.actions.UpdateAction;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface UpdateController<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        UpdateAction<Id, Request, Entity, Response> {

    @Transactional()
    @PutMapping("{id}")
    default Response update(
            @PathVariable Id id,
            @Validated @RequestBody Request payload,
            @PathVariable(required = false) Map<String, String> pathParams
    ) {
        return update(id, payload, PathParams.of(pathParams));
    }
}
