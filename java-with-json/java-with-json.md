JavaScript Object Notation (JSON) is the format of choice for data on the web. When we connect to web-based Application Programming Interfaces (API's), we're often communicating with JSON.

So, to be an effective software developer, we must know how to both read and write JSON. So, we'll explore that together in this article.

## Learning Goals

- Read a JSON file using Java and the Jackson Parser
- Write a JSON file using Java and the Jackson Parser
- Aggregate the results from a JSON payload

## Jackson parser

Java core does not contain objects and methods to support our effort of parsing JSON. So, most Java developers use a third party implementation for its JSON support.

### Add Jackson to Your Project

Navigate to [Jackson's Core MVN Artifact Page][jackson-artifact] and download the latest Jar. In a previous article, we showed you how to integrate Jars into an existing codebase. Follow that process so that you can begin to make use of the library.

### Working with the Jackson Library

Jackson has two ways of approaching JSON. It can use either a parser or object map. We will dig into both options.

The Jackson _parser_ is created by a **factory**. To create the parser, create the factory, then call the createParser() function.

```Java
File jsonFile = new File("input.json");
JsonFactory factory = new JsonFactory();
JsonParser parser = factory.createParser(jsonFile);
```

This will create the _parser_ and associate a file and parse it into tokens. You can assign the token to your object.

Let's take a look at our `input.json` file. It has the following JSON:

```json
{
  "id": 1125687077,
  "text": "@stroughtonsmith You need to add a \"Favorites\" tab to TC/iPhone. Like what TwitterFon did. I can't WAIT for your Twitter App!! :) Any ETA?",
  "fromUserId": 855523,
  "toUserId": 815309,
  "languageCode": "en"
}
```

```Java
File jsonFile = new File("input.json");
JsonFactory factory = new JsonFactory();
JsonParser parser = factory.createParser(jsonFile);

//skip past the beginning `{`
parser.nextToken();
while(parser.nextToken() != JsonToken.END_OBJECT) {
  System.out.println(parser.getCurrentName());
}
```

You can think of the parser like a cursor. It processes the file sequentially starting with the `{` that starts our JSON. When we call `nextToken()` we advance the cursor to the next item of interest. In the case of the second token it, it will be the `"id"` property.

If we run the code above, we'll see that each property is outputted twice. That's because the property itself is a token, and its respective value is another.

So, let's refine our approach a bit further:

```Java
File jsonFile = new File("input.json");
JsonFactory factory = new JsonFactory();
JsonParser parser = factory.createParser(jsonFile);

//skip past the beginning `{`
parser.nextToken();

//loop until we encounter the terminating `}`
while(parser.nextToken() !=  JsonToken.END_OBJECT) {
  String field = parser.getCurrentName();

  //advance to the next "token", which is the value
  JsonToken value = parser.nextToken();

  //output the combination of the field and the value
  System.out.println(field + ":" + parser.getText());
}
```

This is great if our value is always a string. Even in our simple example, though, we have three numbers. Thankfully, Jackson has a tool to help us.

```java
File jsonFile = new File("input.json");
JsonFactory factory = new JsonFactory();
JsonParser parser = factory.createParser(jsonFile);

//skip past the beginning `{`
parser.nextToken();

//loop until we encounter the terminating `}`
while(parser.nextToken() !=  JsonToken.END_OBJECT) {
  String field = parser.getCurrentName();

  //advance to the next "token", which is the value
  JsonToken value = parser.nextToken();

  //output the combination of the field and the value
  if(value.isNumeric()) {
    System.out.println(field + " (number): "  + parser.getLongValue());
  }
  else {
    System.out.println(field + ":" + parser.getText());
  }
}
```

## Jackson Object Mapper

The solution discussed above is a fairly painful way of getting the JSON into a workable Java data structure. Thankfully, Jackson provides an easier way. In order to make it work, we will need to load the [DataMapper Jar][datamapper-jar] and the [Annotations Jar][annotations-jar] into our codebase the same way we did for Jackson Core.

Once installed and configured, we can use an [ObjectMapper](https://fasterxml.github.io/jackson-databind/javadoc/2.9/com/fasterxml/jackson/databind/ObjectMapper.html). You can pass in a _Map_ or a Plain Old Java Object (_POJO_). The _readValue()_ and _writeValue()_ will pull the properties out of the object and populate the map.

```Java
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class TwitterReader {

  public static void main(String[] args) throws IOException {
    try {
      //read in the file
      byte[] mapData = Files.readAllBytes(Paths.get("input.json"));

      //instantiate the `Map` that will hold the keys and values
      Map myMap = new HashMap<String, String>();

      //instantiate the object mapper with helpful indentation
      ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

      //populate the HashMap with the JSON contents
      myMap = objectMapper.readValue(mapData, HashMap.class);

      //output the map
      System.out.println("Map is: " + myMap);
    } catch (IOException io ) {
      io.printStackTrace();
    }
  }
}
```

### ObjectMapper enable output format

You can call _enable(SerializationFeature.INDENT_OUTPUT)_ to enable the "pretty print" option for objectMapper. _SerializationFeature.INDENT_OUTPUT_ is a constant used to indicate the indentation that you see with pretty printing. This will make any resulting JSON we write easy on the eyes.

## Dealing with Arrays of JSON

Often, JSON payloads are in the form of an `Array`. So, if we wanted to read multiple tweets for example, we could build an `ArrayList` of `HashMap` instances:

```java
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterReader {

  public static void main(String[] args) throws IOException {
    try {
      //read in the file
      byte[] mapData = Files.readAllBytes(Paths.get("tweets.json"));

      //instantiate the `Map` that will hold the keys and values
      List<HashMap<String, String>> tweets = new ArrayList<HashMap<String, String>>();

      //instantiate the object mapper with helpful indentation
      ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

      //populate the HashMap with the JSON contents
      tweets = objectMapper.readValue(mapData, ArrayList.class);

      //output the map
      System.out.println("List is: " + tweets);
    } catch (IOException io ) {
      io.printStackTrace();
    }
  }
}
```

The concept is the same. What we map to the `objectMapper` is different. In this case we map to an `ArrayList` that has `HashMap` elements.

## Jackson Generator

Jackson has a class called [JsonGenerator](https://fasterxml.github.io/jackson-core/javadoc/2.8/com/fasterxml/jackson/core/JsonGenerator.html?is-external=true). It is used to create JSON. When you instantiate the generator, you supply a `File`, `OutputStream`, or `Writer` (in this case, we are using a file). As we start writing, we add the _Start Object_ the go through the properties. At the end, we close the generator.

```Java
JsonGenerator jg = jsonF.createGenerator(new File("result.json"), JsonEncoding.UTF8);

// enable indentation just to make debug/testing easier
jg.useDefaultPrettyPrinter();
jg.writeStartObject();
// can either do "jg.writeFieldName(...) + jg.writeNumber()", or this:
jg.writeNumberField("id", 1125687077);
jg.writeStringField("text", "@stroughtonsmith You need to add a \"Favorites\" tab to TC/iPhone. Like what TwitterFon did. I can't WAIT for your Twitter App!! :) Any ETA?");
jg.writeNumberField("fromUserId", 855523);
jg.writeNumberField("toUserId", 815309));
jg.writeStringField("langugeCode", "en");
jg.writeEndObject();
jg.close();
```

### Generator useDefaultPrettyPrinter

You can include a call to _useDefaultPrettyPrinter()_ to format the output with indentation. It is good for debugging or looking at the output.

[jackson-artifact]: https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
[datamapper-jar]: https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
[annotations-jar]: https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations
