package encryptdecrypt;

abstract class CryptographyFactory {

    public static EncrypterDecrypter getInstance(String algorithm, String mode,
                                                 String data, String in, String out,
                                                 Integer key) {
        switch (algorithm) {
            case "shift":
                return new ShiftEncrypterDecrypter(mode, data, in, out, key);
            case "unicode":
                return new UnicodeEncrypterDecrypter(mode, data, in, out, key);
            default:
                System.err.println("Error: unknown algorithm");
                System.exit(1);
                return null;
        }
    }
}
