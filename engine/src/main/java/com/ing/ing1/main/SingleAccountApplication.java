package com.ing.ing1.main;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.net.ssl.HttpsURLConnection;

/**
 * Main starting point of Single Quote Engine
 *
 * @author Georgios Gkekas
 */
@SpringBootApplication()
@ComponentScan(basePackages={"com.ing.ing1"})
public class SingleAccountApplication  {

	private static final Logger LOGGER = LogManager.getLogger(SingleAccountApplication.class);

	static {
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
	}

	public static void main(String args[]) {
		SpringApplication.run(SingleAccountApplication.class);
		LOGGER.info("Started main server thread");
	}
}
