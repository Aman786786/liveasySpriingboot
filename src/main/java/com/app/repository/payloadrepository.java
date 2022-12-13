package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.payload;


@Repository
public interface payloadrepository extends JpaRepository<payload, Integer>{

	List<payload> findOne(int loadId);

	

}
