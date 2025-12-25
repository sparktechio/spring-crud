package com.sparktechcode.springcrud.controllers;

import com.sparktechcode.springcrud.actions.ArchiveAction;
import com.sparktechcode.springcrud.entities.ArchiveEntity;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.Map;

public interface ArchiveController<Id extends Serializable, Entity extends BaseEntity<Id> & ArchiveEntity, Response extends IdHolder<Id>> extends
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
