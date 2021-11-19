package com.vvalle.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import com.vvalle.dto.PosterDataDTO;
import com.vvalle.dto.Response.StatusEnum;
import com.vvalle.entity.PosterData;
import com.vvalle.exceptionhandling.BusinessException;
import com.vvalle.repository.PosterRepository;

@Service
@Primary

public class PosterServiceImplementaion implements PosterService {

	@Autowired
	PosterRepository posRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PosterDataDTO poster(PosterDataDTO posterDataDTO) {
		try {
			System.out.println("before persist" + posterDataDTO);

			PosterData posterData = modelMapper.map(posterDataDTO, PosterData.class);

			System.out.println("after mapper " + posterData);

			posterDataDTO = modelMapper.map(posRepository.save(posterData), PosterDataDTO.class);
			


			System.out.println("after persist" + posterDataDTO);
		} catch(Exception e){
			throw new BusinessException("ERR00001", StatusEnum.FAILURE, "you request not processed succesfully",e.getMessage());
		}

		return posterDataDTO;
	}

	@Override
	public List<PosterDataDTO> getPoster() {
		ArrayList<PosterDataDTO> list = new ArrayList<PosterDataDTO>();

		try {
		Iterator<PosterData> itr = posRepository.findAll().iterator();
		while (itr.hasNext()) {
			list.add(modelMapper.map(itr.next(), PosterDataDTO.class));

		}

		System.out.println("size ::;" + list.size());
		} catch(Exception e){
			throw new BusinessException("ERR00002", StatusEnum.FAILURE, "you request not processed to get details",e.getMessage());
		}

		return list;
	}

}
