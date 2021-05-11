package encryptdecrypt;

import static java.util.Objects.requireNonNullElse;

public class AppConfig {
    private static final String ALGORITHM = "-alg";
    private static final String MODE = "-mode";
    private static final String KEY = "-key";
    private static final String INPUT_FILE = "-in";
    private static final String OUTPUT_FILE = "-out";
    private static final String DATA = "-data";

    int key;
    String data;
    String inputFile;
    String outputFile;
    EncryptionMode mode;
    EncryptionAlgorithm algorithm;

    AppConfig(String... args) {
        for (int i = 0; i < args.length - 1; ++i) {
            String parameter = args[i];
            if (parameter.startsWith("-")) {
                setParameter(parameter, args[i + 1]);
            }
        }
    }

    public EncryptionMode getMode() {
        return requireNonNullElse(mode, EncryptionMode.ENC);
    }

    public EncryptionAlgorithm getAlgorithm() {
        if (algorithm == null) {
            return new ShiftAlgorithm();
        }
        return algorithm;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    private void setParameter(String parameter, String value) {
        switch (parameter) {
            case ALGORITHM:
                algorithm = EncryptionAlgorithm.getInstance(value);
                break;
            case MODE:
                mode = EncryptionMode.valueOf(value.toUpperCase());
                break;
            case KEY:
                key = Integer.parseInt(value);
                break;
            case INPUT_FILE:
                inputFile = value;
                break;
            case OUTPUT_FILE:
                outputFile = value;
                break;
            case DATA:
                data = value;
                break;
            default: throw new IllegalArgumentException("Wrong parameters: " + parameter);
        }
    }

    public boolean isEncode() {
        return getMode() == EncryptionMode.ENC;
    }
}
