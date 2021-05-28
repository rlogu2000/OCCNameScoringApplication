package com.occ.name.scoring.strategy.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.occ.name.scoring.entity.Name;

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
		SimpleNameScoringStrategy tester = new SimpleNameScoringStrategy();
        assertThrows(NullPointerException.class,()->tester.computeScore(null));
    }
	@Test
	@DisplayName("Passing FirtName with ordernumber>0 should give correct result")
    public void testFirstNameOnly() {
		SimpleNameScoringStrategy tester = new SimpleNameScoringStrategy();
		Name name=new Name();
		name.setFirstName("AJAY");
		name.setOrderNumber(1);
		assertEquals("AJAY Score is 37",tester.computeScore(name),37L);
    }
	@Test
	@DisplayName("Passing FirtName and LastName with ordernumber>0 should give correct result")
    public void testFirstAndLastName() {
		SimpleNameScoringStrategy tester = new SimpleNameScoringStrategy();
		Name name=new Name("AJAY","KUMAR");
		name.setOrderNumber(1);
		assertEquals("AJAY Score is 101",tester.computeScore(name), 101L);
    }
	@Test
	@DisplayName("Passing FirtName and LastName with ordernumber=0 should give ZERO result")
    public void testOrderNumberZero() {
		SimpleNameScoringStrategy tester = new SimpleNameScoringStrategy();
		Name name=new Name("AJAY","KUMAR");
		name.setOrderNumber(0);
		assertEquals("AJAY KUMAR with OrderNumber Score is 0",tester.computeScore(name), 0L);
    }

}
