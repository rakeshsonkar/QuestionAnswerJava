package aug.digial;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;  // Correct import for SecretKeySpec
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.security.Init;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class AESCipher1 {
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
            String encryptionKey = "s$@se!i18";
        	String str = "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";
    		//SO37248569();
           // String encryptedString = encrypt(originalString, encryptionKey);
           // System.out.println("Encrypted: " + encryptedString);

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
             String correctedXml = "<?xml version='1.0' encoding='UTF-8'?>\n" + xmlContent;

             

             // Now parse the cleaned XML content
             InputStream is = new ByteArrayInputStream(correctedXml.getBytes(StandardCharsets.UTF_8));
             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
             DocumentBuilder builder = factory.newDocumentBuilder();
             Document document = builder.parse(is);
             
            System.out.println("Decrypted XML: " + document);

         // Initialize the Apache XML Security library
            Init.init();
       
            // PEM-encoded public key string (without the "BEGIN" and "END" lines)
            String pemPublicKey ="-----BEGIN PUBLIC KEY-----\n" +
            		"MIIFfTCCBGWgAwIBAgIHAJC/2eunXzANBgkqhkiG9w0BAQsFADB3MQswCQYDVQQGEwJJTjEiMCAGA1UEChMZU2lmeSBUZWNobm9sb2dpZXMgTGltaXRlZDEPMA0GA1UECxMGU3ViLUNBMTMwMQYDVQQDEypTYWZlU2NyeXB0IHN1Yi1DQSBmb3IgRG9jdW1lbnQgU2lnbmVyIDIwMjIwHhcNMjMxMDA2MTEyNTM2WhcNMjUxMDA2MTEyNTM2WjCB5TELMAkGA1UEBhMCSU4xIjAgBgNVBAoTGUUtVFJFQVNVUlkgT0ZGSUNFUiBKQUlQVVIxGTAXBgNVBAsTEFRSRUFTVVJZIE9GRklDRVIxDzANBgNVBBETBjMwMjAwNTESMBAGA1UECBMJUmFqYXN0aGFuMUkwRwYDVQQFE0BCRUE2RDJDQ0U5NkUwM0I5QTY0NEEyN0Q1MzNDQkYwQkYyNjYwMDQ3M0E5QTI3OTk5NEU3Mjk4MTJBNzA2NkY3MScwJQYDVQQDEx5EUyBFLVRSRUFTVVJZIE9GRklDRVIgSkFJUFVSIDEwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDAMM1XbvlloGfUnAMVbAzYCCDR63MTpSrlFsptaByhrMbmHZd+uGPH5M1mGFKRhhaJiYWzD0YPcZy4Xh62Rcdwa6UuEjumE3QPR/Nq1lr9rAQlWzK+jyL9TkG7UdYXmX835UVHNM+PRCtWIIdQDr9m7edkGHOde+mPKoRxjO/9z5gjz+Ru0T42+QtMNl0yTA/WYryCYMTdoM9BDngpwVYBtw1xLU/lUYKpfPqzm9mXZ3uVCftjUGdQmCgYegfKk+MDzrxKZ1bq5k2ziYiMmgbsC5l/UKKXJk5ZOCm6eJt7//69ltdNyHcFcWYKiKmlU5omsJ2fBxObUsKiPPai7rb9AgMBAAGjggGdMIIBmTATBgNVHSMEDDAKgAhMxAu5Lz3OtDARBgNVHQ4ECgQISWA/bNoRrXIwgZcGCCsGAQUFBwEBBIGKMIGHMEUGCCsGAQUFBzAChjlodHRwczovL3d3dy5zYWZlc2NyeXB0bmV3LmNvbS9TYWZlU2NyeXB0RG9jU2lnbmVyMjAyMi5jZXIwPgYIKwYBBQUHMAGGMmh0dHA6Ly9vY3NwLnNhZmVzY3J5cHQuY29tL1NhZmVTY3J5cHREb2NTaWduZXIyMDIyMEcGA1UdHwRAMD4wPKA6oDiGNmh0dHA6Ly9jcmwyLnNhZmVzY3J5cHQuY29tL1NhZmVTY3J5cHREb2NTaWduZXIyMDIyLmNybDAnBgNVHSAEIDAeMAgGBmCCZGQCAzAIBgZggmRkAgIwCAYGYIJkZAoBMAwGA1UdEwEB/wQCMAAwKgYDVR0lBCMwIQYIKwYBBQUHAwQGCSqGSIb3LwEBBQYKKwYBBAGCNwoDDDAZBgNVHREEEjAQgQ5lLXRvLXJqQG5pYy5pbjAOBgNVHQ8BAf8EBAMCBsAwDQYJKoZIhvcNAQELBQADggEBAGnfgQrwKO18kn39dTdfRJwDpKnGkyTjVnXm6ec3fgMuAj1Lu50J2FB/ybrehseM0IXeGA3ssRBAxyzf6O1Eh6YHydVTC6B81eLxuSx8yTDp/N2ewZeTTpIUeNW9IZY8ExpfFNvbQuXUHLkPWztOHOqyxVpEMIx33hxqJfYkU4pN9a1sfRq+Oq6e6tBA6PqZrkTh/Pd4M9Z7aw8ErbQe+yhcuYbPF0PYg9g9TBWZUj07w4NSJd0yrJB5jkSRjjWuvRl3xRiz1GViXrSEIPSYdMt0HTZXYCgqxg+jlqAYN3ze98Ac5Wy8Mb14dZGkLpDhDET3fkPnRnSH7mtKGNFoVq4=\n"+
            		"-----END PUBLIC KEY-----";
            PublicKey publicKey = getPublicKeyFromPem(pemPublicKey);
            
            // Print the public key (for verification purposes)
            System.out.println("Public Key: " + publicKey);
            
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

	private static PublicKey getPublicKeyFromPem(String pemPublicKey) throws Exception  {
		 // Remove PEM headers and footers
        String publicKeyPEM = pemPublicKey.replace("-----BEGIN PUBLIC KEY-----", "")
                                 .replace("-----END PUBLIC KEY-----", "")
                                 .replaceAll("\\s", "");

        // Decode the base64 encoded string
        byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);

        // Create a KeyFactory for RSA
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        return keyFactory.generatePublic(keySpec);
	}
}
