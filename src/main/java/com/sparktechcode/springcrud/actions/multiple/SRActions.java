package com.sparktechcode.springcrud.actions.multiple;

import com.sparktechcode.springcrud.actions.ReadAction;
import com.sparktechcode.springcrud.actions.SearchAction;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface SRActions<Id, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        ReadAction<Id, Entity, Response>,
        SearchAction<Id, Entity, Response> {
}
