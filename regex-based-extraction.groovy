// Extracting and Summing Up Values from Multiple Responses:

def totalAmount = 0

// Extract values from response using Regular Expression
def matches = (prev.getResponseDataAsString() =~ /amount\":(\d+)/)

// Sum up the extracted values
matches.each { match ->
    totalAmount += match[1].toInteger()
}

vars.put("totalAmount", totalAmount.toString())
