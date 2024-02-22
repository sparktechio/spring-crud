package com.sparktechcode.springcrud.mappers;

import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;

public interface CrudMapper<Id, Request, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> extends ReadMapper<Id, Entity, Response>, WriteMapper<Id, Entity, Request> {
}
