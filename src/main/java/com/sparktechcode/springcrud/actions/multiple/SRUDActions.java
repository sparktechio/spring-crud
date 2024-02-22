package com.sparktechcode.springcrud.actions.multiple;

import com.sparktechcode.springcrud.actions.DeleteAction;
import com.sparktechcode.springcrud.actions.ReadAction;
import com.sparktechcode.springcrud.actions.SearchAction;
import com.sparktechcode.springcrud.actions.UpdateAction;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface SRUDActions<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        ReadAction<Id, Entity, Response>,
        DeleteAction<Id, Entity, Response>,
        UpdateAction<Id, Request, Entity, Response>,
        SearchAction<Id, Entity, Response> {
}
