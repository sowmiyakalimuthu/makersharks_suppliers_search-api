package com.example.searchApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="suppliers")
public class ManageModel {
	
	@Column(name = "supplier_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "nature_of_business")
	private String natureOfBusiness ;
	
	@Column(name = "manufacturing_processes")
	private String manufacturingProcesses ;

	public int getSupplierId() {
		return supplierId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getWebsite() {
		return website;
	}

	public String getLocation() {
		return location;
	}

	public String getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public String getManufacturingProcesses() {
		return manufacturingProcesses;
	}

}
