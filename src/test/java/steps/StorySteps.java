package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pivotaltracker.entities.Context;
import pivotaltracker.ui.pages.story.StoryPage;

import java.util.Map;

public class StorySteps {
    public StoryPage storyPage;
    private Context context;

    @When("I go the (.*) Page of Pivotal Tracker")
    public void iVisitTheStoryPageOfPivotalTracker(final String page) {
    }

    @And("I create a story on Backlog with following characteristics")
    public void iCreateAStoryOnPanelWithFollowingCharacteristics(final Map<String, String> bodyFields) {
        String storyName = bodyFields.get("Story name");
        context = new Context();
        context.getStory().setStoryName(storyName);
        String storyType = bodyFields.get("Story Type");
        String storyEstimate = bodyFields.get("Points");
        String label = bodyFields.get("Labels");
        storyPage = new StoryPage();
        storyPage.createStory(storyName, storyType, storyEstimate, label);
    }

    @And("I finish and deliver the story")
    public void iFinishAndDeliverTheStory() {
        storyPage.finishStoryFlow(context.getStory().getStoryName());
    }

    @Then("I should see the story on Accepted Stories on Current Iteration panel")
    public void iShouldSeeTheStoryOnAcceptedStoriesOnCurrentIterationPanel() {
    }
}