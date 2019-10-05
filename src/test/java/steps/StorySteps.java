package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pivotaltracker.PageTransporter;
import pivotaltracker.ProjectObject;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.Story;
import pivotaltracker.ui.pages.story.StoryPage;

import java.util.Map;

public class StorySteps {
    public StoryPage storyPage;
    private Context context;
    private Story story;
    private ProjectObject projectObject;

    public StorySteps(Context context) {
        this.context = context;
        story = context.getStory();
        projectObject = new ProjectObject();
    }

    @And("I create a story on Backlog with following characteristics")
    public void iCreateAStoryOnPanelWithFollowingCharacteristics(final Map<String, String> bodyFields) {
        String endpoint = "/n/projects";
        System.out.println(((projectObject.getIdProject()) + " ####@#@#@##@$%!#@$%@$#^%"));
        PageTransporter.navigatePageThroughId(endpoint, projectObject.getIdProject());
        String storyName = bodyFields.get("Story name");
        context = new Context();
        story.setStoryName(storyName);
        String storyType = bodyFields.get("Story Type");
        String storyEstimate = bodyFields.get("Points");
        String label = bodyFields.get("Labels");
        storyPage = new StoryPage();
        storyPage.createStory(storyName, storyType, storyEstimate, label);
    }

    @And("I finish and deliver the story")
    public void iFinishAndDeliverTheStory() {
        //    storyPage.finishStoryFlow(story.getStoryName());
    }

    @Then("I should see the story on Accepted Stories on Current Iteration panel")
    public void iShouldSeeTheStoryOnAcceptedStoriesOnCurrentIterationPanel() {
//        String actual = "";
//        String expected = story.getStoryName();
//        Assert.assertEquals(actual, expected);
    }
}
