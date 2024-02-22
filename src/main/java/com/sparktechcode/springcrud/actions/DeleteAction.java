package com.sparktechcode.springcrud.actions;

import com.sparktechcode.springcrud.controllers.find.FilterableAction;
import com.sparktechcode.springcrud.mappers.ReadMapper;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springcrud.services.CrudService;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface DeleteAction<Id, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends FilterableAction<Id, Entity> {

    ReadMapper<Id, Entity, Response> getMapper();
    CrudService<Id, Entity> getService();

    default Response remove(String id) {
        return remove(id, PathParams.getInstance());
    }

    default Response remove(String id, PathParams pathParams) {
        onBeforeDelete(id, pathParams);
        var entity = getService().findById(id, additionalFindFilter(pathParams));
        onBeforeDelete(entity, pathParams);
        entity = getService().remove(entity);
        onAfterDelete(entity);
        return getMapper().toFullDto(entity, pathParams);
    }

    default void onBeforeDelete(String id, PathParams pathParams) {
        onBeforeDelete(id);
    }

    default void onBeforeDelete(Entity entity, PathParams pathParams) {
        onBeforeDelete(entity);
    }

    default void onBeforeDelete(String id) {
    }

    default void onBeforeDelete(Entity entity) {
    }

    default void onAfterDelete(Entity entity) {
    }
}
