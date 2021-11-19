package com.vvalle.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "poster_data", indexes = { @Index(name = "poster_data_id_IX", columnList = "id", unique = true) })
public class PosterData {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Column(name = "message")
	private String message;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "likes")
	private Integer like;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public PosterData(UUID id, String message,String title) {
		super();
		this.id = id;
		this.message = message;
		this.like = 0;
		this.title = title;
		this.createdAt = new Timestamp(System.currentTimeMillis());
		this.isDelete = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PosterData() {
		this.isDelete = false;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PosterData other = (PosterData) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PosterData [id=" + id + ", message=" + message + ", title=" + title + ", createdAt=" + createdAt
				+ ", like=" + like + ", isDelete=" + isDelete + "]";
	}

	
	
	

}
