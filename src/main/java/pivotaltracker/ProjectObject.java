/*
 * @(#) ProjectObject.java Copyright (c) 2019 Jala Foundation.
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
 * ProjectObject class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ProjectObject {
    private static int idProject;
    private int storyPoints;
    private String projectName;

    public ProjectObject(){
        idProject = 0;
    }

    /**
     * Gets id project.
     *
     * @return idProject
     */
    public static int getIdProject() {
        return idProject;
    }

    /**
     * Sets id project.
     *
     * @param idProject
     */
    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    /**
     * Gets story points.
     *
     * @return storyPoints
     */
    public int getStoryPoints() {
        return storyPoints;
    }

    /**
     * Sets story points.
     *
     * @param storyPoints
     */
    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    /**
     * Gets project name.
     *
     * @return projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets project name.
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
