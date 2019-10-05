package pivotaltracker;

public class StoryObject {
    private String kind;
    private static int id;
    private int estimate;
    private String storyType;
    private String name;


    public StoryObject(final String kind, final int id, final int estimate, final String storyType,
                       final String name) {
        this.kind = kind;
        this.id = id;
        this.estimate = estimate;
        this.storyType = storyType;
        this.name = name;
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
}
