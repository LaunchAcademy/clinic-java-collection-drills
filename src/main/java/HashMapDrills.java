import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMapDrills {

  public static void main(String[] args) throws FileNotFoundException {
    String path = ArrayDrills.class.getResource("studentEmails.txt").getFile();
    File teacherFile = new File(path);
    Scanner scanner = new Scanner(teacherFile);

    //Create a HashMap of student names to email addresses
    Map<String, String> contacts = new HashMap<>();
    while (scanner.hasNextLine()) {
      String[] pair = scanner.nextLine().split(", ");
      contacts.put(pair[0], pair[1]);
    }
    scanner.close();
//    System.out.println(contacts);
    //list out each student's name
    Set<String> names = contacts.keySet();
    System.out.println(names);

    //using data from the above task, output all emails on file
    for (String name : names) {
      System.out.println(contacts.get(name));
    }

    //create an array list of all names that have thenorth.com in their email
    List<String> northerners = new ArrayList<>();
    final String northEmail = "thenorth.com";
    for (String name : names) {
      if (contacts.get(name).contains(northEmail)) {
        northerners.add(name);
      }
    }
    System.out.println(northerners);

    //output the northerner names
    for (String name : northerners) {
      System.out.println(name);
    }
  }
}
