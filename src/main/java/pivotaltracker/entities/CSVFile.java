package pivotaltracker.entities;

public class CSVFile {
    private String fileName;
    private String[] id;
    private String[] titlesStory;
    private String[] labels;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getTitlesStory() {
        return titlesStory;
    }

    public void setTitlesStory(String[] titlesStory) {
        this.titlesStory = titlesStory;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }
}
