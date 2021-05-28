package com.occ.name.scoring.utility;

import static java.lang.System.exit;

public class Terminator {
		
	private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(Terminator.class.getName());
    /**
     *
     * @param message
     * @param status
     */
    public static void terminate(final String message, final int status) {
		//LOG.log(Level.SEVERE, message);
		exit(status);
	}

    /**
     *
     */
    public static void yes() {
		terminate("yes", 0);
	}

    /**
     *
     */
    public static void no() {
		terminate("no", 0);
	}
    
}
