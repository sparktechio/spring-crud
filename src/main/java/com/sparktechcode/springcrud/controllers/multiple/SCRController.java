package com.sparktechcode.springcrud.controllers.multiple;

import com.sparktechcode.springcrud.controllers.CreateController;
import com.sparktechcode.springcrud.controllers.ReadController;
import com.sparktechcode.springcrud.controllers.SearchController;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface SCRController<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        CreateController<Id, Request, Entity, Response>,
        ReadController<Id, Entity, Response>,
        SearchController<Id, Entity, Response> {
}
