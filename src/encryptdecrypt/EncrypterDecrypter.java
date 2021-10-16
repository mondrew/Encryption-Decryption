package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

abstract class EncrypterDecrypter {

    private String mode;
    private String data;
    private String in;
    private String out;
    private Integer key;

    public EncrypterDecrypter(String mode, String data,
                              String in, String out, Integer key) {
        this.mode = mode;
        this.data = data;
        this.in = in;
        this.out = out;
        this.key = key;

        if (in != null && data == null) {
            this.data = readDataFromFile(in);
        } else if (data == null) {
            this.data = "";
        }
    }

    abstract String doAlgorithm(boolean encrypt);

    public String encrypt() {
        return doAlgorithm(true);
    }
    public String decrypt() {
        return doAlgorithm(false);
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void proceedCryptography() {
        String res = null;

        if (in != null && data == null) {
            data = readDataFromFile(in);
        } else if (data == null) {
            data = "";
        }
        if (mode.equals("enc")) {
            res = encrypt();
        } else {
            res = decrypt();
        }
        if (out != null) {
            writeDataToFile(out, res);
        } else {
            System.out.println(res);
        }
    }

    public String readDataFromFile(String filename) {
        File file = new File(filename);
        StringBuilder stringBuilder = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
                if (scanner.hasNext()) {
                    stringBuilder.append('\n');
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void writeDataToFile(String filepath, String data) {
        File file = new File(filepath);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
