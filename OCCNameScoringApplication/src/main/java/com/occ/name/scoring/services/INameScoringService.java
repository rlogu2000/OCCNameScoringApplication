package com.occ.name.scoring.services;

import org.springframework.web.multipart.MultipartFile;

public interface INameScoringService {
	
	public Long computeTotalScore(MultipartFile namesFile,String type);
	

}
