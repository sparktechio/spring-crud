package com.sparktechcode.springcrud.actions.multiple;

import com.sparktechcode.springcrud.actions.SearchAction;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface SCRUDActions<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        CRUDActions<Id, Request, Entity, Response>,
        SearchAction<Id, Entity, Response> {
}
