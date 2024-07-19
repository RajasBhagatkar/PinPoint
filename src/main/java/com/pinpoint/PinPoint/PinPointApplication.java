package com.pinpoint.PinPoint;

import com.pinpoint.PinPoint.services.PincodeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@EnableAsync
public class PinPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinPointApplication.class, args);
		System.out.println("Application Running......");
	}

	@Bean
	public CommandLineRunner commandLineRunner(PincodeService pincodeService) {
		return args -> {
			System.out.println("running command line runner");
		};
	}

}
