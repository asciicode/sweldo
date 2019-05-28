package com.atzkarl.core.base.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.atzkarl.framework.base.entity.AuditableEntity;

@Audited
@Entity
@Table(name = "payroll")
public class Payroll extends AuditableEntity {

	private static final long serialVersionUID = 1L;

}
