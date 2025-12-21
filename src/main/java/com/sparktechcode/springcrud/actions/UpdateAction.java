package com.sparktechcode.springcrud.actions;

import com.sparktechcode.springcrud.controllers.find.FilterableAction;
import com.sparktechcode.springcrud.mappers.CrudMapper;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springcrud.services.CrudService;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface UpdateAction<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends FilterableAction<Id, Entity> {

    CrudMapper<Id, Request, Entity, Response> getMapper();
    CrudService<Id, Entity> getService();

    default Response update(Id id, Request payload) {
        return update(id, payload, PathParams.getInstance());
    }

    default Response update(Id id, Request payload, PathParams pathParams) {
        onBeforeUpdate(id, payload, pathParams);
        var entity = getService().findById(id, additionalFindFilter(pathParams));
        onBeforeMapping(id, payload, entity, pathParams);
        getMapper().toExistingEntity(payload, entity, pathParams);
        onBeforeUpdate(id, payload, entity, pathParams);
        entity = getService().update(entity);
        onAfterUpdate(payload, entity, pathParams);
        return getMapper().toFullDto(entity, pathParams);
    }

    default void onBeforeUpdate(Id id, Request payload, PathParams pathParams) {
    }

    default void onBeforeMapping(Id id, Request payload, Entity entity, PathParams pathParams) {
        onBeforeMapping(payload, entity, pathParams);
    }

    default void onBeforeMapping(Request payload, Entity entity, PathParams pathParams) {
        onBeforeMapping(payload, entity);
    }

    default void onBeforeMapping(Request payload, Entity entity) {
        onBeforeMapping(entity);
    }

    default void onBeforeMapping(Entity entity) {
    }

    default void onBeforeUpdate(Id id, Request payload, Entity entity, PathParams pathParams) {
        onBeforeUpdate(id, payload, entity);
    }

    default void onBeforeUpdate(Id id, Request payload, Entity entity) {
        onBeforeUpdate(entity);
    }

    default void onBeforeUpdate(Entity entity) {
    }

    default void onAfterUpdate(Request payload, Entity entity, PathParams pathParams) {
        onAfterUpdate(entity, pathParams);
    }

    default void onAfterUpdate(Entity entity, PathParams pathParams) {
        onAfterUpdate(entity);
    }

    default void onAfterUpdate(Entity entity) {
    }
}
