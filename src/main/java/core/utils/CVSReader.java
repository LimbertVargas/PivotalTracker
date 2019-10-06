package core.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CVSReader {

    public String[] getIdsStory() {
        String csvFile = System.getProperty("user.dir") + "/" + "src/test/resources/files/workshop2_20191006_1729.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String ids[] = new String[23];
        try {
            int j =0;
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] country = line.split(cvsSplitBy);
                ids[j] = country[0];
                System.out.println(ids[j]);
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ids;
    }
}
