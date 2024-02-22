package com.sparktechcode.springcrud.controllers.common;

import com.sparktechcode.springcrud.controllers.multiple.SCRUDController;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface FullCrudController<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        SCRUDController<Id, Request, Entity, Response> {
}
