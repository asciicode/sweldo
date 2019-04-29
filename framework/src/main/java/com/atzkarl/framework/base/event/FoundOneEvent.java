package com.atzkarl.framework.base.event;

import com.atzkarl.framework.base.dto.BaseDTO;

public class FoundOneEvent<D extends BaseDTO> extends EntityAccessEvent {

    private static final long serialVersionUID = 1L;

    private final Long id;
    private D dto;

    public FoundOneEvent(Long id, boolean entityFound) {
        this.id = id;
        this.entityFound = entityFound;
    }

    public FoundOneEvent(Long id, D dto) {
        this.id = id;
        this.dto = dto;
    }

    public Long getId() {
        return id;
    }

    public D getDTO() {
        return dto;
    }

}
