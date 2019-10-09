/*
 * @(#) CSVReader.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package core.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

/**
 * CSVReader class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class CSVReader {
    private static String TITLE = "title";
    private static String LABELS = "labels";
    private static String STORY_TYPE = "storyType";
    private static String ID = "storyType";
    private static String ESTIMATE = "storyType";

    /**
     * Gets all story names.
     *
     * @param file - CSV file name.
     * @return Name story array
     */
    public String[] getAttributeCSV(final String file, final Integer field) {
        String csvFile = System.getProperty("user.dir") + "/" + "src/test/resources/files/" + file;
        BufferedReader bufferedReader = null;
        String line = "";
        String cvsSplitBy = ",";
        int lineNumber = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while (bufferedReader.readLine() != null) {
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String storyData[] = new String[lineNumber];
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            for (int j = 0; j < storyData.length; j++) {
                line = bufferedReader.readLine();
                String[] storyField = line.split(cvsSplitBy);
                storyData[j] = storyField[field];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        storyData = ArrayUtils.remove(storyData, 0);
        return storyData;
    }

    public Integer getAttributeStory(final String field) {
        Map<String, Integer> strategyFileReader = new HashMap<>();
        strategyFileReader.put(ID, 0);
        strategyFileReader.put(TITLE, 1);
        strategyFileReader.put(LABELS, 2);
        strategyFileReader.put(STORY_TYPE, 6);
        strategyFileReader.put(ESTIMATE, 7);
        return strategyFileReader.get(field);
    }

    public String[] getAttributeStory(final String file, final String attribute) {
        return getAttributeCSV(file, getAttributeStory(attribute));
    }
}
