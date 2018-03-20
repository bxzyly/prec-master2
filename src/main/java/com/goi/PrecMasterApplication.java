package com.goi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class PrecMasterApplication extends SpringBootServletInitializer {

	public static void main(String[] args){
		SpringApplication.run(PrecMasterApplication.class, args);
	}

//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(PrecMasterApplication.class);
//    }
}
