package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.util.Objects.nonNull;

public class Application implements Runnable {
    private static AppConfig appConfig;

    public Application(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public void run() {
        EncryptionAlgorithm algorithm = appConfig.getAlgorithm();
        int key = appConfig.getKey();
        String text = appConfig.getData() != null
                ? appConfig.getData()
                : readFile(appConfig.getInputFile());
        String convertedText = appConfig.isEncode()
                ? algorithm.encode(text, key)
                : algorithm.decode(text, key);

        returnResult(convertedText);
    }

    void returnResult(String convertedText) {
        if (nonNull(appConfig.getOutputFile())) {
            File file = new File(appConfig.getOutputFile());
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.println(convertedText);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(convertedText);
        }
    }

    private static String readFile(String inputFile){
        String text = "Error. Cannot read data from file!";
        try {
            File file = new File(inputFile);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                text = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return text;
    }

}
