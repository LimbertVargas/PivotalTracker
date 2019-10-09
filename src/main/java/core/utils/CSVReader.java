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

import core.selenium.webDrivers.Chrome;
import core.selenium.webDrivers.Firefox;
import core.selenium.webDrivers.IDriver;
import org.apache.commons.lang3.ArrayUtils;

/**
 * CSVReader class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class CSVReader {
    private static String Title = "title";

    /**
     * Gets all story names.
     *
     * @param file - CSV file name.
     * @return Name story array
     */
    public String[] getNamesStory(final String file, final Integer field) {
        String csvFile = System.getProperty("user.dir") + "/" + "src/test/resources/files/" + file;
        BufferedReader bufferedReader = null;
        String line = "";
        String cvsSplitBy = ",";
        int linenumber = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while (bufferedReader.readLine() != null) {
                linenumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String storyData[] = new String[linenumber];
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

    public Integer getAttribute(final String field) {
        Map<String, Integer> strategyBrowser = new HashMap<>();
        strategyBrowser.put(Title, 1);
        return strategyBrowser.get(field);
    }

    public String[] getAttribute(final String file, final String attribute) {
        return getNamesStory(file, getAttribute(attribute));
    }
}
