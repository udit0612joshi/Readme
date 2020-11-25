package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Topics {
   @Id
	private int id;
	private String name;
	private String descreption;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	
}
