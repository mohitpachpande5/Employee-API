package examples;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Remove Specific Lines form File
public class RemoveSpecificLinesNIO {
	 public static void removeLines_UsingFiles(Path filePath, int... lineNumbers) {
	        try {
	            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);

	            System.out.println("Removing lines: " + Arrays.toString(lineNumbers));

	            List<String> updatedLines = lines.stream()
	                    .filter(line -> {
	                        int index = lines.indexOf(line) + 1;
	                        boolean shouldRemove = contains(lineNumbers, index);
	                        if (shouldRemove) {
	                            System.out.println("Removed Line " + index + ": " + line);
	                        }
	                        return !shouldRemove;
	                    })
	                    .collect(Collectors.toList());

	            // Ensure no extra blank lines and proper formatting
	            Files.write(filePath, updatedLines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);

	            System.out.println("Lines removed successfully using Files API!");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static boolean contains(int[] array, int value) {
	        for (int num : array) {
	            if (num == value) return true;
	        }
	        return false;
	    }
	    
		
	public static void main(String[] args) {
		Path filePath = Paths.get("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\dest2.txt");  // Source file
       	//removeLines_UsingFileChannel(filePath, 3, 5, 7); // Example: Remove lines 3, 5, and 7
       	removeLines_UsingFiles(filePath, 3, 5, 7);

	}
	
	public static void removeLines_UsingFileChannel(Path filePath, int... lineNumbers) {
        try (FileChannel inputChannel = FileChannel.open(filePath, StandardOpenOption.READ)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            StringBuilder fileContent = new StringBuilder();
            List<String> updatedLines = new ArrayList<>();

            // Read file content
            while (inputChannel.read(buffer) > 0) {
                buffer.flip();
                fileContent.append(StandardCharsets.UTF_8.decode(buffer));
                buffer.clear();
            }

            // Split content into lines
            String[] lines = fileContent.toString().split("\r?\n"); // Handles Windows & Linux newlines

            System.out.println("Removing lines: " + Arrays.toString(lineNumbers));

            // Remove specified lines
            for (int i = 0; i < lines.length; i++) {
                if (contains(lineNumbers, i + 1)) {
                    System.out.println("Removed Line " + (i + 1) + ": " + lines[i]);
                } else {
                    updatedLines.add(lines[i]);
                }
            }

            // Write updated content back using FileChannel
            try (FileChannel outputChannel = FileChannel.open(filePath, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
                ByteBuffer writeBuffer = ByteBuffer.wrap(String.join("\n", updatedLines).getBytes(StandardCharsets.UTF_8));
                outputChannel.write(writeBuffer);
            }

            System.out.println("Lines removed successfully using FileChannel!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  

}
