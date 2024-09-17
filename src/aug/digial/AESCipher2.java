package aug.digial;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESCipher2 {

	private static final String ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final int IV_SIZE = 16; // 16 bytes for AES
    private static final int KEY_SIZE = 16; // 16 bytes = 128 bits

    public static void main(String[] args) {
        try {
            String securityKey = "s$@se!i18";  // 9 characters, will need to pad or truncate
            String key = generateKey(securityKey);

            // Generate a random IV and keep it the same for encryption and decryption
            String iv = generateIV();

            String plainText = "Hello, this is a test message!";

            String encryptedText = encrypt(plainText, key, iv);
            System.out.println("Encrypted Text: " + encryptedText);

            String decryptedText = decrypt(encryptedText, key, iv);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String plainText, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, "UTF-8");
    }

    private static String generateKey(String securityKey) {
        // Ensure the key is 16 bytes (128 bits) for AES-128
        byte[] keyBytes = new byte[KEY_SIZE];
        byte[] securityKeyBytes = securityKey.getBytes();
        System.arraycopy(securityKeyBytes, 0, keyBytes, 0, Math.min(securityKeyBytes.length, KEY_SIZE));
        return new String(keyBytes);
    }

    private static String generateIV() {
        byte[] iv = new byte[IV_SIZE];
        new SecureRandom().nextBytes(iv);
        return new String(iv);
    }
}
