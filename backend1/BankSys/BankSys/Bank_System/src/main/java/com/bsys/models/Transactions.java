package com.bsys.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity



public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int transid;

	private int transamt;
	
	private String rname;

	public int getTransid() {
		return transid;
	}

	public void setTransid(int transid) {
		this.transid = transid;
	}

	public int getTransamt() {
		return transamt;
	}

	public void setTransamt(int transamt) {
		this.transamt = transamt;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	


	

}