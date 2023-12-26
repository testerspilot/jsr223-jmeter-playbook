import org.bouncycastle.openpgp.PGPPublicKey
import org.bouncycastle.openpgp.PGPPublicKeyRing
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection
import org.bouncycastle.openpgp.PGPUtil
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPEncryptorBuilder
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder

def encrypt(String plaintext, PGPPublicKey publicKey) {
    def byteArrayOutputStream = new java.io.ByteArrayOutputStream()
    def armoredOutputStream = new org.bouncycastle.openpgp.PGPEncryptedDataGenerator(
            new JcaPGPEncryptorBuilder(PGPEncryptedDataGenerator.CAST5).setProvider("BC")
    ).open(byteArrayOutputStream, new byte[4096])

    def compressedDataGenerator = new org.bouncycastle.openpgp.PGPCompressedDataGenerator(
            org.bouncycastle.openpgp.PGPCompressedData.ZIP
    )
    def compressedOutputStream = compressedDataGenerator.open(armoredOutputStream)

    def pgpObjectFactory = new org.bouncycastle.openpgp.PGPOnePassSignatureList(
            PGPUtil.getDecoderStream(new java.io.ByteArrayInputStream(publicKey.getEncoded()))
    ).iterator().next()

    def bcpgOutputStream = new org.bouncycastle.bcpg.BCPGOutputStream(compressedOutputStream)
    def literalDataGenerator = new org.bouncycastle.openpgp.PGPLiteralDataGenerator()
    def literalOutputStream = literalDataGenerator.open(bcpgOutputStream,
            PGPLiteralData.BINARY, "_CONSOLE", plaintext.getBytes(), 0, plaintext.length()
    )
    literalOutputStream.close()

    compressedDataGenerator.close()

    def signature = new org.bouncycastle.openpgp.PGPSignatureGenerator(
            new JcaPGPContentSignerBuilder(pgpObjectFactory.getSignature().getHashAlgorithm(), PGPUtil.SHA256)
    )
    signature.init(org.bouncycastle.openpgp.PGPSignature.BINARY_DOCUMENT, privateKeyRing.getSecretKey().extractPrivateKey(
            new JcePBESecretKeyDecryptorBuilder().setProvider("BC").build("passphrase".toCharArray())
    ))
    signature.generate().encode(compressedOutputStream)

    compressedOutputStream.close()
    armoredOutputStream.close()
    byteArrayOutputStream.toByteArray()
}

// Load public key from a file or any other source
def publicKey = loadPublicKeyFromFile("path/to/public.key")

// Input plaintext message
def plaintextMessage = "Hello, this is a secret message!"

// Encrypt the message
def encryptedMessage = encrypt(plaintextMessage, publicKey)

// Set the encrypted message to a JMeter variable for further use
vars.put("encryptedMessage", encryptedMessage.encodeBase64().toString())
