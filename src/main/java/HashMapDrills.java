import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashMapDrills {

  public static void main(String[] args) throws FileNotFoundException {
    String path = ArrayDrills.class.getResource("studentEmails.txt").getFile();
    File teacherFile = new File(path);
    Scanner scanner = new Scanner(teacherFile);

    //Create a HashMap of student names to email addresses


    //list out each student's name


    //using data from the above task, output all emails on file


    //create an array list of all names that have thenorth.com in their email


    //output the northerner names

  }
}
