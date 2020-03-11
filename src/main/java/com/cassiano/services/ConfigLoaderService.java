package com.cassiano.services;

import com.cassiano.model.AnomalyConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class ConfigLoaderService {

    @Value("${anomaly.file.path}")
    private String configFilePath;

    public List<AnomalyConfig> loadConfigFileToRepo() {

        List<AnomalyConfig> anomalyConfigsList = new ArrayList<>();

        try (JsonReader jsonReader = new JsonReader(
                new InputStreamReader(
                        new FileInputStream(configFilePath), StandardCharsets.UTF_8))) {

            Gson gson = new GsonBuilder().create();

            jsonReader.beginArray(); //start of json array

            while (jsonReader.hasNext()) { //next json array element
                anomalyConfigsList.add(gson.fromJson(jsonReader, AnomalyConfig.class));
               // anomalyConfigRepo.addAnomaly(anomalyConfig);
            }

            jsonReader.endArray();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return anomalyConfigsList;
    }
}
