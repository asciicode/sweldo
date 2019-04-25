package com.atzkarl.framework.base.dto.entity.converter;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.reflect.TypeUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.atzkarl.framework.base.dto.BaseDTO;
import com.atzkarl.framework.base.entity.BaseEntity;

public abstract class BaseDTOEntityConverter<D extends BaseDTO, E extends BaseEntity> {

    @Autowired
    private Mapper mapper;

    private Class<D> dtoClass;

    private Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDTOEntityConverter() {
        Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(
                getClass(), BaseDTOEntityConverter.class);
        for (TypeVariable<?> typeParameter : BaseDTOEntityConverter.class
                .getTypeParameters()) {
            Class<?> clazz = TypeUtils.getRawType(
                    typeArguments.get(typeParameter), null);
            switch (typeParameter.getName()) {
            case "D":
                dtoClass = (Class<D>) clazz;
                break;
            case "E":
                entityClass = (Class<E>) clazz;
                break;
            default:
                throw new IllegalStateException("Unknown type parameter: "
                        + typeParameter.getName());
            }
        }
    }

    public D fromEntity(E entity) {
        return mapper.map(entity, dtoClass);
    }

    public E toEntity(D dto) {
        return mapper.map(dto, entityClass);
    }

    public E toEntity(D dto, E existingEntity) {
        mapper.map(dto, existingEntity);
        return existingEntity;
    }

//    public List<Revision<Long, D>> fromRevisionEntities(
//            List<Revision<Long, E>> revisionEntities) {
//        List<Revision<Long, D>> revisionDTOs = new ArrayList<>(
//                revisionEntities.size());
//        for (Revision<Long, E> revisionEntity : revisionEntities) {
//            revisionDTOs.add(new Revision<Long, D>(
//                    revisionEntity.getMetadata(), fromEntity(revisionEntity
//                            .getEntity())));
//        }
//        return revisionDTOs;
//    }

    public Page<D> fromEntities(Page<E> entityPage) {
        List<D> dtos = new ArrayList<>(entityPage.getSize());
        for (E entity : entityPage) {
            dtos.add(fromEntity(entity));
        }
		return new PageImpl<>(dtos, PageRequest.of(entityPage.getNumber(),
                entityPage.getSize(), entityPage.getSort()),
                entityPage.getTotalElements());
    }

    public List<D> fromEntities(List<E> entities) {
        List<D> dtos = new ArrayList<>(entities.size());
        for (E entity : entities) {
            dtos.add(fromEntity(entity));
        }
        return dtos;
    }

    public List<E> toEntities(List<D> dtos) {
        List<E> entities = new ArrayList<>(dtos.size());
        for (D dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }

    public Class<D> getDtoClass() {
        return dtoClass;
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }
}
