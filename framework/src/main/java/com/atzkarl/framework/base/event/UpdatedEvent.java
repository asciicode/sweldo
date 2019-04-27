package com.atzkarl.framework.base.event;

import com.atzkarl.framework.base.dto.BaseDTO;

public class UpdatedEvent<D extends BaseDTO> extends EntityAccessEvent {

    private static final long serialVersionUID = 1L;

    private final Long id;
    private D dto;
    private boolean updateCompleted = true;

    public UpdatedEvent(Long id, boolean entityFound, boolean updateCompleted) {
        this.id = id;
        this.entityFound = entityFound;
        this.updateCompleted = updateCompleted;
    }

    public UpdatedEvent(Long id, D dto) {
        this.id = id;
        this.dto = dto;
    }

    public Long getId() {
        return id;
    }

    public D getDTO() {
        return dto;
    }

    public boolean isUpdateCompleted() {
        return updateCompleted;
    }
}
