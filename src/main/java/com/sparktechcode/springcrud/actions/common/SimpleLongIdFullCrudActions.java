package com.sparktechcode.springcrud.actions.common;

import com.sparktechcode.springcrud.actions.multiple.SCRUDActions;
import com.sparktechcode.springjpasearch.entities.BaseEntity;

public interface SimpleLongIdFullCrudActions<Entity extends BaseEntity<String>> extends
        SCRUDActions<String, Entity, Entity, Entity> {
}
