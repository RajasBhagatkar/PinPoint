package com.pinpoint.PinPoint.services;

import com.pinpoint.PinPoint.entity.Locality;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PincodeService {
    boolean insertPincodeService();
    String testService();

    CompletableFuture<List<Locality>> printLocalities(int start, int end) throws Exception;
    Integer getTotalRows() throws IOException;
}
