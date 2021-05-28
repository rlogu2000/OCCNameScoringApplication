/**
 * 
 */
package com.occ.name.scoring.io;

import java.util.logging.Logger;

/**
 * @author loganathan
 *
 */
public class InvalidFileException extends Exception {

	private static final Logger LOG = Logger.getLogger(InvalidFileException.class.getName());
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
