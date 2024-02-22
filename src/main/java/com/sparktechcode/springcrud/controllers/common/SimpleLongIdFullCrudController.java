package com.sparktechcode.springcrud.controllers.common;

import com.sparktechcode.springcrud.controllers.multiple.SCRUDController;
import com.sparktechcode.springjpasearch.entities.BaseEntity;

public interface SimpleLongIdFullCrudController<Entity extends BaseEntity<String>> extends
        SCRUDController<String, Entity, Entity, Entity> {
}
