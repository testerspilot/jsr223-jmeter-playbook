import java.text.SimpleDateFormat
import java.util.Date

// Get the current timestamp in milliseconds
def timestamp = System.currentTimeMillis()

// Create a Date object
def currentDate = new Date(timestamp)

// Format the date in "YYYY-MM-DD" format
def dateFormat1 = new SimpleDateFormat("yyyy-MM-dd")
def formattedDate1 = dateFormat1.format(currentDate)
vars.put("formattedDate1", formattedDate1)

// Format the date in "DD-MM-YYYY" format
def dateFormat2 = new SimpleDateFormat("dd-MM-yyyy")
def formattedDate2 = dateFormat2.format(currentDate)
vars.put("formattedDate2", formattedDate2)

// Format the date in "DDMMYYYY" format
def dateFormat3 = new SimpleDateFormat("ddMMyyyy")
def formattedDate3 = dateFormat3.format(currentDate)
vars.put("formattedDate3", formattedDate3)

// Log the formatted dates for verification
log.info("Formatted Date (YYYY-MM-DD): ${formattedDate1}")
log.info("Formatted Date (DD-MM-YYYY): ${formattedDate2}")
log.info("Formatted Date (DDMMYYYY): ${formattedDate3}")
