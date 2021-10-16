package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        CommandLineArguments arguments = new CommandLineArguments(args);
        EncrypterDecrypter encrypterDecrypter = CryptographyFactory
                .getInstance(arguments.getAlgorithm(),
                        arguments.getMode(), arguments.getData(),
                        arguments.getIn(), arguments.getOut(), arguments.getKey());
        if (encrypterDecrypter != null) {
            encrypterDecrypter.proceedCryptography();
        }
    }
}
