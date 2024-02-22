package com.sparktechcode.springcrud.actions.multiple;

import com.sparktechcode.springcrud.actions.CreateAction;
import com.sparktechcode.springcrud.actions.DeleteAction;
import com.sparktechcode.springcrud.actions.ReadAction;
import com.sparktechcode.springcrud.actions.SearchAction;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface SCRDActions<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        CreateAction<Id, Request, Entity, Response>,
        ReadAction<Id, Entity, Response>,
        DeleteAction<Id, Entity, Response>,
        SearchAction<Id, Entity, Response> {
}
