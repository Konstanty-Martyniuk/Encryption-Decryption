import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte[] bytes = new byte[50];
        int read = inputStream.read(bytes);
        for (int i = 0; i < read; i++) {
            System.out.print(bytes[i]);
        }
        inputStream.close();
    }
}