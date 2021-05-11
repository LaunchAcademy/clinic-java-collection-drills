import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayDrills {
  private static List<String> teachers;

  public static void main(String[] args) throws FileNotFoundException {
    String path = ArrayDrills.class.getResource("teachers.txt").getFile();
//    System.out.println(path);
    File teacherFile = new File(path);
    teachers = new ArrayList<String>();

    Scanner fileScanner = new Scanner(teacherFile);

    //read teachers from file - put it in an array list
    while(fileScanner.hasNextLine()) {
      teachers.add(fileScanner.nextLine());
    }
    fileScanner.close();

    System.out.println(teachers);

    //list all of the teachers
    System.out.println("---");
    System.out.println("All teachers");
    printTeachers();

    //list all of the teachers with the letter i in their name
    System.out.println("---");
    System.out.println("Teachers with the letter 'i'");
    for(String teacher : teachers) {
      if(teacher.contains("i")) {
        System.out.println("- " + teacher);
      }
    }

    //output the number of teachers
    System.out.println("---");
    System.out.println("Number of teachers:");
    System.out.println(teachers.size());

    //Dan is going on sabbatical. Remove him from the teachers list
    System.out.println("---");
    System.out.println("Remove Dan");
    teachers.remove("Pickett");
    printTeachers();

    //There's a new crew of teachers newTeachers.txt - add them to the end of the list
    //Save these peeps to a separate array. We'll need them later
    // set up a new array for only the new teachers
    List<String> newTeachers = new ArrayList<>();
    // read the `newTeachers.txt` file and add each teacher to BOTH
    // the original array of teachers (at the end) and the array of new teachers
    String newTeacherPath = ArrayDrills.class.getResource("newTeachers.txt").getFile();
//    System.out.println(path);
    File newTeacherFile = new File(newTeacherPath);
    Scanner newScanner = new Scanner(newTeacherFile);

    while(newScanner.hasNextLine()) {
      // we can't do this, because each `nextLine` call moves forward in the file
      // instead, we need to call nextLine ONCE and then add that single string into both arrays
//      newTeachers.add(newScanner.nextLine());
//      teachers.add(newScanner.nextLine());

      String nextTeacher = newScanner.nextLine();

      newTeachers.add(nextTeacher);
      teachers.add(nextTeacher);
    }
    System.out.println(newTeachers);
    System.out.println(teachers);

    //Dan is back, add him back in directly after AmyLynn Arrington
    System.out.println("---");
    System.out.println("Add Dan after Arrington");

    // this is, in a way, hardcoded because it's assuming Arrington is always at the beginning of our array
//    teachers.add(1, "Pickett");
    // it is better to use `indexOf` to FIND Arrington
    // And then add Pickett afterwards
    int arringtonIndex = teachers.indexOf("Arrington");
    teachers.add(arringtonIndex + 1, "Pickett");
    printTeachers();

    //what index does Kincart appear on?
    System.out.println("---");
    System.out.println("Index of Kincart");
    System.out.println(teachers.indexOf("Kincart"));

    //the new teachers were only temporary additions. Let's remove them
    System.out.println("---");
    System.out.println("Remove new teachers");
    // we want to take anyone in `newTeachers` and
    // remove them from our `teachers` array

    // option 1
    // loop through all of the `newTeachers` that we want to remove
    // and remove them one by one
//    for(String newTeacher : newTeachers) {
//      teachers.remove(newTeacher);
//    }

    // option 2
    // we have the `removeAll` method which allows us to hand in
    // an ArrayList
    teachers.removeAll(newTeachers);
    printTeachers();

    //use a traditional for loop to output the list of teachers
    for(int index=0; index < teachers.size(); index++) {
      System.out.println(teachers.get(index));
    }

    //find the teacher that shows up first in the alphabet
    //you can't use sort

    String firstTeacher = teachers.get(0);
    // loop through the teachers, see if the next one is first, alphabetically, and continue until you've compared all teachers
    for(String teacher : teachers) {
      // if the teacher comes first, make that our `firstTeacher`
      if(teacher.compareTo(firstTeacher) < 0) {
        firstTeacher = teacher;
      }
      // then, keep looping
    }
    System.out.println("---");
    System.out.println("The first alphabetical teacher");
    System.out.println(firstTeacher);

  }

  private static void printTeachers() {
    for(String teacher : teachers) {
      System.out.println("- " + teacher);
    }
  }
}
