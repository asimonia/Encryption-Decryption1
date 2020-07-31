package encryptdecrypt;

public class UnicodeStrategy implements CryptoStrategy {
    @Override
    public String getEncryption(String msg, int key) {
        StringBuilder encMsg = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            encMsg.append(Character.toString(msg.charAt(i) + key));
        }
        return encMsg.toString();
    }

    @Override
    public String getDecryption(String msg, int key) {
        StringBuilder decMsg = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            decMsg.append(Character.toString(msg.charAt(i) - key));
        }
        return decMsg.toString();
    }
}
