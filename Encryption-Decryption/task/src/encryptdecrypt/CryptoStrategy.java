package encryptdecrypt;

public interface CryptoStrategy {

    String getEncryption(String msg, int key);

    String getDecryption(String msg, int key);

}
