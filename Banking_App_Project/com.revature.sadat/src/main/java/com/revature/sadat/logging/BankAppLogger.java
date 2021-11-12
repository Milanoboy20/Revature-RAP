package com.revature.sadat.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.*;

public class BankAppLogger {
	
	private static Logger log = LogManager.getLogger(BankAppLogger.class);

	public static void main(String[] args) {
		logMethod();

	}
		
	
	public static void logMethod() {
		log.trace("TRACE LOG!");
		log.debug("DEBUG LOG!");
		log.info("INFO LOG!");
		log.warn("WARN LOG!");
		log.error("ERROR LOG!");
		log.fatal("FATAL LOG!");
	}
	
	public static Logger getLogger() {
		return log;
	}

}
