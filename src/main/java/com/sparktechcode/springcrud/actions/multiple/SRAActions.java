package com.sparktechcode.springcrud.actions.multiple;

import com.sparktechcode.springcrud.actions.ArchiveAction;
import com.sparktechcode.springcrud.actions.ReadAction;
import com.sparktechcode.springcrud.actions.SearchAction;
import com.sparktechcode.springcrud.entities.BaseArchiveEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

import java.io.Serializable;

public interface SRAActions<Id extends Serializable, Entity extends BaseArchiveEntity<Id>, Response extends IdHolder<Id>> extends
        ReadAction<Id, Entity, Response>,
        ArchiveAction<Id, Entity, Response>,
        SearchAction<Id, Entity, Response> {
}
