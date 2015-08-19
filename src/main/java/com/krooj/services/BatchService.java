package com.krooj.services;

import java.util.Collection;

/**
 * Created by Michael on 8/18/15.
 */
public interface BatchService {

    /**
     * Takes the target filename to process, opens it,
     * reads  it's lines into a collection of strings,
     * then moves the file to a processed directory.
     * @param fileName
     * @return
     */
    String processInitialFile(String fileName);

}
