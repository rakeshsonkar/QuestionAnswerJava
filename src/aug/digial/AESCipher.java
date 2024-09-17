package aug.digial;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xml.security.Init;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class AESCipher {
	// Encryption method in Java
    public static String encrypt(String encryptString, String encryptionKey) throws Exception {
        byte[] clearBytes = encryptString.getBytes(StandardCharsets.UTF_16);
        byte[] salt = new byte[] { 0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64, 0x76, 0x65, 0x64, 0x65, 0x76 };

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(encryptionKey.toCharArray(), salt, 1000, 256);
        SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(secretKey.getEncoded(), 0, 16));

        byte[] encryptedBytes = cipher.doFinal(clearBytes);

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    public static String encrypt2(String data, SecretKey key) throws Exception {
    	 Cipher cipher = Cipher.getInstance("AES");
         cipher.init(Cipher.ENCRYPT_MODE, key);
         byte[] encryptedBytes = cipher.doFinal(data.getBytes("UTF-8"));
         return Base64.getEncoder().encodeToString(encryptedBytes);
    }
 // Convert a string key into a SecretKey object
    public static SecretKey generateKey(String key) throws Exception {
    	 // Convert key to bytes and adjust length to 16 bytes (128 bits) for AES
        byte[] keyBytes = new byte[16]; // Use 16 bytes for a 128-bit key
        byte[] keyBytesOriginal = key.getBytes("UTF-8");

        // Copy the provided key bytes into the new key array (either truncates or pads with zeros)
        System.arraycopy(keyBytesOriginal, 0, keyBytes, 0, Math.min(keyBytesOriginal.length, keyBytes.length));

        return new SecretKeySpec(keyBytes, "AES");
    }


    // Decryption method in Java
    public static  byte[] decrypt(String cipherText, String encryptionKey) throws Exception {
        byte[] encryptedBytes = Base64.getDecoder().decode(cipherText);
        byte[] salt = new byte[] { 0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64, 0x76, 0x65, 0x64, 0x65, 0x76 };

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(encryptionKey.toCharArray(), salt, 1000, 256);
        SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(secretKey.getEncoded(), 0, 16));

        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
      
       
        // Convert decrypted bytes to String
        return decryptedBytes;
    }

    public static void main(String[] args) {
        try {
           // String originalString = "Hello, World!";
            String encryptionKey = "s$@se!i17@#";
    		String str = "m6aVtoAMEsSbhv9XtFeMHFcSoPcoSghw6WPPe8M9k8Lbkl5J3z4rlAEtp0let0WJNz7k9B Mbr7TN566qJ+u4QJG89xudPUFTc7nWvI5KtEwIYaySbEcs/WXjB1YO8HdnnfmSa39IyDo35sqX0/wc5fMDIuaIO86ZgWYq1ypkp08RLOekS4TpSCGwZgfRRyjhzi3K5G6pfIFv/u6dxtjtNVvHqRrVZ1iE5+sOmQs7eIDmVa de3AAYWKQOr2VVDxTixXYyvNxfHw6MKpW+WZ1kwC1d8mMYQnW+ckDoxc2RGjoyRGGO9PJWMb72X1Vg7H3W27OUklAF0k4azzExFD0deH6pU5+IXnFOPtz/pzYP66j+EX5milDe01ytTamdDnPYTLfvzTo1ZNxAy5cWxq/euT FUNID31YICWDOQ/VYNEhyRRJoW80+AFW75z+k9cvUy0IS157yfGKy4atNFpRpOnr+0tfnH2vPd5wTRMwKALQ/ro9QhbRcR/Efehcflf5j0g6whZuuaDwjRpkgsT8hzfiJYYbiSGvaTVvpewHiIzalZvw0J3y8QbX1ueOpb3a 68T7eEi8rKhg2VjsVMvKdgv9F4hyxyJgTSZp9P3SxjxDSuu/cAHsowbzbl9YJGRkAwOxJjnXPVFuOIfLimVdNdayEb8bG7k8Tl/cE8bjT6GvTqBmy9PI4Vp5zvQVmT2MSQJxv6ZOx6OX0F8rnpL+JOiyzlTNHuTN8hrA+FW+ kszdTt4rdISVWGVY49jQ8qRLuJTT2Pc/A+5W3HU57vQcHQKUP5P/f219DnjEoaxH9O7qJ1mlXeuBLOhPK9UyddcEozBAekIpT0PSnuev8uatWl1/EYszFM9WPr0o20altrIHI=";
    		//SO37248569();
           // String encryptedString = encrypt(originalString, encryptionKey);
           // System.out.println("Encrypted: " + encryptedString);
    		@SuppressWarnings("unused")
			String tes=AESDecryption.decrypt(str, encryptionKey);
    		byte[] decryptedXml = decrypt(str, encryptionKey);
    		 String xmlContent = new String(decryptedXml, StandardCharsets.UTF_8).trim();
    		 System.out.println("Decrypted XML: " + xmlContent);

    		// Locate the start of the XML content
             int xmlStartIndex = xmlContent.indexOf("<RequestPayload>");
             
             if (xmlStartIndex > 0) {
                 // Remove any unwanted characters before the start of the XML content
                 xmlContent = xmlContent.substring(xmlStartIndex);
             }

             // Add the correct XML declaration
             String correctedXml = "<?xml version='1.0' encoding='UTF-8'?>\n"+xmlContent;
             String str1="<RequestPayload><AppHdr><BankID>36</BankID><StateID>114</StateID><FileDefId>File.003</FileDefId></AppHdr><Document><GrpHdr><FileID>RNV8011414630100013528202406260122</FileID><CreDtTm>2024-06-26T12:10:50</CreDtTm></GrpHdr><Ntfctn><TrnSummry>39340</TrnSummry><Ntry><BookgDt>2024-01-29</BookgDt><ValDt>2024-01-29</ValDt><NtryDtls><NoOfTrn>1</NoOfTrn><TxDtls><Refs><MsgId>SNV8011400146301000135282024012900176</MsgId><PmtInfId>618554</PmtInfId><InstrId>1960259</InstrId><EndToEndId>19602591920362518769059</EndToEndId><Remark>VEP364618145</Remark><Amt>39340</Amt><CdtDbtInd>RJCT</CdtDbtInd><Ustrd>ACCOUNT DOES NOT EXIST</Ustrd><AccptncDtTm>2024-01-29T18:10:52</AccptncDtTm></Refs></TxDtls></NtryDtls></Ntry></Ntfctn></Document></RequestPayload>";

             
             String encryptedString = AESCipherEncryption.encrypt2(str1, encryptionKey);
             
             System.out.println("encyption :     =>" + encryptedString);
             byte[] decryptedXml2 = decrypt(encryptedString, encryptionKey);
    		 String xmlContent2 = new String(decryptedXml2, StandardCharsets.UTF_8).trim();
    		 System.out.println("Decrypted XML: " + xmlContent2);
             

             // Now parse the cleaned XML content
             InputStream is = new ByteArrayInputStream(correctedXml.getBytes(StandardCharsets.UTF_8));
             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
             DocumentBuilder builder = factory.newDocumentBuilder();
             Document document = builder.parse(is);
             
            System.out.println("Decrypted XML: " + document);

         // Initialize the Apache XML Security library
            Init.init();
            // Load the PFX file
           // String pfxFilePath = "‪C:\\Users\\DELL\\Desktop\\NICCERT.pfx";
            String pfxFilePath = "C:\\Users\\DELL\\Desktop\\NICCERT.pfx";
            String pfxPassword = "123";
            System.out.println("Loading PFX file from: " + pfxFilePath);
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream fis = new FileInputStream(pfxFilePath);
            keyStore.load(fis, pfxPassword.toCharArray());

            
			/*
			 * // Get the certificate from the PFX file String alias =
			 * keyStore.aliases().nextElement(); Certificate cert =
			 * keyStore.getCertificate(alias); X509Certificate x509Cert = (X509Certificate)
			 * cert;
			 */
            
         // Get the certificate and extract the public key
            String alias = keyStore.aliases().nextElement();
            Certificate cert = keyStore.getCertificate(alias);
            PublicKey publicKey = cert.getPublicKey();
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true); // Must be aware of XML namespaces
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new java.io.ByteArrayInputStream(xmlContent.getBytes("UTF-8")));

            // Find the Signature element
            NodeList nl = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
            if (nl.getLength() == 0) {
                System.out.println("No Signature element found.");
                return;
            }

            // Create a DOMValidateContext
            DOMValidateContext valContext = new DOMValidateContext(publicKey, nl.item(0));
            valContext.setProperty("org.jcp.xml.dsig.secureValidation", Boolean.FALSE);
            // Create an XMLSignatureFactory
            XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
           
           
            // Unmarshal the XMLSignature object
            XMLSignature signature = signatureFactory.unmarshalXMLSignature(valContext);

            // Validate the XML Signature
            boolean coreValidity = signature.validate(valContext);

            if (coreValidity) {
                System.out.println("Signature is valid.");
            } else {
                System.out.println("Signature is not valid.");
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static String encrypt2(String plainText, String encryptionKey) throws Exception {
        // Convert the plainText to bytes
        byte[] plainTextBytes = plainText.getBytes(StandardCharsets.UTF_8);
        
        // Define a salt (same as in your C# code)
        byte[] salt = new byte[] {
            (byte)0x49, (byte)0x76, (byte)0x61, (byte)0x6e, (byte)0x20, (byte)0x4d,
            (byte)0x65, (byte)0x64, (byte)0x76, (byte)0x65, (byte)0x64, (byte)0x65, (byte)0x76
        };

        // Derive the key using PBKDF2 with HmacSHA256
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(encryptionKey.toCharArray(), salt, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

        // Derive the IV using PBKDF2 with HmacSHA256 (128 bits for AES IV)
        spec = new PBEKeySpec(encryptionKey.toCharArray(), salt, 65536, 128);
        tmp = factory.generateSecret(spec);
        byte[] iv = tmp.getEncoded();
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Initialize AES Cipher for encryption
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        // Perform encryption
        byte[] encryptedBytes = cipher.doFinal(plainTextBytes);

        // Encode the encrypted bytes to Base64 to get a string representation
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        return encryptedText;
    }
    
    // Method to perform AES decryption
    public static String decrypt2(String encryptedText, String encryptionKey) throws Exception {
        // Decode the encrypted Base64 string to get the encrypted bytes
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        
        // Define the same salt used for encryption
        byte[] salt = new byte[] {
            (byte)0x49, (byte)0x76, (byte)0x61, (byte)0x6e, (byte)0x20, (byte)0x4d,
            (byte)0x65, (byte)0x64, (byte)0x76, (byte)0x65, (byte)0x64, (byte)0x65, (byte)0x76
        };

        // Derive the key using PBKDF2 with HmacSHA256
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(encryptionKey.toCharArray(), salt, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

        // Derive the IV using PBKDF2 with HmacSHA256 (128 bits for AES IV)
        spec = new PBEKeySpec(encryptionKey.toCharArray(), salt, 65536, 128);
        tmp = factory.generateSecret(spec);
        byte[] iv = tmp.getEncoded();
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Initialize AES Cipher for decryption
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        // Perform decryption
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Convert decrypted bytes to string (assuming UTF-8 encoding)
        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);

        return decryptedText;
    }
}
