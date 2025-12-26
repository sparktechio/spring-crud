package com.sparktechcode.springcrud.controllers;

import com.sparktechcode.springcrud.actions.DeleteAction;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public interface DeleteController<Id, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        DeleteAction<Id, Entity, Response> {

    @Transactional()
    @DeleteMapping("{id}")
    default Response remove(
            @PathVariable Id id,
            @PathVariable(required = false) Map<String, String> pathParams
    ) {
        return remove(id, PathParams.of(pathParams));
    }
}
