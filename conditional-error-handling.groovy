if (prev.getResponseCode() != 200) {
    SampleResult.setSuccessful(false)
    SampleResult.setResponseMessage("Error: " + prev.getResponseMessage())
}