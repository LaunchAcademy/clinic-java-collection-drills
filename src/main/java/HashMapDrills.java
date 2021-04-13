import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMapDrills {

  public static void main(String[] args) throws FileNotFoundException {
    String path = ArrayDrills.class.getResource("studentEmails.txt").getFile();
    //File teacherFile = new File(path);
    File teacherFile = new File("src/main/resources/studentEmails.txt");
    Scanner scanner = new Scanner(teacherFile);

    Map<String, String> studentMap = new HashMap<String, String>();

    //Create a HashMap of student names to email addresses
    while(scanner.hasNextLine()) {
      String nextLine = scanner.nextLine();
      String[] splitData = nextLine.split(", ");
      studentMap.put(splitData[0], splitData[1]);
    }

    scanner.close();
    System.out.println( studentMap );

    //list out each student's name
    Set<String> names = studentMap.keySet();
    studentMap.values();
    System.out.println(names);

    System.out.println("========");
    //using data from the above task, output all emails on file
    //for(String name : studentMap.keySet())
    for(String name : studentMap.values()) {
      //System.out.println(studentMap.get(name));
      System.out.println(name);
    }

    System.out.println(studentMap.values());
    //create an array list of all names that have thenorth.com in their email
    List<String> theNorth = new ArrayList<String>();
    String north = "thenorth.com";

    for(String email : studentMap.values()) {
      if(email.contains(north)){
        theNorth.add(email);
      }
    }

    System.out.println(theNorth);
    //output the northerner names
    for(Map.Entry<String, String> nameEmail : studentMap.entrySet()) {
      if (nameEmail.getValue().contains(north)) {
        System.out.println(nameEmail.getKey());
      }
    }
  }
}
