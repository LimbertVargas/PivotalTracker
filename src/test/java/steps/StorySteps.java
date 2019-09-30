package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pivotaltracker.ui.pages.StoryPage;

import java.util.Map;

public class StorySteps {
    public StoryPage storyPage;

    @When("I go the (.*) Page of Pivotal Tracker")
    public void iVisitTheStoryPageOfPivotalTracker(final String page) {
        System.out.println(page);
    }

    @And("I create a story on (.*) with following characteristics")
    public void iCreateAStoryOnPanelWithFollowingCharacteristics(final String page, final Map<String, String> bodyFields) {
        String storyName = bodyFields.get("Story name");
        storyPage = new StoryPage();
        storyPage.separateCurrentBacklog();
        storyPage.createBacklogStory(storyName);
    }

    @And("I finish and deliver the story")
    public void iFinishAndDeliverTheStory() {
        System.out.println("a");
    }

    @Then("I should see the story on Accepted Stories on Current Iteration panel")
    public void iShouldSeeTheStoryOnAcceptedStoriesOnCurrentIterationPanel() {
        System.out.println("asdf");
    }
}
