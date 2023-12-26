import java.util.UUID

// Generate a random UUID
def uuid = UUID.randomUUID().toString()

// Set the UUID in a JMeter variable
vars.put("generatedUUID", uuid)

// Log the generated UUID for verification
log.info("Generated UUID: ${uuid}")