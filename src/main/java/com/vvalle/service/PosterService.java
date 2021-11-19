package com.vvalle.service;

import java.util.List;

import com.vvalle.dto.PosterDataDTO;

public interface PosterService {
	
	public PosterDataDTO poster(PosterDataDTO posterDataDTO);

	public List<PosterDataDTO> getPoster();

}
