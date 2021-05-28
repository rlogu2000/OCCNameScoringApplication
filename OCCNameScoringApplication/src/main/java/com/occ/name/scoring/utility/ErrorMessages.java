package com.occ.name.scoring.utility;

/**
 * Contain Error message.
 */
public enum ErrorMessages {

    /**
     *
     */
    FILE_NOT_FOUND("Input file is not found."), 

    /**
     *
     */
    FILE_IS_EMPTY("Input file is empty!"),
	
	
	
	FILE_IS_MALFORMED("File Content is not correct");
	
	
	private final String errorMsg;

	private ErrorMessages(String msg) {
		this.errorMsg = msg;
	}

    /**
     *
     * @return
     */
    public String value() {
		return this.errorMsg;
	}
}
