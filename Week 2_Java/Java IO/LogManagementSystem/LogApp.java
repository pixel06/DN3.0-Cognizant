package LogManagementSystem;

import java.util.Scanner;

public class LogApp {

    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        String logMessage = read.nextLine();
        String filename = "demo.txt";

        LogWriter logwriter = new LogWriter();
        logwriter.writelog(filename, logMessage);

        LogReader logreader = new LogReader();
        System.out.println("The Message read from file is:");
        logreader.readLogs(filename);

    }
    
}
