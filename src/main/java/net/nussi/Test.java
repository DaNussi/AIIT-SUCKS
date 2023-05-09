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


        decryptedMessage = encryptedMessage;

        Files.writeString(Path.of("data\\test\\DecryptedMessage.txt"), decryptedMessage);
    }

}
