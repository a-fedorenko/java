import java.io.*;

class CaesarWriter extends FilterWriter {
    private final int key;
    protected CaesarWriter(Writer out, int key) { super(out); this.key = key; }
    @Override
    public void write(int c) throws IOException { super.write(c + key); }
}

class CaesarReader extends FilterReader {
    private final int key;
    protected CaesarReader(Reader in, int key) { super(in); this.key = key; }
    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1) ? -1 : (c - key);
    }
}

public class CaesarCipherApp {
    public static void main(String[] args) {
        int key = 5;
        String originalFile = "secret.txt";
        String encryptedFile = "encrypted.dat";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(originalFile))) {
            writer.write("Hello Java I/O Streams! This is a secret message.");
            System.out.println("Файл " + originalFile + " успішно створено.");
        } catch (IOException e) {
            System.err.println("Не вдалося створити початковий файл: " + e.getMessage());
            return;
        }

        encrypt(originalFile, encryptedFile, key);
        
        decrypt(encryptedFile, key);
    }

    public static void encrypt(String from, String to, int key) {
        try (Reader in = new FileReader(from);
             Writer out = new CaesarWriter(new FileWriter(to), key)) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            System.out.println("Файл зашифровано у: " + to);
        } catch (IOException e) {
            System.err.println("Помилка при шифруванні: " + e.getMessage());
        }
    }

    public static void decrypt(String from, int key) {
        File file = new File(from);
        if (!file.exists()) {
            System.err.println("Помилка: Файл для дешифрування не знайдено: " + from);
            return;
        }

        try (Reader in = new CaesarReader(new FileReader(from), key)) {
            System.out.print("Дешифрований вміст: ");
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Помилка при дешифруванні: " + e.getMessage());
        }
    }
}