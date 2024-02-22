package com.sparktechcode.springcrud.actions;

import com.sparktechcode.springcrud.controllers.find.FilterableAction;
import com.sparktechcode.springcrud.mappers.ReadMapper;
import com.sparktechcode.springcrud.payloads.PageData;
import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springcrud.payloads.QueryParams;
import com.sparktechcode.springcrud.services.CrudService;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;
import org.springframework.data.jpa.domain.Specification;

public interface SearchAction<Id, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends FilterableAction<Id, Entity> {

    ReadMapper<Id, Entity, Response> getMapper();

    CrudService<Id, Entity> getService();

    default Specification<Entity> additionalSearchFilter(QueryParams queryParams) {
        return additionalFindFilter();
    }

    default Specification<Entity> additionalSearchFilter(QueryParams queryParams, PathParams pathParams) {
        return additionalFindFilter(pathParams);
    }

    default ReadMapper<Id, Entity, Response> getSearchMapper() {
        return getMapper();
    }
    default PageData<Response> search(QueryParams queryParams) {
        return search(queryParams, null);
    }

    default PageData<Response> search(QueryParams queryParams, PathParams pathParams) {
        return getSearchMapper().toPage(getService().search(queryParams, additionalSearchFilter(queryParams, pathParams)));
    }
}
