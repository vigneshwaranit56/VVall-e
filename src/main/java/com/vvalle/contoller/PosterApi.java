package com.vvalle.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vvalle.dto.PosterDataDTO;
import com.vvalle.dto.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-10-04T08:00:05.727Z")

@Validated
@Api(value = "users")
@RequestMapping(value = "/vigneshwaran-tringapps/ecommerce-backend-application/1.0.0")
public interface PosterApi {

	
	 @ApiOperation(value = "adds an poster item", nickname = "posterInventory", notes = "Adds an item to the system", tags={ "posters", })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 201, message = "item created"),
	        @ApiResponse(code = 400, message = "invalid input, object invalid"),
	        @ApiResponse(code = 409, message = "an existing item already exists") })
	    @RequestMapping(value = "/posters",
	        produces = { "application/json" }, 
	        consumes = { "application/json" },
	        method = RequestMethod.POST)
	   ResponseEntity<Response> posterInventory(@ApiParam(value = "poster item to add"  ) @Valid @RequestBody PosterDataDTO poster);


	    @ApiOperation(value = "searches posters", nickname = "searchposters", notes = "you can search for  available posters in the system ", response = PosterDataDTO.class, responseContainer = "List", tags={ "posters", })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "search results matching criteria", response = PosterDataDTO.class, responseContainer = "List"),
	        @ApiResponse(code = 400, message = "bad input parameter") })
	    @RequestMapping(value = "/posters",
	        produces = { "application/json" }, 
	        method = RequestMethod.GET)
	    ResponseEntity<Response> searchposters();
}
