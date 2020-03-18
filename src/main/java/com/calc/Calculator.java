package com.calc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Calculator")
public class Calculator {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String inputVal;
	private int outVal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInputVal() {
		return inputVal;
	}

	public void setInputVal(String inputVal) {
		this.inputVal = inputVal;
	}

	public int getOutVal() {
		return outVal;
	}

	public void setOutVal(int outVal) {
		this.outVal = outVal;
	}

}
