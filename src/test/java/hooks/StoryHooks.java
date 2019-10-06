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