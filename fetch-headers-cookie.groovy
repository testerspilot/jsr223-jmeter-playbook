// Header
log.info("-------------Retrieve Response Headers-------------------------")
def headers = prev.getResponseHeaders();
log.info(headers);
log.info("--------------------------------------")


// Cookie
def response = prev.getResponseDataAsString()

def headers = prev.getResponseHeaders()

// Check if cookies are present
if (headers.contains("Set-Cookie")) {
     log.info("Cookies found: ${cookies}")
} else {
	log.info("No Cookie Found")
}

