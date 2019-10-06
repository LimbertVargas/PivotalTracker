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
    private String storyType;
    private String name;
    private int projectId;


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
     * @param kind - Kind.
     */
    public void setKind(final String kind) {
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
     * @param estimate - Points estimate.
     */
    public void setEstimate(final int estimate) {
        this.estimate = estimate;
    }

    /**
     * Gets story type
     *
     * @return storyType
     */
    public String getStoryType() {
        return storyType;
    }

    /**
     * Sets story type.
     *
     * @param storyType - Story type.
     */
    public void setStoryType(final String storyType) {
        this.storyType = storyType;
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
     * @param name - Story name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets project id.
     *
     * @return projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * Sets project id.
     *
     * @param projectId = Project id.
     */
    public void setProjectId(final int projectId) {
        this.projectId = projectId;
    }
}
