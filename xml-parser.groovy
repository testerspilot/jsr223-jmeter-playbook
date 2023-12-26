import groovy.xml.XmlParser

def response = prev.getResponseDataAsString()
def xml = new XmlParser().parseText(response)
def value = xml.nodeName.text()

vars.put("extractedValue", value)