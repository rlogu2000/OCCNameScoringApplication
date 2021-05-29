package com.occ.name.scoring.io;

public class SystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SystemException() {
	}

    /**
     *
     * @param string
     */
    public SystemException(String message) {
		super(message);
	}

    /**
     *
     * @param string
     * @param thrwbl
     */
    public SystemException(String message, Throwable cause) {
		super(message, cause);
	}
}
