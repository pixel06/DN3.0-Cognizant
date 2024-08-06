package LogManagementSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {

    public void writelog(String filename, String logMessage)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            writer.write(logMessage);
            System.out.println("Log message saved to " + filename);
        }
        catch(IOException e)
        {
           e.printStackTrace();
        }
        
    }
    
}
