package pivotaltracker.ui.pages.story;

import pivotaltracker.BasePage;

/**
 * ProjectBasePage class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public abstract class ProjectBasePage extends BasePage {
    private LeftStoryBarPage leftStoryBarPage;
    private IceboxModelPage iceboxModelPage;
    private CurrentBacklogBasePage currentBacklogBasePage;


    /**
     * Constructor
     */
    public ProjectBasePage() {
        super();
        this.leftStoryBarPage = new LeftStoryBarPage();
        this.currentBacklogBasePage = new CurrentBacklogBasePage();
        this.iceboxModelPage = new IceboxModelPage();
    }

    /**
     * Gets LeftStoryBarPage
     */
    public LeftStoryBarPage getLeftStoryBarPage() {
        return leftStoryBarPage;
    }


    public CurrentBacklogBasePage getCurrentBacklogBasePage() {
        return currentBacklogBasePage;
    }

    public IceboxModelPage getIceboxModelPage() {
        return iceboxModelPage;
    }
}
