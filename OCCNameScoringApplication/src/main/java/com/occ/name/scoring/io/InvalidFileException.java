/**
 * 
 */
package com.occ.name.scoring.io;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author loganathan
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFileException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public InvalidFileException() {
	}

    /**
     *
     * @param string
     */
    public InvalidFileException(String message) {
		super(message);
	}

    /**
     *
     * @param string
     * @param thrwbl
     */
    public InvalidFileException(String message, Throwable cause) {
		super(message, cause);
	}
   

}
