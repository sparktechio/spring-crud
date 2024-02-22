package com.sparktechcode.springcrud.services;

import com.sparktechcode.springcrud.exceptions.NotFoundException;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.repositories.SparkJpaRepository;
import com.sparktechcode.springjpasearch.services.SearchService;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static java.lang.String.format;
import static java.lang.String.join;

public interface CrudService<Id, Entity extends BaseEntity<Id>> extends SearchService<Id, Entity> {

    SparkJpaRepository<Id, Entity> getRepository();

    default Entity findById(String id) {
        return getRepository().findById(id).orElseThrow(() -> notFoundException(id));
    }

    default Optional<Entity> tryToFindById(String id) {
        return getRepository().findById(id);
    }

    default Entity findById(String id, Specification<Entity> specification) {
        if (specification == null) {
            return findById(id);
        } else {
            return getRepository().findOne((root, query, builder) ->
                    builder.and(
                            builder.equal(root.get("id"), id),
                            specification.toPredicate(root, query, builder)
                    )
            ).orElseThrow(() -> notFoundException(id, specification));
        }
    }

    default Optional<Entity> tryToFindById(String id, Specification<Entity> specification) {
        if (specification == null) {
            return tryToFindById(id);
        } else {
            return getRepository().findOne((root, query, builder) ->
                    builder.and(
                            builder.equal(root.get("id"), id),
                            specification.toPredicate(root, query, builder)
                    )
            );
        }
    }

    default Entity getReferenceById(String id) {
        return getRepository().getReferenceById(id);
    }

    default List<Entity> findAll() {
        return getRepository().findAll();
    }

    default List<Entity> findBy(Specification<Entity> specification) {
        return getRepository().findAll(specification);
    }

    default Long countBy(Specification<Entity> specification) {
        return getRepository().count(specification);
    }

    default List<Entity> findByIds(List<String> ids) {
        if (ids == null) {
            return new ArrayList<>();
        }
        return getRepository().findAllById(ids);
    }

    default List<Entity> findByIds(List<String> ids, Specification<Entity> specification) {
        if (specification == null) {
            return findByIds(ids);
        } else {
            return getRepository().findAll((root, query, builder) ->
                    builder.and(
                            root.get("id").in(ids),
                            specification.toPredicate(root, query, builder)
                    )
            );
        }
    }

    default Entity save(Entity entity) {
        return getRepository().save(entity);
    }

    default Entity saveAndDo(Entity entity, Consumer<Entity> afterSave) {
        entity = getRepository().save(entity);
        afterSave.accept(entity);
        return entity;
    }

    default Entity create(Entity entity) {
        return save(entity);
    }

    default Entity update(Entity entity) {
        return save(entity);
    }

    default Entity remove(Entity entity) {
        getRepository().delete(entity);
        return entity;
    }

    default NotFoundException notFoundException(Object ...params) {
        var name = this.getClass().getSimpleName();
        var data = Arrays.stream(params == null ? new String[0] : params).map(Object::toString).toList();
        return new NotFoundException(format("Resource not found: %s: %s", name, join(", ", data)));
    }
}
