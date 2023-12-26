import java.util.Random

// Get a list of dynamic values from a file or database
def dynamicValues = ["value1", "value2", "value3"]

// Select a random value from the list
def randomValue = dynamicValues[new Random().nextInt(dynamicValues.size())]

// Update the request parameter with the selected value
sampler.getArguments().getArgument(0).setValue(randomValue)