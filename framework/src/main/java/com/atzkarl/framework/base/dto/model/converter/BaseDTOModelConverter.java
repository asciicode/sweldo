package com.atzkarl.framework.base.dto.model.converter;

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
import com.atzkarl.framework.base.rest.model.BaseModel;
//import com.atzkarl.framework.base.spring.data.Revision;

public abstract class BaseDTOModelConverter<D extends BaseDTO, M extends BaseModel> {

    @Autowired
    private Mapper mapper;

    private Class<D> dtoClass;

    private Class<M> modelClass;

    @SuppressWarnings("unchecked")
    public BaseDTOModelConverter() {
        Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(
                getClass(), BaseDTOModelConverter.class);
        for (TypeVariable<?> typeParameter : BaseDTOModelConverter.class
                .getTypeParameters()) {
            Class<?> clazz = TypeUtils.getRawType(
                    typeArguments.get(typeParameter), null);
            switch (typeParameter.getName()) {
            case "D":
                dtoClass = (Class<D>) clazz;
                break;
            case "M":
                modelClass = (Class<M>) clazz;
                break;
            default:
                throw new IllegalStateException("Unknown type parameter: "
                        + typeParameter.getName());
            }
        }
    }

    public D fromModel(M model) {
        return mapper.map(model, dtoClass);
    }

    public M toModel(D dto) {
        return mapper.map(dto, modelClass);
    }

    public List<D> fromModels(List<M> models) {
        List<D> dtos = new ArrayList<>(models.size());
        for (M model : models) {
            dtos.add(fromModel(model));
        }
        return dtos;
    }

    public Page<D> fromModels(Page<M> modelPage) {
        List<D> dtos = new ArrayList<>(modelPage.getSize());
        for (M model : modelPage) {
            dtos.add(fromModel(model));
        }
		return new PageImpl<>(dtos, PageRequest.of(modelPage.getNumber(),
                modelPage.getSize(), modelPage.getSort()),
                modelPage.getTotalElements());
    }

    public List<M> toModels(List<D> dtos) {
        List<M> models = new ArrayList<>(dtos.size());
        for (D dto : dtos) {
            models.add(toModel(dto));
        }
        return models;
    }

    public Page<M> toModels(Page<D> dtoPage) {
        List<M> models = new ArrayList<>(dtoPage.getSize());
        for (D dto : dtoPage) {
            models.add(toModel(dto));
        }
		return new PageImpl<>(models, PageRequest.of(dtoPage.getNumber(),
                dtoPage.getSize(), dtoPage.getSort()),
                dtoPage.getTotalElements());
    }

//    public List<Revision<Long, M>> toRevisionModels(
//            List<Revision<Long, D>> revisionDTOs) {
//        List<Revision<Long, M>> revisionModels = new ArrayList<>(
//                revisionDTOs.size());
//        for (Revision<Long, D> revisionDTO : revisionDTOs) {
//            revisionModels.add(new Revision<Long, M>(revisionDTO.getMetadata(),
//                    toModel(revisionDTO.getEntity())));
//        }
//        return revisionModels;
//    }

    public Class<D> getDtoClass() {
        return dtoClass;
    }

    public Class<M> getModelClass() {
        return modelClass;
    }
}
