package com.occ.name.scoring.services;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.io.InvalidFileException;
import com.occ.name.scoring.io.SystemException;
import com.occ.name.scoring.utility.NameScoringCalculator;
import com.occ.name.scoring.utility.NamesBuilder;

@Service
public class NameScoringService implements INameScoringService {

	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(NameScoringService.class.getName());
	public Long computeTotalScore(MultipartFile namesFile,String type) throws InvalidFileException,SystemException {
		Long sum=null;
		
		log.info(" Entering computeTotalScore Service Method");
		try {
            byte[] bytes = namesFile.getBytes();
            NamesBuilder nb=new NamesBuilder();
            List<Name> names=nb.loadAndBuildNames(bytes);
            NameScoringCalculator nsc=new NameScoringCalculator();
            nsc.setStrategyType(type);
            sum=nsc.computeScoreInParallelMode(names);
    		
        }catch (IOException e) {
        	//e.printStackTrace();
            log.log(Level.SEVERE,e.getMessage());
            throw new SystemException(e.getMessage());
        }
		catch (InvalidFileException e) {
        	//e.printStackTrace();
            log.log(Level.SEVERE,e.getMessage());
            throw e;
        }
		catch (Exception e) {
        	//e.printStackTrace();
            log.log(Level.SEVERE,e.getMessage());
            throw new SystemException(e.getMessage());
        }
		log.info(" Exiting computeTotalScore Service Method with Sum :"+sum);
		return sum;
	}
}
