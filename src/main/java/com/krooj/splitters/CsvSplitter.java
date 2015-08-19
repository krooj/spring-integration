package com.krooj.splitters;

import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael on 8/18/15.
 */
@Component
public class CsvSplitter {

    @Splitter
    public List<String> split(String input){
        return new ArrayList<>(Arrays.asList(input.split("\n")));
    }

}
