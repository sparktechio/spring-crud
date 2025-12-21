package com.sparktechcode.springcrud.actions.multiple;

import com.sparktechcode.springcrud.actions.ArchiveAction;
import com.sparktechcode.springcrud.actions.ReadAction;
import com.sparktechcode.springcrud.actions.SearchAction;
import com.sparktechcode.springcrud.actions.UpdateAction;
import com.sparktechcode.springcrud.entities.BaseArchiveEntity;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.IdHolder;

import java.io.Serializable;

public interface SRUAActions<Id extends Serializable, Request, Entity extends BaseArchiveEntity<Id>, Response extends IdHolder<Id>> extends
        ReadAction<Id, Entity, Response>,
        ArchiveAction<Id, Entity, Response>,
        UpdateAction<Id, Request, Entity, Response>,
        SearchAction<Id, Entity, Response> {

    default void onBeforeMapping(Id id, Entity entity, PathParams pathParams) {
        onBeforeMapping(entity, pathParams);
    }

    default void onBeforeMapping(Entity entity, PathParams pathParams) {
        onBeforeMapping(entity);
    }

    default void onBeforeMapping(Entity entity) {
    }
}
