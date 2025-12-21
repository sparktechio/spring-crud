package com.sparktechcode.springcrud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public abstract class BaseArchiveEntity<Id extends Serializable> extends AutoIdBaseEntity<Id> {

    @Column(name = "archived")
    private Instant archived;
}
