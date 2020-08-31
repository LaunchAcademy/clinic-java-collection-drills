import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.w3c.dom.ls.LSOutput;

public class ArrayDrills {

  private static List<String> teachers;

  public static void main(String[] args) throws FileNotFoundException {
    String path = ArrayDrills.class.getResource("teachers.txt").getFile();
    File teacherFile = new File(path);
    teachers = new ArrayList<String>();

    //read teachers from file - put it in an array list
    Scanner scanner = new Scanner(teacherFile);
    while (scanner.hasNextLine()) {
      teachers.add(scanner.nextLine());
    }
    scanner.close();

    //list all of the teachers
    for (String teacher : teachers) {
      System.out.println(teacher);
    }

    //list all of the teachers with the letter i in their name
    for (String teacher : teachers) {
      if (teacher.contains("i")) {
        System.out.println(teacher);
      }
    }

    //output the number of teachers
//    System.out.println(teachers.size());

    //Dan is going on sabbatical. Remove him from the teachers list
    teachers.remove("Pickett");
//    System.out.println(teachers);

    //There's a new crew of teachers newTeachers.txt - add them to the end of the list
    //Save these peeps to a separate array. We'll need them later
    String newTeachersPath = ArrayDrills.class.getResource("newTeachers.txt").getFile();
    File newTeachers = new File(newTeachersPath);
    Scanner newTeacherScanner = new Scanner(newTeachers);
    List<String> newTeachersList = new ArrayList<String>();

    while (newTeacherScanner.hasNextLine()) {
      String teacher = newTeacherScanner.nextLine();
      teachers.add(teacher);
      newTeachersList.add(teacher);
    }
//    System.out.println("teacher:\n" + teachers);
//    System.out.println("newTeachersList:\n " + newTeachersList);

//    Dan is back, add him to as backup to Amy Lynn Arrington
    teachers.add(teachers.indexOf("Arrington") + 1, "Pickett");
//    System.out.println(teachers);

    //what index does Kincart appear on?
//    System.out.println(teachers.indexOf("Kincart"));

    newTeachersList.add("Whelan");
    //the new teachers were only temporary additions. Let's remove them
//    System.out.println(newTeachersList);
//    System.out.println(teachers + "---\n");

    teachers.removeAll(newTeachersList);
//    System.out.println(teachers);

    //find the teacher that shows up first in the alphabet without using sort
    String firstTeacher = teachers.get(0);
    for (String teacher : teachers) {
      if (teacher.compareTo(firstTeacher) < 0) {
        firstTeacher = teacher;
      }
    }
//    System.out.println(firstTeacher);
  }

}
