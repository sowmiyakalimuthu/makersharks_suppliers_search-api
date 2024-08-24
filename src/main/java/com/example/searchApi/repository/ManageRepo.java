package com.example.searchApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.searchApi.model.ManageModel;

@Repository
public interface ManageRepo extends JpaRepository <ManageModel, Integer>{
	
	//oracle db
	@Query (value="select * from(\r\n"
			+ "select suppliers.*, rownum as rn from suppliers \r\n"
			+ "where rownum <=:end_param and\r\n"
			+ "(:location IS NULL OR suppliers.location = :location) \r\n"
			+ "AND (:natureOfBusiness IS NULL OR suppliers.nature_Of_Business = :natureOfBusiness) \r\n"
			+ "AND (:manufacturingProcesses IS NULL OR suppliers.manufacturing_Processes = :manufacturingProcesses)\r\n"
			+ ") where rn>=:start_param",
			nativeQuery = true)
	List<ManageModel> filterByInput(@Param ("location") String location, 
			@Param ("natureOfBusiness") String natureOfBusiness,
			@Param ("manufacturingProcesses") String manufacturingProcesses,
			@Param("start_param") int start_param,
            @Param("end_param") int end_param);
	
	
}
