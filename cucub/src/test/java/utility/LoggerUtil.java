package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {
	
	public static Logger getLogger(String classAndMethodName) {
		Logger log=Logger.getLogger(classAndMethodName);
		PropertyConfigurator.configure("log4j.properties");
		log.debug("testing");
		return log;
	}

}
