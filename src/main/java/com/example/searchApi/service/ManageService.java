package com.example.searchApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.searchApi.model.ManageModel;
import com.example.searchApi.repository.ManageRepo;

@Service
public class ManageService {

	@Autowired
	private ManageRepo mRepo;
	
	public enum NatureOfBusiness{
		small_scale, medium_scale, large_scale
	};
	
	
	public Page<ManageModel> findSuppliers(String location, String natureOfBusiness, String manufacturingProcesses, int page, int size) throws Exception{
		PageRequest pageable = PageRequest.of(page, size);
			int start = page * size + 1;
			int end = start + size - 1;
	    
		if(location == null || location.trim().isEmpty() || natureOfBusiness == null || natureOfBusiness.trim().isEmpty() || manufacturingProcesses == null || manufacturingProcesses.trim().isEmpty()) {
			throw new IllegalArgumentException("Location/ Nature of Business/ Manufacturing Processes  must not be empty or blank");
		}
		
		try {
			NatureOfBusiness.valueOf(natureOfBusiness);
		} catch(Exception e) {
			throw new Exception ("We dont have suppliers for "+ natureOfBusiness+". Choose from available: small_scale, medium_scale, large_scale");
		}
		
		if(!manufacturingProcesses.equals("moulding") && !manufacturingProcesses.equals("3d_printing") && !manufacturingProcesses.equals("casting") && !manufacturingProcesses.equals("coating") ) {
			throw new Exception ("We dont have suppliers for "+ manufacturingProcesses+". Choose from available: moulding, 3d_printing, casting, coating");
		}
		
		List<ManageModel> suppliersList =  mRepo.filterByInput(location, natureOfBusiness, manufacturingProcesses, start, end);
		if(suppliersList.isEmpty()) {
			throw new Exception ("No suppliers found");
		} else {
			return new PageImpl<>(suppliersList, pageable, suppliersList.size());
		}
    }
}
