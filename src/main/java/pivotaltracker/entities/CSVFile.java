/*
 * @(#) CSVFile.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.entities;

/**
 * CSVFile class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class CSVFile {
    private String fileName;
    private String[] id;
    private String[] titlesStory;
    private String[] labels;

    /**
     * Gets file name.
     *
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets file name.
     *
     * @param fileName - File Name
     */
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets title story.
     *
     * @return titleStory
     */
    public String[] getTitlesStory() {
        return titlesStory;
    }

    /**
     * Sets title story.
     *
     * @param titlesStory - Sets title story
     */
    public void setTitlesStory(final String[] titlesStory) {
        this.titlesStory = titlesStory;
    }

    /**
     * Gets label.
     *
     * @return labels - Story label
     */
    public String[] getLabels() {
        return labels;
    }

    /**
     * Sets label.
     *
     * @param labels - Sets labels
     */
    public void setLabels(final String[] labels) {
        this.labels = labels;
    }

    /**
     * Gets id.
     *
     * @return id - Story ids
     */
    public String[] getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id - CSV story id
     */
    public void setId(final String[] id) {
        this.id = id;
    }
}
