package com.occ.name.scoring.impl;

import java.util.List;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.intf.ScoreComputer;
import com.occ.name.scoring.strategy.intf.NameScoringStrategy;

public class ComputeScoreWithParallelStream implements ScoreComputer {

	public ComputeScoreWithParallelStream() {
		
	}
	@Override
	public long computeTotalScore(List<Name> names,NameScoringStrategy nss) {
		return names.parallelStream().mapToLong(name->nss.computeScore(name)).sum();
	}
}
