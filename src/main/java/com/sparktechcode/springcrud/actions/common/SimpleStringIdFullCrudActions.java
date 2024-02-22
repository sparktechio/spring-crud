package com.sparktechcode.springcrud.actions.common;

import com.sparktechcode.springcrud.actions.multiple.SCRUDActions;
import com.sparktechcode.springjpasearch.entities.BaseEntity;

public interface SimpleStringIdFullCrudActions<Entity extends BaseEntity<Long>> extends
        SCRUDActions<Long, Entity, Entity, Entity> {
}
