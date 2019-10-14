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
import pivotaltracker.ui.pages.story.ImportProjectPage;
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
    private ImportProjectPage importProjectPage;

    /**
     * Constructor class.
     *
     * @param context
     */
    public StorySteps(Context context) {
        this.context = context;
        story = context.getStory();
        importProjectPage = new ImportProjectPage();
    }

    /**
     * Steps for create story.
     *
     * @param bodyFields
     */
    @And("I create a story on Backlog with following characteristics")
    public void createAStoryOnPanelWithFollowingCharacteristics(final Map<String, String> bodyFields) {
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
     * Assert that the story exists in the backlog.
     */
    @Then("I should see the story on backlog panel")
    public void shouldSeeTheStoryOnBacklogPanel() {
        Assert.assertEquals(context.getStory().getStoryName(), importProjectPage.getTitleList()[0]);
    }

    /**
     * Start the story.
     */
    @When("I start the story")
    public void startTheStory() {
        storyPage.continueFlowClick(story.getStoryName());
    }

    /**
     * Asserts that the story is started.
     */
    @Then("I should see that the story can be finished")
    public void shouldSeeThatTheStoryCanBeFinished() {
        String actual = storyPage.getStoryStateText(story.getStoryName());
        String expected = "Finish";
        Assert.assertEquals(actual, expected);
    }

    /**
     * Finish the story.
     */
    @When("I finish the story")
    public void finishTheStory() {
        storyPage.continueFlowClick(story.getStoryName());
    }

    /**
     * Asserts that the story finished.
     */
    @Then("I should see that the story can be deliver")
    public void shouldSeeThatTheStoryCanBeDeliver() {
        String actual = storyPage.getStoryStateText(story.getStoryName());
        String expected = "Deliver";
        Assert.assertEquals(actual, expected);
    }

    /**
     * Deliver the story.
     */
    @When("I deliver the story")
    public void deliverTheStory() {
        storyPage.continueFlowClick(story.getStoryName());
    }

    /**
     * Asserts that the story was delivered.
     */
    @Then("I should see that the story can be accept o reject")
    public void shouldSeeThatTheStoryCanBeAcceptOReject() {
        String actual = storyPage.getStoryStateText(story.getStoryName());
        String expected = "Reject";
        Assert.assertEquals(actual, expected);
    }

    /**
     * Accepts the story.
     */
    @When("I accept the sory")
    public void acceptTheSory() {
        storyPage.acceptStory(story.getStoryName());
    }

    /**
     * Asserts the data of the story.
     */
    @Then("I should see the story was Accepted")
    public void shouldSeeTheStoryWasAccepted() {
        storyPage.dualClick();
        String actual = storyPage.getStoryStateText();
        String expected = "Accepted";
        Assert.assertEquals(actual, expected);
        storyPage.clickCloseStory();
    }
}
