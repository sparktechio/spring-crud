package com.sparktechcode.springcrud.controllers.multiple;

import com.sparktechcode.springcrud.controllers.DeleteController;
import com.sparktechcode.springcrud.controllers.ReadController;
import com.sparktechcode.springcrud.controllers.SearchController;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface SRDController<Id, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        ReadController<Id, Entity, Response>,
        DeleteController<Id, Entity, Response>,
        SearchController<Id, Entity, Response> {
}
