package com.codingeye.tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeMasterApplication {
	public static void main(String[] args) {
		SpringApplication.run(TimeMasterApplication.class, args);
	}
}

/*public class TimeMasterApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TimeMasterApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TimeMasterApplication.class, args);
	}
}*/
