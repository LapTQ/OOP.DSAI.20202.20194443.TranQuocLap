package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConcatenationInLoops {

    public static void main(String[] args) throws IOException {
        String filename = "text.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b: inputBytes) {
            outputString += (char)b;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time by String: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b: inputBytes) {
            outputStringBuilder.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time by StringBuilder: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        StringBuffer outputStringBuffer = new StringBuffer();
        for (byte b: inputBytes) {
            outputStringBuffer.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time by StringBuffer: " + (endTime - startTime));
    }
}
