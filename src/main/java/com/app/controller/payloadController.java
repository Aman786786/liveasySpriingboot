package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.payload;
import com.app.repository.payloadrepository;
import com.app.service.payloadResponse;
import com.app.service.payloadServiceImpl;

@RestController
public class payloadController {

	@Autowired
	private payloadServiceImpl payloadService;
	private payloadrepository payloadrepositoryObj;

	@PostMapping("/load")
	public payloadResponse createPayload(@RequestBody payload loads) {

		return payloadService.createPayload(loads);

	}
	
	

	@RequestMapping(value = "/{loadId}", method = RequestMethod.GET)
	public List<payload> getLoad(@PathVariable("loadId") int loadId)

	{
		return this.payloadService.getLoadById(loadId);
	}
	
	

	@PutMapping("/load/{loadId}")

	public payload updatePayloadById(@PathVariable int loadId, @RequestBody payload loads) {
		payload getPay = payloadrepositoryObj.getById(loadId);
		getPay.setLoadingPoint(loads.getLoadingPoint());
		getPay.setUnloadingPoint(loads.getLoadingPoint());
		getPay.setProductType(loads.getProductType());
		getPay.setTruckType(loads.getTruckType());
		getPay.setNoOfTrucks(loads.getNoOfTrucks());
		getPay.setWeight(loads.getWeight());
		getPay.setShipperId(loads.getShipperId());
		getPay.setDate(loads.getDate());

		payload updatedPayload = payloadrepositoryObj.save(getPay);

		return updatedPayload;

	}
	
	
	@DeleteMapping("/load/{loadId}")
	public List<payload> deletePayloadById(@PathVariable int loadId) {
		List<payload> newPayload = payloadrepositoryObj.findAll().stream().filter(payloadId 
				-> payloadId.getLoadId() != loadId ).collect(Collectors.toList());
		
		
		return newPayload;
		
		
	}
	
}
