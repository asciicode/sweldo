package com.atzkarl.framework.base.event;

import java.io.Serializable;

public abstract class EntityAccessEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    protected boolean entityFound = true;

    public boolean isEntityFound() {
        return entityFound;
    }
}