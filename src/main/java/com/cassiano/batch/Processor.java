package com.cassiano.batch;

import com.cassiano.model.AnomalyConfig;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Processor implements ItemProcessor<List<AnomalyConfig>, String> {


    @Override
    public String process(List<AnomalyConfig> anomalyConfigs) throws Exception {
      //  for (AnomalyConfig anomalyConfig : anomalyConfigs){
            System.out.println(anomalyConfigs.toString());
      //  }
        return "null";
    }
}
