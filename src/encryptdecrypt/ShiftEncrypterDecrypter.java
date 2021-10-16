package encryptdecrypt;

public class ShiftEncrypterDecrypter extends EncrypterDecrypter {

    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public ShiftEncrypterDecrypter(String mode, String data,
                              String in, String out, Integer key) {
        super(mode, data, in, out, key);
    }

    public String doAlgorithm(boolean encrypt) {
        StringBuilder sb = new StringBuilder();

        for (char c : getData().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(lowerAlphabet.charAt(
                        (encrypt ? lowerAlphabet.indexOf(c) + getKey() :
                        (lowerAlphabet.indexOf(c) - getKey()) >= 0 ?
                                (lowerAlphabet.indexOf(c) - getKey()) :
                                (lowerAlphabet.indexOf(c) - getKey() + 26)
                        )
                                % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(upperAlphabet.charAt(
                        (encrypt ? upperAlphabet.indexOf(c) + getKey() :
                                (upperAlphabet.indexOf(c) - getKey()) >= 0 ?
                                        (upperAlphabet.indexOf(c) - getKey()) :
                                        (upperAlphabet.indexOf(c) - getKey() + 26)
                        )
                                % 26));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
