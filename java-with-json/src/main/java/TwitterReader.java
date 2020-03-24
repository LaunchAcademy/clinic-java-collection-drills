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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import java.io.File;

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

    JsonFactory jsonF = new JsonFactory();
    JsonGenerator jg = jsonF.createGenerator(new File("result.json"), JsonEncoding.UTF8);

// enable indentation just to make debug/testing easier
    jg.useDefaultPrettyPrinter();
    jg.writeStartObject();
    // can either do "jg.writeFieldName(...) + jg.writeNumber()", or this:
    jg.writeNumberField("id", 1125687997);
    jg.writeStringField("text", "@stroughtonsmith You need to add a \"Favorites\" tab to TC/iPhone. Like what TwitterFon did. I can't WAIT for your Twitter App!! :) Any ETA?");
    jg.writeNumberField("fromUserId", 855523);
    jg.writeNumberField("toUserId", 815309);
    jg.writeStringField("langugeCode", "en");
    jg.writeEndObject();
    jg.useDefaultPrettyPrinter();
    jg.close();

  }
}

