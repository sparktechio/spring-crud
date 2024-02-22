package com.sparktechcode.springcrud.entities;

import com.sparktechcode.springjpasearch.entities.BaseEntity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public abstract class ManualIdBaseEntity<I extends Serializable> extends AuditEntity implements BaseEntity<I> {

    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    private I id;
}
