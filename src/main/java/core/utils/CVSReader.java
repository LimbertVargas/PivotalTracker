package core.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CVSReader {

    public static void main(String[] args) {
        String csvFile = System.getProperty("user.dir") + "/" + "src/test/resources/files/workshop2_20191006_1729.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String ids[] = new String[22];
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] country = line.split(cvsSplitBy);
                int j = 0;
                j++;
                ids[j] = country[0];
                System.out.println(ids[j]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
