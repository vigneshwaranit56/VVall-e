package com.vvalle.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Response {
	@JsonProperty("code")
	protected String code;

	/**
	 * Response status `success` or `error`
	 */
	public enum StatusEnum {
		SUCCESS("success"), FAILURE("failure"), ERROR("error");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("status")
	private StatusEnum status = null;

	@JsonProperty("message")
	private String message = null;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	

	@JsonProperty("description")
	private String description;

	@JsonProperty("data")
	private Object data = null;

	public Response code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return code
	 **/
	@NotNull

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Response status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Response status `success` or `error`
	 * 
	 * @return status
	 **/
	@NotNull

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Response message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Human readable error message
	 * 
	 * @return message
	 **/
	@NotNull

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response timestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
	}

	public Response data(Object data) {
		this.data = data;
		return this;
	}

	/**
	 * Result body
	 * 
	 * @return data
	 **/

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Response other = (Response) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (status != other.status)
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Response(String code, StatusEnum status, String message, String description) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.description = description;
		this.timestamp =  LocalDateTime.now();
	}

	public Response(String code, StatusEnum status, String message, Object data) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.data = data;
		this.timestamp =  LocalDateTime.now();

	}

}
