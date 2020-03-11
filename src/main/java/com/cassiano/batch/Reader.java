package com.cassiano.batch;

import com.cassiano.model.AnomalyConfig;
import com.cassiano.services.ConfigLoaderService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Reader implements ItemReader<List<AnomalyConfig>> {

    @Autowired
    private ConfigLoaderService configLoaderService;

    private boolean batchJobState = false;

    @Override
    public List<AnomalyConfig> read() {
        if (!batchJobState) {
            batchJobState = true;
            return configLoaderService.loadConfigFileToRepo();
        }
        return null;
    }

}
