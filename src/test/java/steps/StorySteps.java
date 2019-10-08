/*
 * @(#) StorySteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pivotaltracker.PageTransporter;
import pivotaltracker.ProjectObject;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.Story;
import pivotaltracker.ui.Permalink;
import pivotaltracker.ui.pages.story.StoryPage;

import java.util.Map;

/**
 * StorySteps class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class StorySteps {
    public StoryPage storyPage;
    private Context context;
    private Story story;

    /**
     * Constructor class.
     *
     * @param context
     */
    public StorySteps(Context context) {
        this.context = context;
        story = context.getStory();
    }

    @When("I go to the Story page")
    public void iGoToTheStoryPage() {
        PageTransporter.navigatePageThroughId(Permalink.PROJECT_STORY_PAGE, ProjectObject.getIdProject());
    }

    /**
     * Steps for create story.
     *
     * @param bodyFields
     */
    @And("I create a story on Backlog with following characteristics")
    public void iCreateAStoryOnPanelWithFollowingCharacteristics(final Map<String, String> bodyFields) {
        String storyName = bodyFields.get("Story name");
        String storyType = bodyFields.get("Story Type");
        String storyEstimate = bodyFields.get("Points");
        String label = bodyFields.get("Labels");
        context.getStory().setEstimate(Integer.parseInt(storyEstimate));
        context.getStory().setStoryName(storyName);
        context.getStory().setStoryType(storyType);
        context.getStory().setLabel(label);
        storyPage = new StoryPage();
        storyPage.createStory(storyName, storyType, storyEstimate, label);
    }

    /**
     * This step complete the story flow.
     */
    @And("I finish and deliver the story")
    public void iFinishAndDeliverTheStory() {
        storyPage.finishStoryFlow(story.getStoryName());
    }

    /**
     * Asserts the data of the story.
     */
    @Then("I should see the story on Accepted Stories on Current Iteration panel")
    public void iShouldSeeTheStoryOnAcceptedStoriesOnCurrentIterationPanel() {
        Assert.assertEquals(storyPage.getStoryTitleTxt(), context.getStory().getStoryName());
        Assert.assertEquals(storyPage.getLabelTxt(), context.getStory().getLabel());
        storyPage.waitToLoad();
    }
}
