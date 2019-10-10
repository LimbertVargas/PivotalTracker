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
    private static final String TITLE = "title";
    private static final String LABELS = "labels";
    private static final String STORY_TYPE = "storyType";
    private static final String ID = "id";
    private static final String ESTIMATE = "estimate";
    private String csvFile;

    /**
     * Gets all story names.
     *
     * @param file  - CSV file name.
     * @param field - CSV attribute field.
     * @return Name story array
     */
    private String[] getAttributeCSV(final String file, final Integer field) {
        csvFile = getCsvPath(file);
        int lineNumber = getLinesNumber();
        String[] storyData = getAttributeList(lineNumber, field);
        storyData = ArrayUtils.remove(storyData, 0);
        return storyData;
    }

    /**
     * Gets attribute story.
     *
     * @param attribute - Story attribute position
     * @return specific attribute.
     */
    private Integer getAttributeStory(final String attribute) {
        Map<String, Integer> mapFileReader = new HashMap<>();
        final int storyTypePosition = 6;
        final int storyTypeEstimate = 7;
        mapFileReader.put(ID, 0);
        mapFileReader.put(TITLE, 1);
        mapFileReader.put(LABELS, 2);
        mapFileReader.put(STORY_TYPE, storyTypePosition);
        mapFileReader.put(ESTIMATE, storyTypeEstimate);
        return mapFileReader.get(attribute);
    }

    /**
     * Gets attribute sotry.
     *
     * @param file      - File name
     * @param attribute - Specific attribute
     * @return attribute[]
     */
    public String[] getAttributeStory(final String file, final String attribute) {
        return getAttributeCSV(file, getAttributeStory(attribute));
    }

    /**
     * Gets lines Number.
     *
     * @return linesNumber
     */
    private int getLinesNumber() {
        int lineNumber = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
            while (bufferedReader.readLine() != null) {
                lineNumber++;
            }
        } catch (IOException e) {
            Log.getInstance().getLog().error(e.getMessage());
            throw new RuntimeException(e);
        }
        return lineNumber;
    }

    /**
     * Gets attribute list.
     *
     * @param lineNumber - CSV Lines Number
     * @param position   - Position
     * @return storyData[]
     */
    private String[] getAttributeList(final int lineNumber, final Integer position) {
        String cvsSplitBy = ",";
        String line = "";
        String[] storyData = new String[lineNumber];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
        ) {
            for (int j = 0; j < storyData.length; j++) {
                line = bufferedReader.readLine();
                String[] storyField = line.split(cvsSplitBy);
                storyData[j] = storyField[position];
            }
        } catch (FileNotFoundException e) {
            Log.getInstance().getLog().error(e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return storyData;
    }

    /**
     * Gets csv path.
     *
     * @param file - File name
     * @return File path
     */
    private String getCsvPath(final String file) {
        return System.getProperty("user.dir") + "/" + "src/test/resources/files/" + file;
    }
}
