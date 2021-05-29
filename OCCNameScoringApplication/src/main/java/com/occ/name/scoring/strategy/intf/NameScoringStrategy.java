package com.occ.name.scoring.strategy.intf;


public interface NameScoringStrategy<T,U> {
	
	
	public U computeScore(T name);

}
