import org.bouncycastle.openpgp.PGPPublicKeyRingCollection
import org.bouncycastle.openpgp.PGPPrivateKey
import org.bouncycastle.openpgp.PGPPublicKeyRing
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection
import org.bouncycastle.openpgp.PGPUtil
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyConverter

def decrypt(byte[] encryptedMessage, PGPPrivateKey privateKey) {
    def byteArrayInputStream = new java.io.ByteArrayInputStream(encryptedMessage)
    def pgpObjectFactory = new org.bouncycastle.openpgp.PGPObjectFactory(
            PGPUtil.getDecoderStream(byteArrayInputStream),
            new JcaPGPKeyConverter().setProvider("BC")
    )

    def pgpEncryptedDataList = pgpObjectFactory.nextObject()
    def encryptedData = pgpEncryptedDataList.next()

    def privateKeyDecryptor = new JcePBESecretKeyDecryptorBuilder().setProvider("BC").build("passphrase".toCharArray())
    def clear = encryptedData.getDataStream(new JcePGPDataDecryptorFactoryBuilder().setProvider("BC").build(privateKeyDecryptor))

    def pgpObjectFactory2 = new org.bouncycastle.openpgp.PGPObjectFactory(
            PGPUtil.getDecoderStream(clear),
            new JcaPGPKeyConverter().setProvider("BC")
    )

    def message = pgpObjectFactory2.nextObject()
    if (message instanceof org.bouncycastle.openpgp.PGPLiteralData) {
        return new String(((org.bouncycastle.openpgp.PGPLiteralData) message).getInputStream().readBytes())
    } else {
        throw new RuntimeException("Message is not a literal data packet.")
    }
}

// Load private key from a file or any other source
def privateKey = loadPrivateKeyFromFile("path/to/private.key")

// Retrieve the encrypted message from the JMeter variable
def encryptedMessage = vars.get("encryptedMessage").decodeBase64()

// Decrypt the message
def decryptedMessage = decrypt(encryptedMessage, privateKey)

// Log the decrypted message
log.info("Decrypted Message: ${decryptedMessage}")
