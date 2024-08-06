package LargeFileProcessor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LargeFileReader {
    public List<String> readLargeFile(String inputFileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Process each line, e.g., print it
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + inputFileName);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading file: " + inputFileName);
            e.printStackTrace();
        }
        return lines;
    }
}
