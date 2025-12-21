package com.sparktechcode.springcrud.controllers;

import com.sparktechcode.springcrud.actions.ArchiveAction;
import com.sparktechcode.springcrud.entities.BaseArchiveEntity;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.IdHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.io.Serializable;
import java.util.Map;

public interface ArchiveController<Id extends Serializable, Entity extends BaseArchiveEntity<Id>, Response extends IdHolder<Id>> extends
        ArchiveAction<Id, Entity, Response> {

    @Transactional()
    @DeleteMapping("{id}")
    default Response archive(
            @PathVariable Id id,
            @PathVariable(required = false) Map<String, String> pathParams
    ) {
        return archive(id, PathParams.of(pathParams));
    }
}
