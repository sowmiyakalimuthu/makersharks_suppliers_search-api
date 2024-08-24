package com.example.searchApi;

public class SupplierData {
	private String location;
    private String natureOfBusiness;
    private String manufacturingProcesses;
    private int page=0;
    private int size=10;
	public String getLocation() {
		return location;
	}
	public String getNatureOfBusiness() {
		return natureOfBusiness;
	}
	public String getManufacturingProcesses() {
		return manufacturingProcesses;
	}
	public int getPage() {
		return page;
	}
	public int getSize() {
		return size;
	}
}
