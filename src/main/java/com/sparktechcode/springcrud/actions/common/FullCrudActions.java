package com.sparktechcode.springcrud.actions.common;

import com.sparktechcode.springcrud.actions.multiple.SCRUDActions;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface FullCrudActions<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends
        SCRUDActions<Id, Request, Entity, Response> {
}
