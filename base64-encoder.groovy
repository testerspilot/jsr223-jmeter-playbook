// Base64 Encoder

// Get the previous sampler response
def plainString = prev.getResponseDataAsString();
def encodedString = plainString.bytes.encodeBase64().toString()
log.info("---------------Encode Base64-------------------")
log.info(encodedString);
log.info("----------------------------------")
