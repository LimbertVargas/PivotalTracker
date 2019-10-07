/*
 * @(#) Context.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.entities;

import pivotaltracker.StoryObject;

/**
 * Context class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class Context {
    private Account account;
    private Project project;
    private Story story;
    private User user;
    private StoryObject storyObject;

    /**
     * Context for creation of the constructor.
     */
    public Context() {
        this.account = new Account();
        this.project = new Project();
        this.story = new Story();
        this.user = new User();
    }

    /**
     * Returns the account of context.
     *
     * @return account.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Returns the project of context.
     *
     * @return project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Gets the story of context.
     *
     * @return story
     */
    public Story getStory() {
        return story;
    }

    /**
     * Returns the user of context.
     *
     * @return user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Gets storyObject.
     *
     * @return storyObject
     */
    public StoryObject getStoryObject() {
        return storyObject;
    }

    /**
     * Sets storyObject.
     *
     * @param storyObject - Story object.
     */
    public void setStoryObject(final StoryObject storyObject) {
        this.storyObject = storyObject;
    }
}
