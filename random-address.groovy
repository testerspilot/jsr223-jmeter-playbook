import java.util.Random

// Function to generate a random name
def generateRandomName() {
    def names = ["John", "Alice", "Bob", "Eva", "David", "Sophia", "Michael", "Olivia", "Daniel"]
    return names[new Random().nextInt(names.size())]
}

// Function to generate a random address
def generateRandomAddress() {
    def streets = ["Main Street", "Oak Avenue", "Maple Drive", "Cedar Lane", "Pine Road"]
    def cities = ["Cityville", "Townsville", "Villagetown", "Hamletville", "Suburbia"]
    
    def randomStreet = streets[new Random().nextInt(streets.size())]
    def randomCity = cities[new Random().nextInt(cities.size())]
    
    return "${randomStreet}, ${randomCity}"
}

// Generate random name and address
def randomName = generateRandomName()
def randomAddress = generateRandomAddress()

// Set the generated values in JMeter variables
vars.put("randomName", randomName)
vars.put("randomAddress", randomAddress)

// Log the generated values for verification
log.info("Random Name: ${randomName}")
log.info("Random Address: ${randomAddress}")
