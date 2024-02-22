package com.sparktechcode.springcrud.mappers;

import com.sparktechcode.springcrud.payloads.PageData;
import com.sparktechcode.springcrud.payloads.PathParams;
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

    Response toDto(Entity entity);

    default Response toFullDto(Entity entity, PathParams pathParams) {
        var response = toDto(entity);
        return onAfterMapping(entity, response, pathParams);
    }

    default Response onAfterMapping(Entity entity, Response response, PathParams pathParams) {
        return response;
    }

    default List<Response> toDtoList(List<Entity> entities, PathParams pathParams) {
        if (entities == null) {
            return new ArrayList<>();
        }
        return entities.stream().map(entity -> toFullDto(entity, pathParams)).filter(distinctByKey(IdHolder::getId)).collect(toList());
    }

    default <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        var seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    default PageData<Response> toPage(Page<Entity> page, PathParams pathParams) {
        return new PageData<>(toDtoList(page.getContent(), pathParams), page.getTotalElements());
    }

    default PageData<Response> toPage(List<Entity> page, PathParams pathParams) {
        return new PageData<>(toDtoList(page, pathParams), page.size());
    }

    default PageData<Response> toPage(List<Entity> page, Long size, PathParams pathParams) {
        return new PageData<>(toDtoList(page, pathParams), size);
    }
}
