package com.occ.name.scoring.services;

import org.springframework.web.multipart.MultipartFile;

import com.occ.name.scoring.io.InvalidFileException;
import com.occ.name.scoring.io.SystemException;

public interface INameScoringService {
	
	public Long computeTotalScore(MultipartFile namesFile,String type) throws InvalidFileException,SystemException;
	

}
