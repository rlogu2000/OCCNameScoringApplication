package com.occ.name.scoring.impl;

import java.util.List;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.intf.ScoreComputer;
import com.occ.name.scoring.strategy.intf.NameScoringStrategy;

public class ComputeScoreWithStream implements ScoreComputer {

	public ComputeScoreWithStream() {
		
	}
	@Override
	public long computeTotalScore(List<Name> names,NameScoringStrategy nss) {
		return names.stream().mapToLong(name->nss.computeScore(name)).sum();
	}

}
