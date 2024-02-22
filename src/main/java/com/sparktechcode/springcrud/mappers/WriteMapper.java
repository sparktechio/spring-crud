package com.sparktechcode.springcrud.mappers;

import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import org.mapstruct.MappingTarget;

public interface WriteMapper<Id, Entity extends BaseEntity<Id>, R> {

    Entity toEntity(R request);

    void toEntity(R request, @MappingTarget Entity entity);

    default Entity toNewEntity(R request, PathParams pathParams) {
        var entity = toEntity(request);
        onAfterCreate(request, entity, pathParams);
        return entity;
    }

    default void toExistingEntity(R request, Entity entity, PathParams pathParams) {
        toEntity(request, entity);
        onAfterUpdate(request, entity, pathParams);
    }

    default void onAfterCreate(R request, Entity entity, PathParams pathParams) {
        onAfterCreate(request, entity);
    }

    default void onAfterUpdate(R request, Entity entity, PathParams pathParams) {
        onAfterUpdate(request, entity);
    }

    default void onAfterCreate(R request, Entity entity) {
        onAfterCreate(entity);
    }

    default void onAfterUpdate(R request, Entity entity) {
        onAfterUpdate(entity);
    }

    default void onAfterCreate(Entity entity) {
    }

    default void onAfterUpdate(Entity entity) {
    }
}
