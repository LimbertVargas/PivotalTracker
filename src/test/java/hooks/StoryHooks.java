/*
 * @(#) StoryHooks.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package hooks;

import cucumber.api.java.Before;
import pivotaltracker.api.StoryAPI;

/**
 * StoryHooks class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class StoryHooks {
    private StoryAPI storyAPI;

    /**
     * This method create a project through API.
     */
    @Before(value = "@CreateStoryAPI", order = 1)
    public void postStory() {
        storyAPI = new StoryAPI();
        storyAPI.postStories();
    }
}
