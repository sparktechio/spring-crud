package com.sparktechcode.springcrud.controllers.multiple;

import com.sparktechcode.springcrud.controllers.*;
import com.sparktechcode.springcrud.entities.BaseArchiveEntity;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

import java.io.Serializable;

public interface SCRAController<Id extends Serializable, Request, Entity extends BaseArchiveEntity<Id>, Response extends IdHolder<Id>> extends
        CreateController<Id, Request, Entity, Response>,
        ReadController<Id, Entity, Response>,
        ArchiveController<Id, Entity, Response>,
        SearchController<Id, Entity, Response> {
}
