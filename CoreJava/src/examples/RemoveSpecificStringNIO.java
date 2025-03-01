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
import java.util.List;
import java.util.stream.Collectors;


public class RemoveSpecificStringNIO {
	 // Remove a specific string from each line of a text file using FileChannel and ByteBuffer.
	public static void removeString_UsingFileChannel(Path filePath, String targetString) {
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
            String[] lines = fileContent.toString().split("\r?\n");

            System.out.println("Removing occurrences of: \"" + targetString + "\"");

            // Remove target string & filter out empty lines
            for (String line : lines) {
                String modifiedLine = line.replace(targetString, "").trim(); // Trim spaces
                if (!modifiedLine.isEmpty()) { // Remove blank lines
                    updatedLines.add(modifiedLine);
                    System.out.println("Modified Line: " + modifiedLine);
                }
            }

            // Write updated content back using FileChannel
            try (FileChannel outputChannel = FileChannel.open(filePath, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
                ByteBuffer writeBuffer = ByteBuffer.wrap(String.join("\n", updatedLines).getBytes(StandardCharsets.UTF_8));
                outputChannel.write(writeBuffer);
            }

            System.out.println("String removed successfully using FileChannel!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	public static void main(String[] args) {
		Path filePath = Paths.get("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\dest2.txt");  // Source file
		removeString_UsingFileChannel(filePath, "line 14"); // Example: Remove occurrences of "line 14"
		//removeString_UsingFiles(filePath, "line 13"); // Example: Remove occurrences of "line 14"
	}
	
	// Remove a specific string from each line of a text file using Files API.
	public static void removeString_UsingFiles(Path filePath, String targetString) {
        try {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);

            System.out.println("Removing occurrences of: \"" + targetString + "\"");

            // Remove target string & filter out empty lines
            List<String> updatedLines = lines.stream()
                    .map(line -> line.replace(targetString, "").trim()) // Remove the string & trim spaces
                    .filter(line -> !line.isEmpty()) // Remove blank lines
                    .collect(Collectors.toList());

            // Write updated content back to the file
            Files.write(filePath, updatedLines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("String removed successfully using Files API!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
