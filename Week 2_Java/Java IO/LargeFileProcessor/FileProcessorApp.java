package LargeFileProcessor;

import java.util.List;
import java.util.stream.Collectors;

public class FileProcessorApp {
    public static void main(String[] args) {
        String inputFileName = "large_sales_data.txt"; 
        String outputFileName = "processed_sales_data.txt"; 

        LargeFileReader fileReader = new LargeFileReader();
        List<String> salesData = fileReader.readLargeFile(inputFileName);
        List<String> processedData = null;

       
        if (salesData != null) {
            
            processedData = salesData.stream()
                    .filter(line -> !line.trim().isEmpty())  
                    .collect(Collectors.toList());

            LargeFileWriter fileWriter = new LargeFileWriter();
            fileWriter.writeProcessedData(outputFileName, processedData);
        } else {
            System.out.println("Failed to read sales data from the input file.");
        }

        
        String nonExistentInputFile = "non_existent_file.txt";
        List<String> nonExistentData = fileReader.readLargeFile(nonExistentInputFile);
        if (nonExistentData == null) {
            System.out.println("Handled error for non-existent input file.");
        }

        
        String restrictedOutputFile = "/restricted_directory/output.txt";
        if (processedData != null) {
            LargeFileWriter fileWriter = new LargeFileWriter();
            fileWriter.writeProcessedData(restrictedOutputFile, processedData);
        } else {
            System.out.println("No processed data available to write to restricted directory.");
        }
    }
}
