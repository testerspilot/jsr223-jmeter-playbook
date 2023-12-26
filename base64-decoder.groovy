// Base-64 Decoder

import java.nio.charset.StandardCharsets;
import java.util.Base64;

// Get the previous sampler response
def base64String = prev.getResponseDataAsString();

// To test the script you can use enable the below line. It should decode the string to "hello world"
base64String = "aGVsbG8gd29ybGQ="

try {
    // Decode the Base64-encoded string
    byte[] decodedBytes = Base64.getDecoder().decode(base64String)
    
    // Convert the decoded bytes to a string using the appropriate character set (e.g., UTF-8)
    String decodedString = new String(decodedBytes, StandardCharsets.UTF_8)
    
    // Log the decoded string
    log.info("--------------Decoded Base64--------------------")
    log.info("Decoded String: " + decodedString)
    log.info("----------------------------------")
    
    // You can now use the 'decodedString' variable for further processing or assertions
} catch (Exception e) {
    log.error("Error decoding Base64: " + e.toString())
}
