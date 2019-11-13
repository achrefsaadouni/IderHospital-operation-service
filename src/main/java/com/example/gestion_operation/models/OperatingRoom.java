package com.example.gestion_operation.models;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class OperatingRoom implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6;

	private int id;
	private int number;
	@Enumerated(EnumType.STRING)
	private Status status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public OperatingRoom(int number) {
		super();
		this.number = number;
	}
	public OperatingRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
