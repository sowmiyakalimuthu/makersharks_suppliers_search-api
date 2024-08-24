package com.example.searchApi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.searchApi.SupplierData;
import com.example.searchApi.service.ManageService;

@RestController
@RequestMapping("/api/supplier")
public class ManageController {
	
	@Autowired
	private ManageService mService;
	
	@PostMapping("/query")
	public ResponseEntity <Map<String, Object>> getSuppliers( @RequestBody SupplierData supplierData) {
		Map <String, Object> response = new HashMap<>();

		try {
			response.put("data", mService.findSuppliers(
					supplierData.getLocation(),
					supplierData.getNatureOfBusiness(),
					supplierData.getManufacturingProcesses(),
					supplierData.getPage(),
					supplierData.getSize() ));
			response.put("status", HttpStatus.OK);
			return new ResponseEntity <Map<String, Object>> (response,HttpStatus.OK);
		} catch (Exception e) {
			response.put("status", HttpStatus.BAD_REQUEST);
			response.put("message", e.getMessage());
			return new ResponseEntity <Map<String, Object>> (response,HttpStatus.BAD_REQUEST);
		}
}
}
