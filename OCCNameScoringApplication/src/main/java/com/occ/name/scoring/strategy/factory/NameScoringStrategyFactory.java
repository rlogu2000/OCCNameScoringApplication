package com.occ.name.scoring.strategy.factory;

import com.occ.name.scoring.strategy.impl.ComplexNameScoringStrategy;
import com.occ.name.scoring.strategy.impl.SimpleNameScoringStrategy;
import com.occ.name.scoring.strategy.intf.NameScoringStrategy;

public class NameScoringStrategyFactory {

	public static NameScoringStrategy getNameScoringStrategy(String type) {

		if (type == null) {
            return null;
       }
        switch (type) {
            case "simple":
                return new SimpleNameScoringStrategy();
            case "complex":
                return new ComplexNameScoringStrategy();
        }
        throw new IllegalArgumentException("Invalid Alogorithm Type Supplied : "+type);
    }

}
