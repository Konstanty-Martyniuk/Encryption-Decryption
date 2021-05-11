package encryptdecrypt;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isUpperCase;

public class ShiftAlgorithm implements EncryptionAlgorithm {

    private static final int ENG_ALPHABET_LETTERS_AMOUNT = 26;

    @Override
    public String encode(String message, int key) {
        StringBuilder sb = new StringBuilder();
        key = key > 26 ? key % 26 : key;

        for (char character: message.toCharArray()) {
            if (isAlphabetic(character)){
                char firstLetter = isUpperCase(character) ? 'A' : 'a';
                sb.append((char) (firstLetter + (character - firstLetter + key) % ENG_ALPHABET_LETTERS_AMOUNT));
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    @Override
    public String decode(String message, int key) {
        StringBuilder sb = new StringBuilder();
        key = key > 26 ? key % 26 : key;

        for (char character: message.toCharArray()) {
            if (isAlphabetic(character)){
                char lastLetter = isUpperCase(character) ? 'Z' : 'z';
                sb.append((char) (lastLetter - (lastLetter - character + key) % ENG_ALPHABET_LETTERS_AMOUNT));
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }
}
