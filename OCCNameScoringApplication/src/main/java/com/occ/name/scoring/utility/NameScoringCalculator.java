package com.occ.name.scoring.utility;


import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import java.util.logging.Level;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.impl.ComputeScoreWithCompletableFuture;
import com.occ.name.scoring.impl.ComputeScoreWithParallelStream;
import com.occ.name.scoring.impl.ComputeScoreWithStream;
import com.occ.name.scoring.intf.ScoreComputer;
import com.occ.name.scoring.io.InvalidFileException;
import com.occ.name.scoring.strategy.factory.NameScoringStrategyFactory;
import com.occ.name.scoring.strategy.intf.NameScoringStrategy;


public class NameScoringCalculator {
	
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(NameScoringCalculator.class.getName());

	private String file;
	private String strategyType;
	private NameScoringStrategy algorithm;
	
	private NameScoringStrategy  getAlgorithm() {
		return algorithm;
	}
	private void setAlgorithm(NameScoringStrategy algorithm) {
		this.algorithm=algorithm;
	}
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getStrategyType() {
		return strategyType;
	}
	public void setStrategyType(String strategyType) {
		this.strategyType = strategyType;
		try {
			setAlgorithm(NameScoringStrategyFactory.getNameScoringStrategy(getStrategyType()));
		}catch(IllegalArgumentException ex) {
			log.log(Level.SEVERE, ex.getMessage());
			Terminator.terminate(ex.getMessage(), -1);
		}
	}
	
	public long computeScoreInSerialMode() {
		Instant startTime = Instant.now();
		List<Name> names=buildNames(getFile());
		
		ScoreComputer sc=new ComputeScoreWithStream();
		long sum =sc.computeTotalScore(names, getAlgorithm());
		
		Instant endTime = Instant.now();
		printDuration("Simple Stream",names.size(),sum,startTime, endTime);
		return sum;
	}
	
	public long computeScoreInParallelMode() {
		Instant startTime = Instant.now();
		List<Name> names=buildNames(getFile());
		ScoreComputer sc=new ComputeScoreWithParallelStream();
		long sum =sc.computeTotalScore(names, getAlgorithm());
		Instant endTime = Instant.now();
		printDuration("Parallel Stream",names.size(),sum,startTime, endTime);
		return sum;
	}
	public long computeScoreInParallelMode(List<Name> withNames) {
				
		Instant startTime = Instant.now();
		List<Name> names=(withNames!=null)?withNames:buildNames(getFile());
		ScoreComputer sc=new ComputeScoreWithParallelStream();
		long sum =sc.computeTotalScore(names, getAlgorithm());
		Instant endTime = Instant.now();
		printDuration("Parallel Stream",names.size(),sum,startTime, endTime);
		return sum;
	}
	public long computeScoreWithCompletableFuture() {
		Instant startTime = Instant.now();
		List<Name> names=buildNames(getFile());
		ScoreComputer sc=new ComputeScoreWithCompletableFuture();
		long sum =sc.computeTotalScore(names, getAlgorithm());
		Instant endTime = Instant.now();
		printDuration("CompletableFuture",names.size(),sum,startTime, endTime);
		return sum;
	}
	private List<Name> buildNames(String file){
		try {
			NamesBuilder nb=new NamesBuilder();
			return nb.loadAndBuildNames(file);
		}catch(IOException | InvalidFileException ex) {
			log.log(Level.SEVERE, ex.getMessage());
			Terminator.terminate(ex.getMessage(), -1);
		}
		catch(Exception ex) {
			log.log(Level.SEVERE, ex.getMessage());
			Terminator.terminate(ex.getMessage(), -1);
		}
		return null;
	}
	private static void printDuration(String type,int size,long sum,Instant start, Instant end) {
		Duration timeElapsed = Duration.between(start, end);
		log.log(Level.INFO,"Type : "+type+", Processed "+size+" Names in "+timeElapsed.toMillis()+" MilliSeconds and the sum is "+sum+"\n");
	}
	
	

	

}
