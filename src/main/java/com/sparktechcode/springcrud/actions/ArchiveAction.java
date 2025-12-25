package com.sparktechcode.springcrud.actions;

import com.sparktechcode.springcrud.controllers.find.FilterableAction;
import com.sparktechcode.springcrud.entities.ArchiveEntity;
import com.sparktechcode.springcrud.mappers.ReadMapper;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springcrud.services.CrudService;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

import java.io.Serializable;
import java.time.Instant;

public interface ArchiveAction<Id extends Serializable, Entity extends BaseEntity<Id> & ArchiveEntity, Response extends IdHolder<Id>> extends FilterableAction<Id, Entity> {

    ReadMapper<Id, Entity, Response> getMapper();
    CrudService<Id, Entity> getService();

    default Response archive(Id id) {
        return archive(id, PathParams.getInstance());
    }

    default Response archive(Id id, PathParams pathParams) {
        onBeforeArchive(id, pathParams);
        var entity = getService().findById(id, additionalFindFilter(pathParams));
        onBeforeMapping(id, entity, pathParams);
        entity.setArchived(Instant.now());
        onBeforeArchive(id, entity, pathParams);
        entity = getService().save(entity);
        onAfterArchive(entity, pathParams);
        return getMapper().toFullDto(entity, pathParams);
    }

    default void onBeforeArchive(Id id, PathParams pathParams) {
    }

    default void onBeforeMapping(Id id, Entity entity, PathParams pathParams) {
        onBeforeMapping(entity, pathParams);
    }

    default void onBeforeMapping(Entity entity, PathParams pathParams) {
        onBeforeMapping(entity);
    }

    default void onBeforeMapping(Entity entity) {
    }

    default void onBeforeArchive(Id id, Entity entity, PathParams pathParams) {
        onBeforeArchive(id, entity);
    }

    default void onBeforeArchive(Id id, Entity entity) {
        onBeforeArchive(entity);
    }

    default void onBeforeArchive(Entity entity) {
    }

    default void onAfterArchive(Entity entity, PathParams pathParams) {
        onAfterArchive(entity);
    }

    default void onAfterArchive(Entity entity) {
    }
}
