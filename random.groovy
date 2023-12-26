//Generating a Random Number and Storing in a Variable:
import java.util.Random

def randomValue = new Random().nextInt(100)
vars.put("randomNumber", randomValue.toString())
