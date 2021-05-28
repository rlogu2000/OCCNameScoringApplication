package com.occ.name.scoring.intf;

import java.util.List;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.strategy.intf.NameScoringStrategy;

public interface ScoreComputer {
	
	
	public long computeTotalScore(List<Name> names,NameScoringStrategy nss);

}
