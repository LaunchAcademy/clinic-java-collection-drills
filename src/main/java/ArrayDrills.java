import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayDrills {

  private static File getFileByName(String fileName) {
    String path = ArrayDrills.class.getResource(fileName).getFile();
    return new File(path);
  }

  public static void main(String[] args) throws FileNotFoundException {

    System.out.println("\n--- Read in teachers from teachers.txt and store them in a new list ---");
    File teachersFile = getFileByName("teachers.txt");
    Scanner teacherScanner = new Scanner(teachersFile);

    List<String> teachers = new ArrayList<>();
    while(teacherScanner.hasNextLine()) {
      teachers.add(teacherScanner.nextLine());
    }
    teacherScanner.close();
    System.out.println(teachers);

    System.out.println("\n--- List all of the teachers one at a time---");
    for(String name : teachers) {
      System.out.println(name);
    }

    System.out.println("\n--- List all teachers with an 'i' in their name ---");
    for(String name : teachers) {
      if(name.contains("i") || name.contains("I")){
        System.out.println(name);
      }
    }


    System.out.println("\n--- How many teachers are there? ---");
    System.out.println(teachers.size());


    System.out.println("\n--- Remove Dan Pickett from the teachers list so he can take a vacation ---");
    int pickettIndex = teachers.indexOf("Pickett");
    String teacherRemoved = teachers.remove(pickettIndex);
    System.out.println(teacherRemoved);

    System.out.println("\n--- Read in new teachers from newTeacher.txt and store them in a new list ---");
    File newTeachersFile = getFileByName("newTeachers.txt");
    Scanner newTeacherScanner = new Scanner(newTeachersFile);


    System.out.println("\n--- Add the newTeachers to the existing teachers list ---");
    List<String> newTeachers = new ArrayList<>();

    while(newTeacherScanner.hasNextLine()) {
      newTeachers.add(newTeacherScanner.nextLine());
    }
    System.out.println(newTeachers);

    teachers.addAll(newTeachers);
//    for(String newTeacher: newTeachers) {
//      teachers.add(newTeacher);
//    }
    System.out.println(teachers);

    System.out.println("\n--- Add Pickett back into the list after Arrington ---");
    int indexOfArrington = teachers.indexOf("Arrington");
    teachers.add(indexOfArrington + 1, "Pickett");
    System.out.println(teachers);

    System.out.println("\n--- Index of Kincart ---");
    int indexOfKincart = teachers.indexOf("Kincart");
    System.out.println(indexOfKincart);

    System.out.println("\n--- Remove the new teachers from the teachers arraylist---");
    for(String teacher : newTeachers) {
      teachers.remove(teacher);
    }
    //teachers.removeAll(newTeachers);
    System.out.println(teachers);

    System.out.println("\n--- Use a traditional for loop to output the list of teachers ---");
    for(int i = 0 ; i < teachers.size() ; i++) {
      System.out.println(teachers.get(i));
    }


    System.out.println("\n--- First teacher alphabetically without sort ---");
    String firstTeacher = teachers.get(0);
    for(String teacher : teachers) {
      if(teacher.compareTo(firstTeacher) < 0){
        firstTeacher = teacher;
      }
    }

    System.out.println(firstTeacher);
  }
}
