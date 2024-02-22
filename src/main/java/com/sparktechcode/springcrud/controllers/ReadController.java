package com.sparktechcode.springcrud.controllers;

import com.sparktechcode.springcrud.actions.ReadAction;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ReadController<Id, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        ReadAction<Id, Entity, Response> {

    @Transactional()
    @GetMapping("{id}")
    default Response findById(
            @PathVariable String id,
            @PathVariable(required = false) PathParams pathParams
    ) {
        return ReadAction.super.findById(id, pathParams);
    }
}
