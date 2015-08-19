package com.krooj.services;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by Michael on 8/18/15.
 */
@Service
public class BatchServiceImpl implements BatchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchServiceImpl.class);

    @Override
    public String processInitialFile(String fileName) {
        File inputFile = new File(fileName);
        try {
            String contents = FileUtils.readFileToString(inputFile);
            FileUtils.moveFileToDirectory(inputFile, new File("/tmp/processed"), true);
            return contents;
        } catch (IOException e) {
            LOGGER.warn("op=processInitialFile fileName={}", fileName, e);
            try {
                FileUtils.moveFileToDirectory(inputFile, new File("/tmp/failed"), true);
            } catch (IOException e1) {
                LOGGER.error("op=processInitialFile fileName={} Failed to move bad file.", fileName, e1);
            }
        }
        return null;
    }
}
