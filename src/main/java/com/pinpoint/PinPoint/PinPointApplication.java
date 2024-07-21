package com.pinpoint.PinPoint;

import com.pinpoint.PinPoint.entity.Locality;
import com.pinpoint.PinPoint.services.PincodeService;
import lombok.Synchronized;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootApplication
@EnableAsync
@Log
public class PinPointApplication {
    final private PincodeService pincodeService;
    int start = 1;

    public PinPointApplication(PincodeService pincodeService) {
        this.pincodeService = pincodeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PinPointApplication.class, args);
        System.out.println("Application Running......");
    }

    @Bean
//    @Synchronized
    public CommandLineRunner commandLineRunner() throws Exception {
//        long start_time = System.currentTimeMillis();
//        Integer totalRows = pincodeService.getTotalRows() - start;
//
//        System.out.println(Thread.currentThread().getName());
//        Integer step = 10000; // 10K
//        while (totalRows != 0) {
//            if (totalRows > step) {
//                CompletableFuture<List<Locality>> output = pincodeService.printLocalities(start, start + step);
//                List<Locality> result = output.get();
//                System.out.println(result.get(result.size() - 1));
//
//                start += step;
//                totalRows -= step;
//            } else {
//                Integer endRowNumber = start + (step - (step - totalRows));
//
//                CompletableFuture<List<Locality>> output = pincodeService.printLocalities(start, endRowNumber);
//                List<Locality> result = output.get();
//
//                totalRows -= (step - (step - totalRows));
//
//                start += (step - (step - totalRows));
//
//            }
//
//        }
//        long end_time = System.currentTimeMillis();
//        long totalT = end_time - start_time;
//
//
//        log.info("complete task of interating 40k rows took - " + totalT + " /ms");
//
        return args -> {
        };
    }

}
