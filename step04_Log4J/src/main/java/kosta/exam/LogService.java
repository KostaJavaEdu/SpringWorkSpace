package kosta.exam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogService {
	Log log = LogFactory.getLog(this.getClass());
	
	public void loggingTest() {
		//기능
		
		//로그기록
		log.trace("trace에 관련된 메시지 입니다.");
		log.debug("debug에 관련된 메시지 입니다.");
		log.info("info에 관련된 메시지 입니다.");
		log.warn("warn에 관련된 메시지 입니다.");
		log.error("error에 관련된 메시지 입니다.");
		log.fatal("fatal에 관련된 메시지 입니다.");
	}
}
