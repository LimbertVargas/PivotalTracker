package pivotaltracker.entities;

/**
 * Workspace class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class Workspace {
    private String nameWorkspace;

    /**
     * Gets the name of the Workspace.
     *
     * @return workspace name.
     */
    public String getNameWorkspace() {
        return nameWorkspace;
    }

    /**
     * Sets the name of the Workspace.
     *
     * @param nameWorkspace for the workspace.
     */
    public void setNameWorkspace(final String nameWorkspace) {
        this.nameWorkspace = nameWorkspace;
    }
}
