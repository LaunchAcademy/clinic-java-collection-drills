import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMapDrills {

  public static void main(String[] args) throws FileNotFoundException {
    ClassLoader classLoader = HashMapDrills.class.getClassLoader();
    File emailFile = new File(classLoader.getResource("studentEmails.txt").getFile());
    Scanner scanner = new Scanner(emailFile);

    //Create a HashMap of student names to email addresses
    Map<String, String> contactInformation = new HashMap<>();
    while(scanner.hasNextLine()) {
      String contact = scanner.nextLine();
      String[] pair = contact.split(", ");
      String name = pair[0];
      String email = pair[1];
      contactInformation.put(name, email);
    }
    System.out.println(contactInformation);

    //list out each student's name
    Set<String> names = contactInformation.keySet();
    System.out.println("---");
    System.out.println("All names:");
    System.out.println(names);
    for(String name : names) {
      System.out.println("- " + name);
    }


    //using data from the above task, output all emails on file
    System.out.println("All emails");
    for(String name : names) {
      System.out.println("- " + contactInformation.get(name));
    }

    Collection<String> emails = contactInformation.values();
    for(String email : emails) {
      System.out.println("* " + email);
    }

    //create an array list of all names that have thenorth.com in their email
    // create an array list
    List<String> namesOfTheNorth = new ArrayList<>();
    // one option: iterate through using keys
    for(String name : names) {
      // check if the email matching this name includes "thenorth.com"
      if(contactInformation.get(name).contains("thenorth.com")) {
        namesOfTheNorth.add(name);
      }
    }
    System.out.println("---");
    System.out.println("Names of the North");
    System.out.println(namesOfTheNorth);
    System.out.println("---");
    // second option: iterate through using Map.Entry
    List<String> secondNamesOfTheNorth = new ArrayList<>();
    System.out.println(contactInformation.entrySet());
    for(Map.Entry<String, String> contactPair : contactInformation.entrySet()) {
      String name = contactPair.getKey();
      String email = contactPair.getValue();
      if(email.contains("thenorth.com")) {
        secondNamesOfTheNorth.add(name);
      }
    }
    System.out.println("Second Names of the North");
    System.out.println(secondNamesOfTheNorth);




    //output the northerner names
    for(String name : secondNamesOfTheNorth) {
      System.out.println("- " + name);
    }
  }
}
