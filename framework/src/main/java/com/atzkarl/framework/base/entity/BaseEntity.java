package com.atzkarl.framework.base.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String createdBy;

	private Date createdDateTime;

	private String lastModifiedBy;

	private Date lastModifiedDateTime;

	private int version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@CreatedBy
	@Column(name = "created_by")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	@Transient
	public Date getCreatedDate() {
		return null == createdDateTime ? null : createdDateTime;
	}

	@Transient
	public void setCreatedDate(final Date createdDate) {
		this.createdDateTime = null == createdDate ? null : createdDate;
	}

	@CreatedDate
	@Column(name = "created_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(final Date createdDate) {
		this.createdDateTime = createdDate;
	}

	@LastModifiedBy
	@Column(name = "last_modified_by")
	public String getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	public void setLastModifiedBy(final String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Transient
	public Date getLastModifiedDate() {
		return null == lastModifiedDateTime ? null : lastModifiedDateTime;
	}

	@Transient
	public void setLastModifiedDate(final Date lastModifiedDate) {
		this.lastModifiedDateTime = null == lastModifiedDate ? null : lastModifiedDate;
	}

	@LastModifiedDate
	@Column(name = "last_modified_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(final Date lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;

	}

	@Transient
	public String getLastModifiedDateString() {
		// return DateUtil.format(lastModifiedDateTime, Format.DATETIME);
		return null;
	}

	@Version
	@Column(name = "version")
	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}
}
