package net.nussi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) throws IOException {


        String decryptedExample = Files.readString(Path.of("data\\test\\DecryptedExample.txt")).replaceAll("\r", "");
        String encryptedExample = Files.readString(Path.of("data\\test\\EncryptedExample.txt")).replaceAll("\r", "");
        String encryptedMessage = Files.readString(Path.of("data\\test\\EncryptedMessage.txt")).replaceAll("\r", "");
        String decryptedMessage = decrypt(encryptedMessage);
        Files.writeString(Path.of("data\\test\\DecryptedMessage.txt"), decryptedMessage);


        System.out.println("Data:\n" + encryptedMessage);
        System.out.println("Output:\n" + decryptedMessage);

        System.out.println();

        findWord(decryptedMessage,3, 4);
        findWord(decryptedMessage,4, 2);

        System.out.println();

        countWords(decryptedMessage, 'e', 2, 6);
    }

    public static String decrypt(String encryptedMessage) {
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

        return decryptedMessage;
    }

    public static String findWord(String decryptedMessage, int zeile, int wort) {
        String[] lines = decryptedMessage.split("\n");
        String line = lines[zeile - 1];

//        System.out.println("Suche in zeile: " + line);

        String[] words = line.split(" ");
        String word = words[wort - 1];

        System.out.println("Word bei [Zeile:" + zeile + ", Wort:" + wort + "] = \"" + word + "\"");

        return word;
    }

    public static void countWords(String decryptedMessage, char letter, int letterAmount, int specialWordIndex) {
        String data = decryptedMessage.toLowerCase();
        String[] words = data.split("[\n ]+");

        // Wörter filtern
        ArrayList<String> matchedWords = new ArrayList<>();
        for(String tempWord : words) {
            String word = tempWord.replaceAll("[ _!,.]+", "");

            // Zählen der buchstaben
            int countedLetters = 0;
            for(char c : word.toCharArray()) {
                if(c == letter) countedLetters++;
            }

            if(countedLetters == letterAmount) {
                matchedWords.add(word);
            }
        }

        System.out.println("Die Anzahl der Worte welche genau "+ letterAmount + " Buchstaben \"" + letter + "\" beinhalten: " + matchedWords.size());
        System.out.println("Wörter (NOCH EINMAL ÜBERPRÜFEN WICHTIG): " + Arrays.toString(matchedWords.toArray()));

        // Special Word
        System.out.println("Wie lautet das " + specialWordIndex +". Wort welches gefunden wurde: " + matchedWords.get(specialWordIndex-1));
    }

}
