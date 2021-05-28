package com.occ.name.scoring.services;

import java.util.List;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.utility.NameScoringCalculator;
import com.occ.name.scoring.utility.NamesBuilder;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NameScoringService implements INameScoringService {

	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(NameScoringService.class.getName());
	public Long computeTotalScore(MultipartFile namesFile,String type) {
		Long sum=null;
		
		log.info(" Entering computeTotalScore Service Method");
		try {
            byte[] bytes = namesFile.getBytes();
            NamesBuilder nb=new NamesBuilder();
            List<Name> names=nb.loadAndBuildNames(bytes);
            NameScoringCalculator nsc=new NameScoringCalculator();
            nsc.setStrategyType(type);
            sum=nsc.computeScoreInParallelMode(names);
    		
        } catch (Exception e) {
            e.printStackTrace();
        }
		log.info(" Exiting computeTotalScore Service Method with Sum :"+sum);
		return sum;
	}
}
