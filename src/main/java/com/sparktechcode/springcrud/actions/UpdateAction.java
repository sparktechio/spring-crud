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

    default Response update(String id, Request payload) {
        return update(id, payload, PathParams.getInstance());
    }

    default Response update(String id, Request payload, PathParams pathParams) {
        onBeforeUpdate(id, payload, pathParams);
        var entity = getService().findById(id, additionalFindFilter(pathParams));
        onBeforeUpdate(entity, pathParams);
        getMapper().toExistingEntity(payload, entity, pathParams);
        onBeforeUpdate(id, payload, entity, pathParams);
        entity = getService().update(entity);
        onAfterUpdate(entity, pathParams);
        return getMapper().toDto(entity);
    }

    default void onBeforeUpdate(String id, Request payload, PathParams pathParams) {
        onBeforeUpdate(id, payload);
    }

    default void onBeforeUpdate(Entity entity, PathParams pathParams) {
        onBeforeUpdate(entity);
    }

    default void onBeforeUpdate(String id, Request payload, Entity entity, PathParams pathParams) {
        onBeforeUpdate(id, payload, entity);
    }

    default void onAfterUpdate(Entity entity, PathParams pathParams) {
        onBeforeUpdate(entity);
    }

    default void onBeforeUpdate(String id, Request payload) {
    }

    default void onBeforeUpdate(Entity entity) {
    }

    default void onBeforeUpdate(String id, Request payload, Entity entity) {
    }

    default void onAfterUpdate(Entity entity) {
    }
}
