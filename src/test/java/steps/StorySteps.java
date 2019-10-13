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
import pivotaltracker.entities.Context;
import pivotaltracker.entities.Story;
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

    @Then("I should see the story on backlog panel")
    public void iShouldSeeTheStoryOnBacklogPanel() {
//        String actual = storyPage.getStoryStateText(story.getStoryName());
//        String expected = "StartReject";
//        Assert.assertEquals(actual, expected);
    }

    @When("I start the story")
    public void iStartTheStory() {
        storyPage.continueFlowClick(story.getStoryName());
    }

    @Then("I should see that the story can be finished")
    public void iShouldSeeThatTheStoryCanBeFinished() {
        String actual = storyPage.getStoryStateText(story.getStoryName());
        String expected = "Finish";
        Assert.assertEquals(actual, expected);
    }

    @When("I finish the story")
    public void iFinishTheStory() {
        storyPage.continueFlowClick(story.getStoryName());
    }

    @Then("I should see that the story can be deliver")
    public void iShouldSeeThatTheStoryCanBeDeliver() {
        String actual = storyPage.getStoryStateText(story.getStoryName());
        String expected = "Deliver";
        Assert.assertEquals(actual, expected);
    }

    @When("I deliver the story")
    public void iDeliverTheStory() {
        storyPage.continueFlowClick(story.getStoryName());
    }

    @Then("I should see that the story can be accept o reject")
    public void iShouldSeeThatTheStoryCanBeAcceptOReject() {
        String actual = storyPage.getStoryStateText(story.getStoryName());
        String expected = "Reject";
        Assert.assertEquals(actual, expected);
    }


    @When("I accept the sory")
    public void iAcceptTheSory() {
        storyPage.acceptStory(story.getStoryName());
    }

    /**
     * Asserts the data of the story.
     */
    @Then("I should see the story was Accepted")
    public void iShouldSeeTheStoryWasAccepted() {
        storyPage.dualClick();
        String actual = storyPage.getStoryStateText();
        String expected = "Accepted";
        Assert.assertEquals(actual, expected);
        storyPage.clickCloseStory();
    }
}
