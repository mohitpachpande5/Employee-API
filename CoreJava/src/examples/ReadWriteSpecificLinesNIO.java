package examples;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

//Read Specific Lines & Write to a New File
public class ReadWriteSpecificLinesNIO {
	private static void copySpecificLines_Files(Path inPath,Path outPath) {
		 try {
	            // Read all lines from the file
	            List<String> lines = Files.readAllLines(inPath, StandardCharsets.UTF_8);

	            // Get the required lines (14, 15, 18) - Remember list index starts from 0
	            String line14 = (lines.size() >= 14) ? lines.get(13) : "";
	            String line15 = (lines.size() >= 15) ? lines.get(14) : "";
	            String line18 = (lines.size() >= 18) ? lines.get(17) : "";

	            // Write to a new file
	            Files.write(outPath, List.of(line14, line15, line18), StandardCharsets.UTF_8,
	                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

	            System.out.println("Selected lines saved to " + outPath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
    public static void main(String[] args) {
        Path inputFile = Paths.get("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\dest2.txt");  // Source file
        Path outputFile = Paths.get("E:\\ProgrammingLang\\Java\\JavaFullStack\\CoreJava\\src\\output.txt"); // Destination file
        copySpecificLines_Files(inputFile,outputFile);
        copySpecificLines_FileChannel(inputFile,outputFile);
       
    }
    
    private static void copySpecificLines_FileChannel(Path inPath, Path outPath) {
        try (FileChannel inputChannel = FileChannel.open(inPath, StandardOpenOption.READ);
             FileChannel outputChannel = FileChannel.open(outPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024); // Buffer for reading
            StringBuilder fileContent = new StringBuilder();
            List<String> selectedLines = new ArrayList<>();
            
            // Read file content into StringBuilder
            while (inputChannel.read(buffer) > 0) {
                buffer.flip();
                fileContent.append(StandardCharsets.UTF_8.decode(buffer));
                buffer.clear();
            }

            // Split content into lines
            String[] lines = fileContent.toString().split("\n");

            // Extract required lines (14, 15, 18) - Adjusting index (0-based)
            if (lines.length >= 14) selectedLines.add(lines[13]); // Line 14
            if (lines.length >= 15) selectedLines.add(lines[14]); // Line 15
            if (lines.length >= 18) selectedLines.add(lines[17]); // Line 18

            // Convert selected lines to bytes and write using FileChannel
            for (String line : selectedLines) {
                byte[] lineBytes = (line + System.lineSeparator()).getBytes(StandardCharsets.UTF_8);
                ByteBuffer writeBuffer = ByteBuffer.wrap(lineBytes);
                outputChannel.write(writeBuffer);
            }

            System.out.println("Selected lines saved to " + outPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

