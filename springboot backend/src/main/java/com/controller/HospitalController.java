package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.beans.HospitalBeans;
import com.repository.HospitalRepository;

@RestController
@RequestMapping("/info")
@CrossOrigin(origins = "http://localhost:4200")
public class HospitalController {
	
	@Autowired
	private HospitalRepository repository;
	
	@GetMapping("/hospital")
	public List<HospitalBeans> getAllemp()
	{
		return repository.findAll();
	}
	@PostMapping("/hospital")
    public HospitalBeans createHospital(@Valid @RequestBody HospitalBeans hospital) {
        return repository.save(hospital);
    }
	@DeleteMapping("/hospital/{id}")
    public Map<String, Boolean> deleteHospital(@PathVariable(value = "id") Long hospitalId)
         throws ResourceNotFoundException {
		HospitalBeans hospital = repository.findById(hospitalId)
       .orElseThrow(() -> new ResourceNotFoundException("Delete cannot be done!Employee not found for this id :: " + hospitalId));

        repository.delete(hospital);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	@GetMapping("/hospital/{id}")
    public ResponseEntity<HospitalBeans> getEmployeeById(@PathVariable(value = "id") Long hospitalId)
     throws ResourceNotFoundException //User defined Exception
    {
		HospitalBeans hospital = repository.findById(hospitalId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + hospitalId));
        return ResponseEntity.ok().body(hospital);
    }
	@PutMapping("/hospital/{id}")
    public ResponseEntity<HospitalBeans> updateEmployee(@PathVariable(value = "id") Long hospitalId,
         @Valid @RequestBody HospitalBeans hospitalDetails) throws ResourceNotFoundException {
		HospitalBeans hospital = repository.findById(hospitalId)
        .orElseThrow(() -> new ResourceNotFoundException("Update cannot be done!Employee not found for this id :: " + hospitalId));

        
		hospital.setName(hospitalDetails.getName());
		hospital.setAppointmentdate(hospitalDetails.getAppointmentdate());
		hospital.setSpeciality(hospitalDetails.getSpeciality());
		hospital.setConsultant(hospitalDetails.getConsultant());
		hospital.setSlot(hospitalDetails.getSlot());
		hospital.setStatus(hospitalDetails.getStatus());
		
        final HospitalBeans updatedHospital = repository.save(hospital);
        return ResponseEntity.ok(updatedHospital);
    }
	

}
