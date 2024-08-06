package NoteTakingApp;

import java.util.Scanner;

public class NoteApp {

    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        System.out.println("Enter your note:");
        String note = read.nextLine();

        String fileName = "note.txt";

        FileWriterDemo fileWriterDemo = new FileWriterDemo();
        fileWriterDemo.saveNoteToFile(fileName, note);

        FileReaderDemo fileReaderDemo = new FileReaderDemo();
        System.out.println("The note read from the file is:");
        fileReaderDemo.readNoteFromFile(fileName);

        read.close();

    }
    
}
