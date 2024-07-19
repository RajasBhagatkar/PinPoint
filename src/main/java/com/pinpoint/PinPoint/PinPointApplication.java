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
	@Async
	public void processData(String data) throws ExecutionException, InterruptedException {
//		CompletableFuture<?> resp = fetchData();
//		System.out.println(resp.get());
	}

	@Async
	public CompletableFuture<?> fetchData() {
		// Perform some asynchronous operation

		// this performs the thread just put wrapper around the thread execution so that you will get the more options over thread execution
		CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {
			try{
				Thread.sleep(5000);
				return "hello";
			}catch (InterruptedException e){
				e.printStackTrace();
				return "error occured";
			}
		});

		CompletableFuture<String> greetingFuture = CompletableFuture.supplyAsync(() -> {
			try{
				Thread.sleep(5000);
				return "world";
			}catch (InterruptedException e){
				e.printStackTrace();
				return "error occured";
			}
		});

//		return CompletableFuture.completedFuture("data");
//		CompletableFuture<Void> allFutuers = CompletableFuture.allOf(helloFuture, greetingFuture);
		return helloFuture;
	}

}
