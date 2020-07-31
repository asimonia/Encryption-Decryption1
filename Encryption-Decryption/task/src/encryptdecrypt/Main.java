package encryptdecrypt;

import java.io.*;

public class Main {
    public static String targetOperation = "";
    public static String msg = "";
    public static String fileNameIn = null;
    public static String fileNameOut = null;
    public static int key = 0;
    public static String alg = "shift";

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                targetOperation = args[i + 1];
            }
            if (args[i].equals("-data")) {
                msg = args[i + 1];
                msg = msg.replace("\"", "");
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-in")) {
                fileNameIn = args[i + 1];
            }
            if (args[i].equals("-out")) {
                fileNameOut = args[i + 1];
            }
            if (args[i].equals("-alg")) {
                alg = args[i + 1];
            }
        }

        if (fileNameOut != null) {
            try {
                String temp = "";
                if (fileNameIn != null) {
                    File file = new File(fileNameIn);
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while ((msg = reader.readLine()) != null) {
                        Crypto crypto = new Crypto();
                        if (alg.equals("shift")) {
                            crypto.setMethod(new ShiftStrategy());
                        }

                        if (alg.equals("unicode")) {
                            crypto.setMethod(new UnicodeStrategy());
                        }

                        if (targetOperation.equals("enc")) {
                            temp = crypto.encryption(msg, key);
                        } else if (targetOperation.equals("dec")) {
                            temp = crypto.decryption(msg, key);
                        } else {
                            temp = crypto.encryption(msg, key);
                        }
                    }
                    reader.close();
                } else {
                    Crypto crypto = new Crypto();
                    if (alg.equals("shift")) {
                        crypto.setMethod(new ShiftStrategy());
                    }

                    if (alg.equals("unicode")) {
                        crypto.setMethod(new UnicodeStrategy());
                    }

                    if (targetOperation.equals("enc")) {
                        temp = crypto.encryption(msg, key);
                    } else if (targetOperation.equals("dec")) {
                        temp = crypto.decryption(msg, key);
                    } else {
                        temp = crypto.encryption(msg, key);
                    }
                }

                FileWriter myWriter = new FileWriter(fileNameOut);
                myWriter.write(temp);
                myWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }

        Crypto crypto = new Crypto();
        if (alg.equals("shift")) {
            crypto.setMethod(new ShiftStrategy());
        }

        if (alg.equals("unicode")) {
            crypto.setMethod(new UnicodeStrategy());
        }

        if (targetOperation.equals("enc")) {
            System.out.print(crypto.encryption(msg, key));
        } else if (targetOperation.equals("dec")) {
            System.out.print(crypto.decryption(msg, key));
        } else {
            System.out.print(crypto.encryption(msg, key));
        }
    }

}

