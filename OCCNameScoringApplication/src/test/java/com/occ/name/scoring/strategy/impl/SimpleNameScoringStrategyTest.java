package com.occ.name.scoring.strategy.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.strategy.intf.NameScoringStrategy;

class SimpleNameScoringStrategyTest {

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
	@DisplayName("Passing null name should throw NullPointerException")
    public void testExceptionIsThrown() {
		NameScoringStrategy<Name,Long> tester = new SimpleNameScoringStrategy();
        assertThrows(NullPointerException.class,()->tester.computeScore(null));
    }
	@Test
	@DisplayName("Passing FirtName with ordernumber>0 should give correct result")
    public void testFirstNameOnly() {
		NameScoringStrategy<Name,Long>  tester = new SimpleNameScoringStrategy();
		Name name=new Name();
		name.setFirstName("AJAY");
		name.setOrderNumber(1);
		assertEquals(tester.computeScore(name),37L,"AJAY Score is 37");
    }
	@Test
	@DisplayName("Passing FirtName and LastName with ordernumber>0 should give correct result")
    public void testFirstAndLastName() {
		NameScoringStrategy<Name,Long>  tester = new SimpleNameScoringStrategy();
		Name name=new Name("AJAY","KUMAR");
		name.setOrderNumber(1);
		assertEquals(tester.computeScore(name), 101L,"AJAY Score is 101");
    }
	@Test
	@DisplayName("Passing FirtName and LastName with ordernumber=0 should give ZERO result")
    public void testOrderNumberZero() {
		NameScoringStrategy<Name,Long>  tester = new SimpleNameScoringStrategy();
		Name name=new Name("AJAY","KUMAR");
		name.setOrderNumber(0);
		assertEquals(tester.computeScore(name), 0L,"AJAY KUMAR with OrderNumber is 0");
    }

}
