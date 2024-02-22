package com.sparktechcode.springcrud.actions;

import com.sparktechcode.springcrud.controllers.find.FilterableAction;
import com.sparktechcode.springcrud.mappers.ReadMapper;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springcrud.services.CrudService;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface ReadAction<Id, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends FilterableAction<Id, Entity> {

    ReadMapper<Id, Entity, Response> getMapper();
    CrudService<Id, Entity> getService();

    default Response findById(String id) {
        return findById(id, PathParams.getInstance());
    }

    default Response findById(String id, PathParams pathParams) {
        var entity = getService().findById(id, additionalFindFilter(pathParams));
        onAfterFind(entity, pathParams);
        return getMapper().toDto(entity);
    }

    default void onAfterFind(Entity entity, PathParams pathParams) {
        onAfterFind(entity);
    }

    default void onAfterFind(Entity entity) {
    }
}
