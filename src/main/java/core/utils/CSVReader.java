package core.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.lang3.ArrayUtils;

public class CSVReader {

    /**
     * Gets all story names.
     *
     * @return Name story array
     */
    public String[] getNamesStory(final String file) {
        String csvFile = System.getProperty("user.dir") + "/" + "src/test/resources/files/" + file;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int linenumber = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while (br.readLine() != null) {
                linenumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(linenumber + " This is the line number");
        String storyData[] = new String[linenumber];
        try {
            br = new BufferedReader(new FileReader(csvFile));
            for (int j = 0; j < storyData.length; j++) {
                line = br.readLine();
                String[] storyField = line.split(cvsSplitBy);
                storyData[j] = storyField[1];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        storyData = ArrayUtils.remove(storyData, 0);
        return storyData;
    }
}
