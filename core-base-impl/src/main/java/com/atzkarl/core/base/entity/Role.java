package com.atzkarl.core.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import com.atzkarl.framework.base.entity.BaseEntity;
//import com.atzkarl.model.enumeration.RoleCode;

@Entity
@Table(name = "role")
public class Role extends BaseEntity implements GrantedAuthority {

    private static final long serialVersionUID = 1L;
    private String name;

    @Column(name = "name")
    // @Enumerated(EnumType.STRING)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    @Transient
    public String getAuthority() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return getAuthority() == null;
        }
        if (getAuthority() == null) {
            return false;
        }
        if (o instanceof GrantedAuthority) {
            GrantedAuthority ga = (GrantedAuthority) o;
            return (getAuthority().equals(ga.getAuthority()));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getAuthority().hashCode();
    }
}
