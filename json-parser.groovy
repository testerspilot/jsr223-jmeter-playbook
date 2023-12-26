import groovy.json.JsonSlurper

def response = prev.getResponseDataAsString()
def json = new JsonSlurper().parseText(response)
def value = json.keyName

vars.put("extractedValue", value)