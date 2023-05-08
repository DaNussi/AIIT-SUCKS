package net.nussi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BlockSipher8 {

    public static void main(String[] args) throws IOException {

        String data = Files.readString(Path.of("data\\BlockSipher8.txt")).replaceAll("\r", "");

        StringBuilder out = new StringBuilder();

        while (data.length() % 8 != 0) { data += " "; }

        for (int i = 0; i < data.length(); i+=8) {
            out.append(data.substring(i + 0, i + 1));
            out.append(data.substring(i + 1, i + 2));
            out.append(data.substring(i + 2, i + 3));
            out.append(data.substring(i + 3, i + 4));

            out.append(data.substring(i + 7, i + 8));
            out.append(data.substring(i + 6, i + 7));
            out.append(data.substring(i + 5, i + 6));
            out.append(data.substring(i + 4, i + 5));
        }

        System.out.println("Data:\n" + data);
        System.out.println("Output:\n" + out);

        Files.writeString(Path.of("data\\BlockSipher8_Output.txt"), out.toString());
    }
}
