package encryptdecrypt;

public interface EncryptionAlgorithm {
    String shift = "shift";
    String unicode = "unicode";

    static EncryptionAlgorithm getInstance(String type) {
        switch (type) {
            case shift: return new ShiftAlgorithm();
            case unicode: return new UnicodeAlgorithm();
            default: throw new IllegalArgumentException("Unknown algorithm: " + type);
        }
    }

    String encode(String message, int key);
    String decode(String message, int key);
}
