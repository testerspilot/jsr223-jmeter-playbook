import java.text.SimpleDateFormat
import java.util.Date

// Get the current timestamp in milliseconds
def timestamp = System.currentTimeMillis()

// Create a SimpleDateFormat instance with the desired date format
def dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

// Format the timestamp according to the desired format
def formattedTimestamp = dateFormat.format(new Date(timestamp))

// Set the formatted timestamp in a JMeter variable
vars.put("formattedTimestamp", formattedTimestamp)

// Log the formatted timestamp for verification
log.info("Formatted Timestamp: ${formattedTimestamp}")