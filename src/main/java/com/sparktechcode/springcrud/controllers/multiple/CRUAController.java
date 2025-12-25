package com.sparktechcode.springcrud.controllers.multiple;

import com.sparktechcode.springcrud.controllers.ArchiveController;
import com.sparktechcode.springcrud.controllers.CreateController;
import com.sparktechcode.springcrud.controllers.ReadController;
import com.sparktechcode.springcrud.controllers.UpdateController;
import com.sparktechcode.springcrud.entities.ArchiveEntity;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

import java.io.Serializable;

public interface CRUAController<Id extends Serializable, Request, Entity extends BaseEntity<Id> & ArchiveEntity, Response extends IdHolder<Id>> extends
        CreateController<Id, Request, Entity, Response>,
        ReadController<Id, Entity, Response>,
        UpdateController<Id, Request, Entity, Response>,
        ArchiveController<Id, Entity, Response> {

    default void onBeforeMapping(Id id, Entity entity, PathParams pathParams) {
        onBeforeMapping(entity, pathParams);
    }

    default void onBeforeMapping(Entity entity, PathParams pathParams) {
        onBeforeMapping(entity);
    }

    default void onBeforeMapping(Entity entity) {
    }
}
