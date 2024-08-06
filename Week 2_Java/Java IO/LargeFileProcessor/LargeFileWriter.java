package LargeFileProcessor;

import java.io.*;
import java.util.List;

public class LargeFileWriter {
    public void writeProcessedData(String outputFileName, List<String> processedData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String line : processedData) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Processed data written to file: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + outputFileName);
            e.printStackTrace();
        }
    }
}
