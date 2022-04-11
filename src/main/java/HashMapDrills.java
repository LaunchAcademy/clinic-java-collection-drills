import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMapDrills {

  private static File getFileByName(String fileName) {
    String path = HashMapDrills.class.getResource(fileName).getFile();
    return new File(path);
  }

  public static void main(String[] args) throws FileNotFoundException {
    File contactsFile = getFileByName("studentEmails.txt");
    Scanner contactScanner = new Scanner(contactsFile);
    Map<String, String> contactInfo = new HashMap<>();

    System.out.println("\n--- Read in lines from studentEmails.txt and store them in a hashmap with the name as the key ---");
    while(contactScanner.hasNextLine()) {
      String currentLine = contactScanner.nextLine();
      String[] pair = currentLine.split(", ");
      contactInfo.put(pair[0], pair[1]);
    }
    System.out.println(contactInfo);

    System.out.println("\n--- Print out each student's name line by line ---");
    Set<String> keys = contactInfo.keySet();

    for(String key : keys) {
      System.out.println(key);
    }

    System.out.println("\n--- Print out each student's email using the keyset above ---");
    for(String key : keys) {
      System.out.println(contactInfo.get(key));
    }

    System.out.println("\n--- Create a list of all names that have thenorth.com in their email ---");
    for(String key : keys) {
      if(contactInfo.get(key).contains("thenorth.com")){
        System.out.println(key);
      }

    }

    System.out.println("\n--- Print out the northeners line by line ---");

  }
}
