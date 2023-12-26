def response = prev.getResponseDataAsString()

// Perform custom assertion logic
if (!response.contains("ExpectedContent")) {
    SampleResult.setSuccessful(false)
    SampleResult.setResponseMessage("Assertion failed: Expected content not found")
}