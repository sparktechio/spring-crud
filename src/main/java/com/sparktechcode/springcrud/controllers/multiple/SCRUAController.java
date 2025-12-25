package com.sparktechcode.springcrud.controllers.multiple;

import com.sparktechcode.springcrud.controllers.SearchController;
import com.sparktechcode.springcrud.entities.ArchiveEntity;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

import java.io.Serializable;

public interface SCRUAController<Id extends Serializable, Request, Entity extends BaseEntity<Id> & ArchiveEntity, Response extends IdHolder<Id>> extends
        CRUAController<Id, Request, Entity, Response>,
        SearchController<Id, Entity, Response> {
}
