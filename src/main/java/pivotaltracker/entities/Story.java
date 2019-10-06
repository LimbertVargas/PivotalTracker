package pivotaltracker.entities;

/**
 * Story class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class Story {
    private String storyName;
    private int id;
    private int estimate;
    private String storyType;
    private String label;

    /**
     * Gets story name.
     *
     * @return storyName
     */
    public String getStoryName() {
        return storyName;
    }

    /**
     * Sets story name.
     *
     * @param storyName - Story name.
     */
    public void setStoryName(final String storyName) {
        this.storyName = storyName;
    }

    /**
     * Gets storyid.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id - Story id.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets point estimate.
     *
     * @return estimate
     */
    public int getEstimate() {
        return estimate;
    }

    /**
     * Sets point estimate.
     *
     * @param estimate - Point estimate.
     */
    public void setEstimate(final int estimate) {
        this.estimate = estimate;
    }

    /**
     * Gets story type.
     *
     * @return storyType
     */
    public String getStoryType() {
        return storyType;
    }

    /**
     * Sets story type.
     *
     * @param storyType - Stroy type.
     */
    public void setStoryType(final String storyType) {
        this.storyType = storyType;
    }

    /**
     * Gets label.
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets label.
     *
     * @param label - Story label.
     */
    public void setLabel(final String label) {
        this.label = label;
    }
}
