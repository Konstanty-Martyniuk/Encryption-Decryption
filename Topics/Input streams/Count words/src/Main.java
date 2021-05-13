import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = reader.readLine().trim();
        reader.close();

        if (result.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Arrays.stream(result.split("\\s+")).count());
        }
    }
}