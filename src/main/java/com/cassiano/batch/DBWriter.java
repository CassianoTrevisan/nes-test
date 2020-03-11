package com.cassiano.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> users) throws Exception {

        System.out.println("Data Saved for Users: " + users);
        //userRepository.save(users);3
    }
}
