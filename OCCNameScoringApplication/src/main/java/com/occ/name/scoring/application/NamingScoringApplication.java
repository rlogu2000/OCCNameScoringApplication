package com.occ.name.scoring.application;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
*
* @author LOGANATHAN
*/
@SpringBootApplication
@ComponentScan(basePackages = { "com.occ.name.scoring" })
public class NamingScoringApplication {

	/**
    *
    * @param args
    */
   public static void main(String[] args) {
		run(NamingScoringApplication.class, args);
	}
}
