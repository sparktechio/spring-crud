package com.sparktechcode.springcrud.controllers.common;

import com.sparktechcode.springcrud.controllers.multiple.SCRUDController;
import com.sparktechcode.springjpasearch.entities.BaseEntity;

public interface SimpleStringIdFullCrudController<Entity extends BaseEntity<Long>> extends
        SCRUDController<Long, Entity, Entity, Entity> {
}
