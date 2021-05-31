package com.occ.name.scoring.io;

import static com.occ.name.scoring.utility.ErrorMessages.FILE_IS_EMPTY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

class FileLoaderTest {

	String file=null;
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
	public void testCheckFileIsEmpty() {
		try {
			FileLoader fileLoader = new FileLoader();
			String file="OCC_Take_Home_Coding_names4.txt";
			Resource resource = new ClassPathResource(file);
			fileLoader.checkFile(resource.getFile());
		} catch (Exception ex) {
			//ex.printStackTrace();
			final String msg = FILE_IS_EMPTY.toString();
			assertEquals(msg, ex.getMessage());
		}
	}

    /**
     *
     */
    @Test
	public void testCheckFileIsNotFound() {
		try {
			FileLoader fileLoader = new FileLoader();
			String file="OCC_Take_Home_Coding_names10.txt";
			Resource resource = new ClassPathResource(file);
			fileLoader.checkFile(resource.getFile());
		} catch (Exception ex) {
			//ex.printStackTrace();
			assertEquals("class path resource [OCC_Take_Home_Coding_names10.txt] cannot be resolved to URL because it does not exist", ex.getMessage());
		}
	}
	

}
