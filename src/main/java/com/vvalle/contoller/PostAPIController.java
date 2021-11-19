package com.vvalle.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vvalle.dto.PosterDataDTO;
import com.vvalle.dto.Response;
import com.vvalle.dto.Response.StatusEnum;
import com.vvalle.service.PosterService;

@RestController
@RequestMapping("/api/v1")
public class PostAPIController implements PosterApi {
	
	@Autowired
	PosterService posterService;

	@Override
	public ResponseEntity<Response> posterInventory(PosterDataDTO poster) {
		System.out.println("in controller"+poster);
		return new ResponseEntity<Response>(new Response("VVE10001", StatusEnum.SUCCESS, " you have succesfully posted", posterService.poster(poster)), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Response> searchposters() {
		return new ResponseEntity<Response>(new Response("VVE10002",StatusEnum.SUCCESS,"success",posterService.getPoster()),HttpStatus.OK);
	}

}
