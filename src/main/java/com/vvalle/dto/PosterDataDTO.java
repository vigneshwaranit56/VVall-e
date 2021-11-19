package com.vvalle.dto;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Validated

public class PosterDataDTO {

	@JsonProperty("id")
	private UUID id;

	@JsonProperty("message")
	private String message;

	@JsonProperty("created_at")
	private Timestamp createdAt;
	
	@JsonProperty("title")
	private String title;

	public PosterDataDTO() {
		super();
	}

	@JsonProperty("like")
	private Integer like = null;

	public PosterDataDTO id(UUID id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(example = "d290f1ee-6c54-4b01-90e6-d701748f0851", required = true, value = "")
	@NotNull

	@Valid

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public PosterDataDTO message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return message
	 **/
	@ApiModelProperty(example = "Widget Adapter", required = true, value = "")
	@NotNull

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PosterDataDTO releaseDate(Timestamp releaseDate) {
		this.createdAt = releaseDate;
		return this;
	}

	/**
	 * Get releaseDate
	 * 
	 * @return releaseDate
	 **/
	@ApiModelProperty(example = "2016-08-29T09:12:33.001Z", required = true, value = "")
	@NotNull

	@Valid

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp releaseDate) {
		this.createdAt = releaseDate;
	}

	public PosterDataDTO like(Integer like) {
		this.like = like;
		return this;
	}

	/**
	 * Get like
	 * 
	 * @return like
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PosterDataDTO posterData = (PosterDataDTO) o;
		return Objects.equals(this.id, posterData.id) && Objects.equals(this.message, posterData.message)
				&& Objects.equals(this.createdAt, posterData.createdAt) && Objects.equals(this.like, posterData.like);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, message, createdAt, like);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PosterData {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    releaseDate: ").append(toIndentedString(createdAt)).append("\n");
		sb.append("    like: ").append(toIndentedString(like)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
