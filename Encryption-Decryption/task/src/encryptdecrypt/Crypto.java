package encryptdecrypt;

public class Crypto {

    private CryptoStrategy strategy;

    public void setMethod(CryptoStrategy strategy) {
        this.strategy = strategy;
    }

    public String encryption(String msg, int key) {
        return this.strategy.getEncryption(msg, key);
    }

    public String decryption(String msg, int key) {
        return this.strategy.getDecryption(msg, key);
    }
}
