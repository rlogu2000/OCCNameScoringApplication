package com.occ.name.scoring.strategy.impl;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.services.NameScoringService;
import com.occ.name.scoring.strategy.intf.NameScoringStrategy;

public class SimpleNameScoringStrategy implements NameScoringStrategy {

	private static final int CHAR_A=65;
	
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(NameScoringService.class.getName());
	
	@Override
    public long computeScore(Name name) {
	    long nameScore;
		log.entering("SimpleNameScoringStrategy", "NameScoringStrategy");
		AtomicLong score=new AtomicLong();
		name.getFirstName().chars().forEach(c->score.addAndGet(c-CHAR_A+1));
		Optional<String> lastName=Optional.ofNullable(name.getLastName());
    	if(lastName.isPresent())
    		lastName.get().chars().forEach(c->score.addAndGet(c-CHAR_A+1));
    	
    	nameScore=score.longValue()*name.getOrderNumber();
    	log.exiting("SimpleNameScoringStrategy", "NameScoringStrategy",nameScore);
		return nameScore;
	}

}
