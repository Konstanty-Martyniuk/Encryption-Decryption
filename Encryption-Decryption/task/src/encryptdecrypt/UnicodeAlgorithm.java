package encryptdecrypt;

public class UnicodeAlgorithm implements EncryptionAlgorithm {
    @Override
    public String encode(String source, int key) {
        StringBuilder sb = new StringBuilder();
        for (char letter: source.toCharArray()) {
            int intValue = letter;
            intValue += key;
            sb.append((char) intValue);
        }
        return sb.toString();
    }

    @Override
    public String decode(String source, int key) {
        return encode(source, -key);
    }
}
