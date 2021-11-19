package com.vvalle.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vvalle.entity.PosterData;


@Repository
public interface PosterRepository extends CrudRepository<PosterData, UUID> {

	
	
}
