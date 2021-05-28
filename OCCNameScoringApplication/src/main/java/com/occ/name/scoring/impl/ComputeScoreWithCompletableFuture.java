package com.occ.name.scoring.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.intf.ScoreComputer;
import com.occ.name.scoring.strategy.intf.NameScoringStrategy;

public class ComputeScoreWithCompletableFuture implements ScoreComputer{
	
	private static final int NUM_OF_THREADS = 10;

	public ComputeScoreWithCompletableFuture() {
		
	}
	
	@Override
	public long computeTotalScore(List<Name> names,NameScoringStrategy nss) {
		
		ExecutorService executor = Executors.newFixedThreadPool(Math.min(names.size(), NUM_OF_THREADS));
		
		List<CompletableFuture<Long>> futures= names.stream().map(name->CompletableFuture.supplyAsync(()-> nss.computeScore(name),executor)).collect(Collectors.toList());
		long sum=futures.stream().mapToLong(CompletableFuture::join).sum();
		executor.shutdown();
		return sum;
	}

}
