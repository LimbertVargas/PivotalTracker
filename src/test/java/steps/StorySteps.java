package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pivotaltracker.ui.pages.story.StoryPage;

import java.util.Map;

public class StorySteps {
    public StoryPage storyPage;

    @When("I go the (.*) Page of Pivotal Tracker")
    public void iVisitTheStoryPageOfPivotalTracker(final String page) {
    }

    @And("I create a story on Backlog with following characteristics")
    public void iCreateAStoryOnPanelWithFollowingCharacteristics(final Map<String, String> bodyFields) {
        String storyName = bodyFields.get("Story name");
        System.out.printf("00000000000");
        storyPage = new StoryPage();
        System.out.printf("1111111111");
        storyPage.separateCurrentBacklog();
        System.out.printf("2222222222");
        storyPage.createBacklogStory(storyName);
    }

    @And("I finish and deliver the story")
    public void iFinishAndDeliverTheStory() {

    }

    @Then("I should see the story on Accepted Stories on Current Iteration panel")
    public void iShouldSeeTheStoryOnAcceptedStoriesOnCurrentIterationPanel() {
        System.out.println("asdf");
    }
}
