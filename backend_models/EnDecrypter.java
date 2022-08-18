package backend_models;

/**
 *
 * @author Nich
 */
public class EnDecrypter {

    public static char[] encrypt(char[] plainText) {
        char[] cipherText = new char[plainText.length]; // 1 is a dummy number
        cipherText = plainText;
        for (int p = 0; p < cipherText.length; p++) {

            cipherText[p] += 18;

        }

        return cipherText;

    }

    public static char[] decrypt(char[] cipherText) {
        char[] plainText = new char[cipherText.length]; // 1 is a dummy number
        plainText = cipherText;

        for (int p = 0; p < cipherText.length; p++) {

            cipherText[p] -= 18;

        }
        return plainText;

    }
}
