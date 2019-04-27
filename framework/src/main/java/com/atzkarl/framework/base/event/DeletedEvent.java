package com.atzkarl.framework.base.event;

import com.atzkarl.framework.base.dto.BaseDTO;

public class DeletedEvent<D extends BaseDTO> extends EntityAccessEvent {

    private static final long serialVersionUID = 1L;

    private final Long id;
    private D dto;
    private boolean deletionCompleted = true;

    public DeletedEvent(Long id, boolean entityFound, boolean deletionCompleted) {
        this.id = id;
        this.entityFound = entityFound;
        this.deletionCompleted = deletionCompleted;
    }

    public DeletedEvent(Long id, D dto) {
        this.id = id;
        this.dto = dto;
    }

    public Long getId() {
        return id;
    }

    public D getDTO() {
        return dto;
    }

    public boolean isDeletionCompleted() {
        return deletionCompleted;
    }
}
