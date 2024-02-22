package com.sparktechcode.springcrud.actions.multiple;

import com.sparktechcode.springcrud.actions.DeleteAction;
import com.sparktechcode.springcrud.actions.ReadAction;
import com.sparktechcode.springcrud.actions.SearchAction;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface SRDActions<Id, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        ReadAction<Id, Entity, Response>,
        DeleteAction<Id, Entity, Response>,
        SearchAction<Id, Entity, Response> {
}
