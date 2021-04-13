import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ArrayDrills {
  private static List<String> teachers;

  public static void main(String[] args) throws FileNotFoundException {
    String path = ArrayDrills.class.getResource("teachers.txt").getFile();
    //File teacherFile = new File(path);
    File teacherFile = new File("src/main/resources/teachers.txt");
    teachers = new ArrayList<String>();

    //read teachers from file - put it in an array list
    Scanner teacherScan = new Scanner(teacherFile);
    while(teacherScan.hasNextLine()) {
      teachers.add(teacherScan.nextLine());
    }

    teacherScan.close();

    //list all of the teachers
    for(String teacher : teachers) {
      System.out.println(teacher);
    }

    System.out.println("============");

    //list all of the teachers with the letter i in their name
    for(String teacher : teachers) {
      if(teacher.toLowerCase().contains("i")) {
        System.out.println(teacher);
      }
    }

    //output the number of teachers
    System.out.println("Number of teachers: " + teachers.size());

    //"Pickett" is going on sabbatical. Remove him from the teachers list
    teachers.remove("Pickett");
    System.out.println("Number of teachers after removal: " + teachers.size());

    System.out.println("====================");
    //There's a new crew of teachers newTeachers.txt - add them to the end of the list
    //Save these peeps to a separate array. We'll need them later
    File newTeacherFile = new File("src/main/resources/newTeachers.txt");
    List<String> newTeachers = new ArrayList<String>();

    teacherScan = new Scanner(newTeacherFile);
    while(teacherScan.hasNextLine()) {
      String newTeacherInput = teacherScan.nextLine();
      teachers.add(newTeacherInput);
      newTeachers.add(newTeacherInput);
    }

    teacherScan.close();

    for(String teacher : teachers) {
      System.out.println("old teacher list: " + teacher);
    }

    for(String newTeacher : newTeachers) {
      System.out.println("new teacher list: " + newTeacher);
    }

    System.out.println("==================");

    //Dan is back, add him to as backup to Amy Lynn Arrington
    int indexOfArrington = teachers.indexOf("Arrington");
    if(indexOfArrington > -1) {
      teachers.add(indexOfArrington+1, "Pickett");
    }

    printTeachers(teachers);

    //what index does "Kincart" appear on?
    System.out.println(teachers.indexOf("Kincart"));

    //the new teachers were only temporary additions. Let's remove them from the teachers list
//    for(String currentTeacher : newTeachers){
//      if(teachers.contains(currentTeacher)){
//        teachers.remove(currentTeacher);
//      }
//    }
    teachers.removeAll(newTeachers);

    printTeachers(teachers);

    //use a traditional for loop to output the list of teachers
    for(int i = 0; i < teachers.size(); i++){
      System.out.println(teachers.get(i));
    }

    //find the teacher that shows up first in the alphabet
    //you can't use sort
    String firstTeacher = teachers.get(0);

    for(String teacher: teachers){
        if(firstTeacher.compareTo(teacher) > 0) {
          firstTeacher = teacher;
        }

    }
    System.out.println(firstTeacher);
  }

  private static void printTeachers(List<String> data){
    System.out.println("====================");
    for(String teacher : data) {
      System.out.println("old teacher list: " + teacher);
    }
  }
}
