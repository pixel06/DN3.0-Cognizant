package BackupSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DirectoryCopy {

    public static void copyDirectory(Path sourceDir, Path targetDir) {
        try {
            if (!Files.exists(targetDir)) {
                Files.createDirectories(targetDir);
            }

            try (var stream = Files.walk(sourceDir)) {
                stream.forEach(source -> {
                    Path target = targetDir.resolve(sourceDir.relativize(source));
                    try {
                        if (Files.isDirectory(source)) {
                            if (!Files.exists(target)) {
                                Files.createDirectory(target);
                            }
                        } else {
                            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                        }
                    } catch (IOException e) {
                        System.err.println("Error copying: " + e.getMessage());
                    }
                });
            }
        } catch (IOException e) {
            System.err.println("Error copying directory: " + e.getMessage());
        }
    }
}

