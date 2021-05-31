/**
 * 
 */
package com.occ.name.scoring.utility;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.occ.name.scoring.entity.Name;
import com.occ.name.scoring.io.InvalidFileException;

/**
 * @author LOGANATHAN
 *
 */
class NamesBuilderTest {

	NamesBuilder nb=null;
	List<Name> expected=null;
	String file=null;
	Resource resource=null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**	
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		nb=new NamesBuilder();
		expected = Arrays.asList(new Name("BARBARA",null,1),
                new Name("HAI",null,2),
                new Name("JERE",null,3),
	            new Name("LINDA",null,4),
			    new Name("LYNWOOD",null,5),
			    new Name("MARY",null,6),
			    new Name("PATRICIA",null,7),
			    new Name("SHON",null,8),
			    new Name("VINCENZO",null,9));
		file="OCC_Take_Home_Coding_names2.txt";
		resource = new ClassPathResource(file);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.occ.name.scoring.utility.NamesBuilder#loadAndBuildNames(java.lang.String)}.
	 */
	@Test
	final void testLoadAndBuildNamesWithInvalidFile() {
	
		assertThrows(InvalidFileException.class,()->nb.loadAndBuildNames("test"));
	}

	/**
	 * Test method for {@link com.occ.name.scoring.utility.NamesBuilder#loadAndBuildNames(byte[])}.
	 */
	@Test
	final void testLoadAndBuildNamesWithNullByteArray() {
	
		byte b[]=null;
		assertThrows(NullPointerException.class,()->nb.loadAndBuildNames(b));
	}
	@Test
	final void testLoadAndBuildNamesWithValidFile()throws Exception {
		assertThat(nb.loadAndBuildNames(file), is(expected));
		
	}	
	/**
	 * Test method for {@link com.occ.name.scoring.utility.NamesBuilder#loadAndBuildNames(byte[])}.
	 */
	@Test
	final void testLoadAndBuildNamesWithValidByteArray()throws Exception {
		byte[] b = Files.readAllBytes(Paths.get(file));
		assertThat(nb.loadAndBuildNames(b), is(expected));
	}
}
