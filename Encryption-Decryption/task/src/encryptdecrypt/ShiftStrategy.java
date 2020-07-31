package encryptdecrypt;

public class ShiftStrategy implements CryptoStrategy {
    @Override
    public String getEncryption(String msg, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : msg.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    @Override
    public String getDecryption(String msg, int key) {
        return getEncryption(msg, 26 - (key % 26));
    }
}
