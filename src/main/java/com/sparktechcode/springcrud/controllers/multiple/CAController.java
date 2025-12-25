package com.sparktechcode.springcrud.controllers.multiple;

import com.sparktechcode.springcrud.controllers.ArchiveController;
import com.sparktechcode.springcrud.controllers.CreateController;
import com.sparktechcode.springcrud.entities.ArchiveEntity;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

import java.io.Serializable;

public interface CAController<Id extends Serializable, Request, Entity extends BaseEntity<Id> & ArchiveEntity, Response extends IdHolder<Id>> extends
        CreateController<Id, Request, Entity, Response>,
        ArchiveController<Id, Entity, Response> {
}
