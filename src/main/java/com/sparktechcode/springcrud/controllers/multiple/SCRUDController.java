package com.sparktechcode.springcrud.controllers.multiple;

import com.sparktechcode.springcrud.controllers.SearchController;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface SCRUDController<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        CRUDController<Id, Request, Entity, Response>,
        SearchController<Id, Entity, Response> {
}
