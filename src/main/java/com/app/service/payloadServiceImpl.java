package com.app.service;

import java.util.List;

import com.app.entity.payload;
import com.app.repository.payloadrepository;

public class payloadServiceImpl implements payloadService {
	
	private payloadrepository payloadrepositoryObj;

	@Override
	public payloadResponse createPayload(payload loads) {
		payloadrepositoryObj.save(loads);
		return payloadResponse.LOADS_DETAILS_ADDED_SUCCESSFULLY ;
	}

	public List<payload> getLoadById(int loadId) {
		return payloadrepositoryObj.findOne(loadId);
		
	
	}

}
