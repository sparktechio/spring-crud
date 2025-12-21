package com.sparktechcode.springcrud.actions.multiple;

import com.sparktechcode.springcrud.actions.ArchiveAction;
import com.sparktechcode.springcrud.actions.CreateAction;
import com.sparktechcode.springcrud.actions.ReadAction;
import com.sparktechcode.springcrud.actions.UpdateAction;
import com.sparktechcode.springcrud.entities.BaseArchiveEntity;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.IdHolder;

import java.io.Serializable;

public interface CRUAActions<Id extends Serializable, Request, Entity extends BaseArchiveEntity<Id>, Response extends IdHolder<Id>> extends
        CreateAction<Id, Request, Entity, Response>,
        ReadAction<Id, Entity, Response>,
        UpdateAction<Id, Request, Entity, Response>,
        ArchiveAction<Id, Entity, Response> {

    default void onBeforeMapping(Id id, Entity entity, PathParams pathParams) {
        onBeforeMapping(entity, pathParams);
    }

    default void onBeforeMapping(Entity entity, PathParams pathParams) {
        onBeforeMapping(entity);
    }

    default void onBeforeMapping(Entity entity) {
    }
}
