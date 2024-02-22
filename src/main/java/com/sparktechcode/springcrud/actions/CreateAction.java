package com.sparktechcode.springcrud.actions;


import com.sparktechcode.springcrud.mappers.CrudMapper;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springcrud.services.CrudService;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface CreateAction<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> {

    CrudMapper<Id, Request, Entity, Response> getMapper();

    CrudService<Id, Entity> getService();

    default Response create(Request payload) {
        return create(payload, PathParams.getInstance());
    }

    default Response create(Request payload, PathParams pathParams) {
        onBeforeCreate(payload, pathParams);
        var entity = getMapper().toNewEntity(payload, pathParams);
        onBeforeCreate(payload, entity, pathParams);
        entity = getService().create(entity);
        onAfterCreate(entity);
        return getMapper().toFullDto(entity, pathParams);
    }

    default void onBeforeCreate(Request payload, PathParams pathParams) {
        onBeforeCreate(payload);
    }

    default void onBeforeCreate(Request payload, Entity entity, PathParams pathParams) {
        onBeforeCreate(payload, entity);
    }

    default void onBeforeCreate(Request payload) {
    }

    default void onBeforeCreate(Request payload, Entity entity) {
    }

    default void onAfterCreate(Entity entity) {
    }
}
