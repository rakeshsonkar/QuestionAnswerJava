package aug.digial;
import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCipherEncryption {
	public static String encrypt(String plainText, String encryptionKey) throws Exception {
		 // Generate a key and IV using PBKDF2
        @SuppressWarnings("unused")
		byte[] salt = "49 76 61 6e 20 4d 65 64 76 65 64 65 76".getBytes(); // Use the same salt as C# code
        SecretKeySpec secretKey = getKeyFromPassword(encryptionKey);
        IvParameterSpec iv = getIVFromPassword(encryptionKey);

        // Initialize cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        // Encrypt the plaintext
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static SecretKeySpec getKeyFromPassword(String password) throws Exception {
        // Hash the password using SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] key = md.digest(password.getBytes("UTF-8"));
        return new SecretKeySpec(key, "AES");
    }

    private static IvParameterSpec getIVFromPassword(String password) throws Exception {
        // Use first 16 bytes of hashed password as IV
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        byte[] iv = new byte[16];
        System.arraycopy(hash, 0, iv, 0, 16); // Take only the first 16 bytes for IV
        return new IvParameterSpec(iv);
    }
    
    public static String encrypt2(String plaintext, String encryptionKey) throws Exception {
    							
        byte[] salt = new byte[] {
                (byte)0x49, (byte)0x76, (byte)0x61, (byte)0x6e, (byte)0x20, (byte)0x4d, (byte)0x65, (byte)0x64,
                (byte)0x76, (byte)0x65, (byte)0x64, (byte)0x65, (byte)0x76
            };

            // Derive key and IV
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            KeySpec spec = new PBEKeySpec(encryptionKey.toCharArray(), salt, 1000, 256);
            SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

            byte[] keyBytes = secretKey.getEncoded();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(keyBytes, 0, 16);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    public static String encrypt3(String plaintext, String encryptionKey) throws Exception {
        byte[] salt = new byte[] {
            (byte)0x49, (byte)0x76, (byte)0x61, (byte)0x6e, (byte)0x20, (byte)0x4d, (byte)0x65, (byte)0x64,
            (byte)0x76, (byte)0x65, (byte)0x64, (byte)0x65, (byte)0x76
        };

        // Derive key and IV
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(encryptionKey.toCharArray(), salt, 1000, 256);
        SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

        byte[] keyBytes = secretKey.getEncoded();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(keyBytes, 0, 16);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }


}
