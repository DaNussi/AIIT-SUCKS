package net.nussi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BlockSipher4 {

    public static void main(String[] args) throws IOException {

        String data = Files.readString(Path.of("data\\BlockSipher4.txt")).replaceAll("\r", "");

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < data.length(); i+=4) {
            out.append(data.substring(i + 0, i + 1));
            out.append(data.substring(i + 1, i + 2));
            out.append(data.substring(i + 3, i + 4));
            out.append(data.substring(i + 2, i + 3));
        }

        System.out.println("Data:\n" + data);
        System.out.println("Output:\n" + out);

        Files.writeString(Path.of("data\\BlockSipher4_Output.txt"), out.toString());
    }
    
}
