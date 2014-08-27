package raine;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class TestSlf4J {
	private static final Logger logger = LoggerFactory.getLogger(TestSlf4J.class);  
	
	
	public void test(){
		System.out.println(TestSlf4J.class + "=========");
	}
    public static void main(String[] args) {   
    	logger.error("Hello {}","SLF4J");
    	logger.warn("Hello {}","SLF4J");
    	logger.info("Hello {}","SLF4J");   
        logger.debug("Hello {}","SLF4J");  
    } 
}
