package com.sparktechcode.springcrud.mappers;

import com.sparktechcode.springcrud.payloads.PageData;
import com.sparktechcode.springjpasearch.entities.BaseEntity;
import com.sparktechcode.springjpasearch.entities.IdHolder;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public interface ReadMapper<Id, Entity extends BaseEntity<Id>, Response extends IdHolder<Id>> {

    Response toPlainDto(Entity entity);

    default Response toDto(Entity entity) {
        var response = toPlainDto(entity);
        return onAfterMapping(entity, response);
    }

    default Response onAfterMapping(Entity entity, Response response) {
        return response;
    }

    default List<Response> toDtoList(List<Entity> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }
        return entities.stream().map(this::toDto).filter(distinctByKey(IdHolder::getId)).collect(toList());
    }

    default <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        var seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    default PageData<Response> toPage(Page<Entity> page) {
        return new PageData<>(toDtoList(page.getContent()), page.getTotalElements());
    }

    default PageData<Response> toPage(List<Entity> page) {
        return new PageData<>(toDtoList(page), page.size());
    }

    default PageData<Response> toPage(List<Entity> page, Long size) {
        return new PageData<>(toDtoList(page), size);
    }
}
