package com.occ.name.scoring.intf;



public interface ScoreComputer<T,U> {

	public Long computeTotalScore(T names,U nss);
	
}
