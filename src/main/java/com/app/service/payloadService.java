package com.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.payload;

@Service
public interface payloadService {
	public payloadResponse createPayload( payload loads);

}
