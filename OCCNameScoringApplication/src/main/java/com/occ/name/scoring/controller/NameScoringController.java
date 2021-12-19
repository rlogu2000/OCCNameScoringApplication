package com.occ.name.scoring.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.occ.name.scoring.io.InvalidFileException;
import com.occ.name.scoring.io.SystemException;
import com.occ.name.scoring.services.INameScoringService;
import com.occ.name.scoring.utility.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
*
* @author LOGANATHAN
*/
@CrossOrigin(origins = "http://localhost:8090")
@RestController
@Api(value = "computeScore", description = "The REST Api will be used to compute score of uploaded names file and Response with TotalSum")
public class NameScoringController {
		
	@Autowired
	INameScoringService service;
    /**
     *
     * @param namesFile
     * @param type (Algorithm Type)
     * @return score
     */
   	@RequestMapping(value = "/names/score", method = POST, produces = APPLICATION_JSON_VALUE)
	@ApiOperation(value = "compute score of uploaded names file", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully computed  the Result"),
							@ApiResponse(code = 400, message = "Bad Request,Either file formate is not correct or it is corrupted"),
							@ApiResponse(code = 500, message = "Internal Server Error,Service has some processsing issues")
							 })
   	
	public ResponseEntity<String> computeScore(@RequestParam("namesFile") MultipartFile namesFile,
			                                   @RequestParam("algorithmType") String type) throws InvalidFileException,SystemException {
   		
   		Long sum=null;
   		try {
			sum=service.computeTotalScore(namesFile, type);
			String result=new Result(sum).toString();
			return new ResponseEntity<String>(result, HttpStatus.OK);
   		}catch(InvalidFileException ex){
   			ex.printStackTrace();
   			throw ex;
   		}catch(SystemException ex){
   			ex.printStackTrace();
   			throw ex;
   			
   		}
       
	}
}
