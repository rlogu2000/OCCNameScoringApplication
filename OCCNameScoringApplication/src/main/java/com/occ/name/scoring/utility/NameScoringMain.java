package com.occ.name.scoring.utility;

public class NameScoringMain {

	
private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(NameScoringMain.class.getName());
	
public static void main(String ...args) {
		
	   
	
	
		NameScoringCalculator nsc=new NameScoringCalculator();
		
		if(args.length<1) {
			log.info("Please Supply the Names file");
			System.exit(-1);
		}
		else if(args.length==1) {
			nsc.setFile(args[0]);
			nsc.setStrategyType("simple");
		}
		else if(args.length==2) {
			nsc.setFile(args[0]);
			nsc.setStrategyType(args[1]);
		}
		else {
			log.info("Invalid Input to the Program");
			log.info("Usage : java com.occ.name.scoring.utility.NameScoringCalculator <names.txt> <algorithm(optional)>");
			System.exit(-1);
		}
		
		log.info("File "+nsc.getFile());
		log.info("Strategy "+nsc.getStrategyType());
		
		nsc.computeScoreInSerialMode();
		nsc.computeScoreInParallelMode();
		nsc.computeScoreWithCompletableFuture();
		
	}
	
	
}
