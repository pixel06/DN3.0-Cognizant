package LogManagementSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {

    public void readLogs(String filename)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
