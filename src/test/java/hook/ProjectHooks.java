/*
 * @(#) ProjectHooks.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package hook;

import cucumber.api.java.Before;
import pivotaltracker.api.ProjectAPI;
import pivotaltracker.ui.pages.workspace.DashboardWorkspacePage;

/**
 * ProjectHooks class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ProjectHooks {
    private DashboardWorkspacePage dashboardPage;
    private ProjectAPI projectAPI;

    /**
     * This method create a project through UI.
     */
//    @Before("@CreateProject")
//    public void createProject() {
//        dashboardPage = new DashboardPage();
//        dashboardPage.createProject("Project01");
//    }

    /**
     * This method create a project through API.
     */
    @Before("@CreateProjectAPI")
    public void postProject() {
        projectAPI = new ProjectAPI();
        projectAPI.postProject();
    }
}
