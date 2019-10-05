package pivotaltracker;

/**
 * Project class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ProjectObject {
    private static int idProject;
    private int storyPoints;
    private String projectName;

    public ProjectObject(){
        idProject = 0;
    }

    /**
     * Gets id project.
     *
     * @return idProject
     */
    public static int getIdProject() {
        System.out.println(idProject + " id project");
        return idProject;
    }

    /**
     * Sets id project.
     *
     * @param idProject
     */
    public void setIdProject(int idProject) {
        System.out.println(idProject+ " alsjf;lajf;l");
        this.idProject = idProject;
    }

    /**
     * Gets story points.
     *
     * @return storyPoints
     */
    public int getStoryPoints() {
        return storyPoints;
    }

    /**
     * Sets story points.
     *
     * @param storyPoints
     */
    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    /**
     * Gets project name.
     *
     * @return projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets project name.
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
