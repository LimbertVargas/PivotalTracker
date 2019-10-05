package pivotaltracker;

public class StoryObject {
    private String kind;
    private static int id;
    private String createdAt;
    private String updateAt;
    private int estimate;
    private String storyType;
    private String name;
    private String currentState;
    private int requestedById;
    private String url;
    private int projectId;
    private String ownerIds;
    private String labels;

    public StoryObject(final String kind, final int id, final String createdAt, final String updateAt,
                       final int estimate, final String storyType, final String name, final String currentState,
                       final int requestedById, final String url, final int projectId, final String ownerIds,
                       final String labels) {
        this.kind = kind;
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.estimate = estimate;
        this.storyType = storyType;
        this.name = name;
        this.currentState = currentState;
        this.requestedById = requestedById;
        this.url = url;
        this.projectId = projectId;
        this.ownerIds = ownerIds;
        this.labels = labels;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        StoryObject.id = id;
    }


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public int getEstimate() {
        return estimate;
    }

    public void setEstimate(int estimate) {
        this.estimate = estimate;
    }

    public String getStoryType() {
        return storyType;
    }

    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public int getRequestedById() {
        return requestedById;
    }

    public void setRequestedById(int requestedById) {
        this.requestedById = requestedById;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getOwnerIds() {
        return ownerIds;
    }

    public void setOwnerIds(String ownerIds) {
        this.ownerIds = ownerIds;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }
}
