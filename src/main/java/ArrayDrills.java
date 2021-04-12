import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayDrills {
  private static List<String> teachers;

  public static void main(String[] args) throws FileNotFoundException {
    String path = ArrayDrills.class.getResource("teachers.txt").getFile();
    //File teacherFile = new File(path);
    File teacherFile = new File("src/main/resources/teachers.txt");
    teachers = new ArrayList<String>();

    //read teachers from file - put it in an array list

    //list all of the teachers

    //list all of the teachers with the letter i in their name

    //output the number of teachers

    //Dan is going on sabbatical. Remove him from the teachers list

    //There's a new crew of teachers newTeachers.txt - add them to the end of the list
    //Save these peeps to a separate array. We'll need them later
    File newTeacherFile = new File("src/main/resources/newTeachers.txt");

    //Dan is back, add him to as backup to Amy Lynn Arrington

    //what index does Kincart appear on?

    //the new teachers were only temporary additions. Let's remove them

    //use a traditional for loop to output the list of teachers

    //find the teacher that shows up first in the alphabet
    //you can't use sort

  }
}
