package BackupSystem;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BackupApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the source directory: ");
        String sourceDirString = scanner.nextLine();
        System.out.print("Enter the target directory: ");
        String targetDirString = scanner.nextLine();

        Path sourceDir = Paths.get(sourceDirString);
        Path targetDir = Paths.get(targetDirString);

        DirectoryCopy.copyDirectory(sourceDir, targetDir);

        scanner.close();
    }
}
