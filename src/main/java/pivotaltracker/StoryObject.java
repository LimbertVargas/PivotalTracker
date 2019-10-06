/*
 * @(#) StoryObject.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker;

/**
 * StoryObject class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class StoryObject {
    private String kind;
    private int id;
    private int estimate;
    private String story_type;
    private String name;
    private int project_id;


    /**
     * Gets id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets kind.
     *
     * @return kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets kind.
     *
     * @param kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Gets estimate.
     *
     * @return estimate
     */
    public int getEstimate() {
        return estimate;
    }

    /**
     * Sets estimate.
     *
     * @param estimate
     */
    public void setEstimate(int estimate) {
        this.estimate = estimate;
    }

    /**
     * Gets story type
     *
     * @return storyType
     */
    public String getStory_type() {
        return story_type;
    }

    /**
     * Sets story type.
     *
     * @param story_type
     */
    public void setStory_type(String story_type) {
        this.story_type = story_type;
    }

    /**
     * Gets story name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets story name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets project id.
     *
     * @return projectId
     */
    public int getProject_id() {
        return project_id;
    }

    /**
     * Sets project id.
     *
     * @param project_id
     */
    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}