package core.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.lang3.ArrayUtils;

public class CVSReader {

    public String[] getIdsStory() {
        String csvFile = System.getProperty("user.dir") + "/" + "src/test/resources/files/test_20191006_1736.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String ids[] = new String[5];
        try {
            br = new BufferedReader(new FileReader(csvFile));
            for (int j = 0; j < ids.length; j++) {
                line = br.readLine();
                String[] country = line.split(cvsSplitBy);
                ids[j] = country[1];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ids = ArrayUtils.remove(ids, 0);
        return ids;
    }
}
