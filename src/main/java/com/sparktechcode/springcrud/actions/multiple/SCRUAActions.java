package com.sparktechcode.springcrud.actions.multiple;

import com.sparktechcode.springcrud.actions.SearchAction;
import com.sparktechcode.springcrud.entities.BaseArchiveEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

import java.io.Serializable;

public interface SCRUAActions<Id extends Serializable, Request, Entity extends BaseArchiveEntity<Id>, Response extends IdHolder<Id>> extends
        CRUAActions<Id, Request, Entity, Response>,
        SearchAction<Id, Entity, Response> {
}
