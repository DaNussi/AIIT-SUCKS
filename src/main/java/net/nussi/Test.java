package net.nussi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {

    public static void main(String[] args) throws IOException {


        String decryptedExample = Files.readString(Path.of("data\\test\\DecryptedExample.txt")).replaceAll("\r", "");
        String encryptedExample = Files.readString(Path.of("data\\test\\EncryptedExample.txt")).replaceAll("\r", "");
        String encryptedMessage = Files.readString(Path.of("data\\test\\EncryptedMessage.txt")).replaceAll("\r", "");
        String decryptedMessage = "";


        while (encryptedMessage.length() % 8 != 0) { encryptedMessage += " "; }

        for (int i = 0; i < encryptedMessage.length(); i+=8) {
            decryptedMessage += encryptedMessage.substring(i + 0, i + 1);
            decryptedMessage += encryptedMessage.substring(i + 1, i + 2);
            decryptedMessage += encryptedMessage.substring(i + 2, i + 3);
            decryptedMessage += encryptedMessage.substring(i + 3, i + 4);

            decryptedMessage += encryptedMessage.substring(i + 7, i + 8);
            decryptedMessage += encryptedMessage.substring(i + 6, i + 7);
            decryptedMessage += encryptedMessage.substring(i + 5, i + 6);
            decryptedMessage += encryptedMessage.substring(i + 4, i + 5);
        }

        System.out.println("Data:\n" + encryptedMessage);
        System.out.println("Output:\n" + decryptedMessage);

        Files.writeString(Path.of("data\\test\\DecryptedMessage.txt"), decryptedMessage);
    }

}
