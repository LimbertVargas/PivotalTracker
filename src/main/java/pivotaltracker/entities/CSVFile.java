package pivotaltracker.entities;

public class CSVFile {
    private String fileName;
    private String[] titlesStory;

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
}
