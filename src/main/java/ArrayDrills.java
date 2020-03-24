import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayDrills {
  private static List<String> teachers;

  public static void main(String[] args) throws FileNotFoundException {
    String path = ArrayDrills.class.getResource("teachers.txt").getFile();
    File teacherFile = new File(path);
    teachers = new ArrayList<String>();

    //read teachers from file - put it in an array list
    Scanner scanner = new Scanner(teacherFile);
    while(scanner.hasNextLine()) {
      teachers.add(scanner.nextLine());
    }
    scanner.close();

    //list all of the teachers
    for(String teacher : teachers) {
      System.out.println(teacher);
    }

    //list all of the teachers with the letter i in their name
    for(String teacher : teachers) {
      if(teacher.contains("i")) {
        System.out.println(teacher);
      }
    }

    //output the number of teachers
    System.out.println(teachers.size());

    //Dan is going on sabbatical. Remove him from the teachers list
    teachers.remove("Pickett");

    //There's a new crew of teachers newTeachers.txt - add them to the end of the list
    //Save these peeps to a separate array. We'll need them later
    String newPath = ArrayDrills.class.getResource("newTeachers.txt").getFile();
    File newTeacherFile = new File(newPath);
    Scanner newScanner = new Scanner(newTeacherFile);

    List<String> newTeachers = new ArrayList<String>();
    while(newScanner.hasNextLine()) {
      String teacher = newScanner.nextLine();
      teachers.add(teacher);
      newTeachers.add(teacher);
    }

    //Dan is back, add him to as backup to Amy Lynn Arrington
    teachers.add(1, "Pickett");

    //what index does Kincart appear on?
    System.out.println(teachers.indexOf("Kincart"));

    //the new teachers were only temporary additions. Let's remove them
    teachers.removeAll(newTeachers);

    //use a traditional for loop to output the list of teachers
    for(int i = 0; i < teachers.size(); i++) {
      System.out.println(teachers.get(i));
    }

    //find the teacher that shows up first in the alphabet
    //you can't use sort
    String firstTeacher = teachers.get(0);
    for(String teacher : teachers) {
      if(teacher.compareTo(firstTeacher) < 0) {
        firstTeacher = teacher;
      }
    }
    System.out.println(firstTeacher);

  }
}
