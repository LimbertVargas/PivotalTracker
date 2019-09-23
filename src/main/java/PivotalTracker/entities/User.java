package PivotalTracker.entities;

/**
 * User class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class User {
    private String user;

    /**
     * This method get user name that user fill.
     *
     * @return user
     */
    public String getUserName() {
        return user;
    }

    /**
     * This method set user name.
     *
     * @param user - User name
     */
    public void setUserName(final String user) {
        this.user = user;
    }
}