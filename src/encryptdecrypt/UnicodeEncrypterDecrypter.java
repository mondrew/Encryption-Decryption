package encryptdecrypt;

public class UnicodeEncrypterDecrypter extends EncrypterDecrypter {

    public UnicodeEncrypterDecrypter(String mode, String data,
                                   String in, String out, Integer key) {
        super(mode, data, in, out, key);
    }

    @Override
    public String doAlgorithm(boolean encrypt) {
        StringBuilder sb = new StringBuilder();
        for (char c : getData().toCharArray()) {
            sb.append((char) (encrypt ? c + getKey() : c - getKey()));
        }
        return sb.toString();
    }
}
