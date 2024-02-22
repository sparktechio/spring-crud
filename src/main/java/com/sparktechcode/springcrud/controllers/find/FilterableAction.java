package com.sparktechcode.springcrud.controllers.find;

import com.sparktechcode.springcrud.payloads.PathParams;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import org.springframework.data.jpa.domain.Specification;

public interface FilterableAction<Id, E extends BaseEntity<Id>> {

    default Specification<E> additionalFindFilter(PathParams pathParams) {
        return additionalFindFilter();
    }

    default Specification<E> additionalFindFilter() {
        return null;
    }
}
