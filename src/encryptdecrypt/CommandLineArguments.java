package encryptdecrypt;

public class CommandLineArguments {

    private String mode;
    private String data;
    private String in;
    private String out;
    private Integer key;
    private String algorithm;

    public CommandLineArguments(String[] args) {
        this.mode = "enc";
        this.data = null;
        this.in = null;
        this.out = null;
        this.algorithm = "shift";
        this.key = 0;
        extractCommandLineArgs(args);
    }

    private void extractCommandLineArgs(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                    break;
                case "-out":
                    out = args[i + 1];
                    break;
                case "-alg":
                    algorithm = args[i + 1];
                    break;
                default:
                    break;
            }
        }
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

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
