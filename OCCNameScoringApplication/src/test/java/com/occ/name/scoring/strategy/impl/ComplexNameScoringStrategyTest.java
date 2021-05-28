package com.occ.name.scoring.strategy.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.occ.name.scoring.entity.Name;

class ComplexNameScoringStrategyTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("ComplexNameScoringStrategy does not have implementation ,So it should throw UnSupportedOperationException")
    public void testExceptionIsThrown() {
		ComplexNameScoringStrategy tester = new ComplexNameScoringStrategy();
		Name name=new Name("AJAY","KUMAR");
		name.setOrderNumber(1);
        assertThrows(UnsupportedOperationException.class,()->tester.computeScore(name));
    }

}
