/**
 * @(#)Checklist.java
 *
 *
 * @author
 * @version 1.00 2015/8/28
 */

/**
 Assumptions:
 *1. A properly created datafile (checklist.txt) is existing.
 *2. The number of courses represented in the datafile is predetermined
 *
 **/
import java.io.*;
import java.util.*;
public class Course {
 private Scanner kbd = new Scanner(System.in);
 private PrintWriter outputStream;
 private String sourceFile ="checklist.txt";
 private String printFile="checklist.txt";
 private final int NUMBER_OF_COURSES=57;

 /**
 *returns an Array that is populated with course objects
 *where the course objects are constructed for the data
 *read from a text file of course details
 */
 public Course[] readData(String f){
 Course[] list = new Course[NUMBER_OF_COURSES];
 Scanner b;
 String lineOfText="";
 int index = -1;
 try {
 b = new Scanner( new File(f));
 while ( b.hasNextLine() )
 {
 index = index + 1;
 lineOfText = b.nextLine();
 String[] data = lineOfText.split(",");
 byte year = Byte.parseByte(data[0]);
 byte term = Byte.parseByte(data[1]);
 String number = data[2];
 String title = data[3];
 byte units = Byte.parseByte(data[4]);
 int grade = (int) Float.parseFloat(data[6]);
 boolean retaken = Boolean.parseBoolean(data[5]);
 list[index] = new Course(number,title,units,year,term,grade,retaken);
 }
 b.close();
 } catch ( FileNotFoundException e1 ) {
 System.out.println("File does not exist." + e1.toString());
 } catch (Exception e2){
 e2.printStackTrace();
 }
 return list;
 } // end of readData

 /**
 *displays a typical checklist where courses in an
 * Array of Course that are assigned for year
 * level y and school school term t are shown*/
 public void showChecklistPerTerm(Course[] courses, int y, int t){
 Scanner kbd = new Scanner(System.in);
 for (byte year = 1; year <=y; year++){
 for (byte term=1; term <=t; term++){
 System.out.println("------------------------------------------------------------------------------------------------------");
 System.out.println("Year = " + yearInWord(year) + " Term = " + termInWord(term));
 System.out.printf("%-13s%-55s%-6s%n","Course No", "Descriptive title", "Units");
 System.out.println("------------------------------------------------------------------------------------------------------");
 for (int index=0; index<courses.length; index++){
 if(courses[index].getYearLevel()==year && courses[index].getTerm()==term)
   System.out.printf("%-13s%-55s%-6d%n",
courses[index].getNumber(),courses[index].getTitle(),courses[index].getUnits());
 }
 System.out.println();
 System.out.println("Press enter key to see courses for the next term.");
 kbd.nextLine();
 }
 }
 } // end of showChecklistPerTerm

 /**
 *displays a checklist where courses in an Array
 *of Course that are assigned for year level y and
 *school term t with the grade for each course
 *are shown*/
 public void showChecklistPerTermWithGrades(Course[] courses, int y, int t){
 Scanner kbd = new Scanner(System.in);
 for (byte year = 1; year <=y; year++){
 for (byte term=1; term <=t; term++){
 System.out.println("------------------------------------------------------------------------------------------------");
 System.out.println("Year = " + yearInWord(year) + " Term = " + termInWord(term));
 System.out.printf("%-13s%-55s%-6s%-6s%n","Course Number", "Descriptive title", "Units", "Grade");
 System.out.println("------------------------------------------------------------------------------------------------");
 for (int index=0; index<courses.length; index++){
 if(courses[index].getYearLevel()==year && courses[index].getTerm()==term){
 System.out.printf("%-13s%-55s%-6d",
courses[index].getNumber(),courses[index].getTitle(),courses[index].getUnits());
 if (!courses[index].getTaken())
 System.out.println("Not yet taken");
 else
 System.out.printf("%-6d%n",courses[index].getGrade());
 }
 }
 System.out.println();
 System.out.println("Press enter key to see courses for the next term.");
 kbd.nextLine();
 }
 }
 } // end of showChecklistPerTermWithGrades

 /**
 *returns the index of the location of a course with a
 *given courseNumber if the course exists in an Array of Course
 *and returns -1 if a course with the given
 *courseNumber does not belong to the Array of Course
 **/
 public int isFound(Course[] courses, String courseNumber){
 // insert appropriate statements
 return -1;
 }
 /**
 *updates an Array of Course by editing the attributes
 * of a course with a given course number
   **/
 public void editCourse(Course[] courses, String courseNumber) throws Exception{
 // insert appropriate statements
 }
 /**
 *updates the Array of Course after editing the
 * grade attribute of a course with a given course
 * number
 **/
 public void enterGrade(Course[] courses, String courseNumber) throws Exception{
 // insert appropriate statements

 }

 /**
 *returns the grade point average of all courses taken.
 **/
 public double computeGPA(Course[] arrayOfCoursesTaken){
 double average=0.0;
 // insert appropriate statements
 return average;
 }
 /**
 *shows the grade point average of all courses taken.
 **/
 public void showGPA(Course[] arrayOfCoursesTaken){
 // insert appropriate statements
 }

 /**
 *returns a sorted array of Courses that were taken (i.e. with earned grades not equal to initial value)
 **/
 public Course[] sortCoursesBasedOnGrades(Course[] arrayOfCoursesTaken){

 // insert appropriate statements
 return arrayOfCoursesTaken; // sorted version

 }

 /**
 *shows a sorted array of Courses that were taken (i.e. with earned grades not equal to initial value)
 **/
 public void showSortedCoursesBasedOnGrades(Course[] sortedArrayOfCoursesTaken){

 }

 /**
 *ALGORITHM:
 * (Place algorithm here)
 */
 public void run() throws Exception {
 courses = new Course[27];
   courses = readData(sourceFile);

 int choice=0;
 while (choice != 5) {
 showMenu();
 choice = readChoice();
 switch (choice){
 case 1: showChecklistPerTerm(courses, 4,3);
 break;
 case 2:
 showChecklistPerTermWithGrades(courses, 4,3);
 break;
 case 3:
 System.out.println("..under development");
 System.out.println("Press enter to continue...");
 kbd.nextLine();
 // courses = readData(sourceFile);
 break;
 case 4:
 System.out.println("..under development");
 System.out.println("Press enter to continue...");

 break;
 case 5:
 System.out.println("..Thank you. ");
 } // end of switch
 } // end of while
 } // end of run


 /**
 *ALGORITHM:
 *(Place algorithm here)
 *
 **/
 public void showMenu(){
 System.out.println("My Checklist Management");
 System.out.println("<1> Show subjects for each school term");
 System.out.println("<2> Show subjects with grades for each term");
 System.out.println("<3> Enter grades for subjects recently finished");
 System.out.println("<4> Edit a course");
 System.out.println("<5> Quit");
 }
 /**
 *ALGORITHM:
 *Place algorithm here.
  **/
 public int readChoice(){
 int choice=0;
 Scanner kbd = new Scanner(System.in);
 while (choice!=1 && choice !=2 && choice !=3 && choice != 4 && choice !=5){
 System.out.print("Enter the number corresponding to your choice: " );
 choice = readInt();
 if (choice!=1 && choice !=2 && choice !=3 && choice != 4 && choice !=5){
 System.out.println("The choice must be a number from 1 to 5.");
 }
 }
 return choice;
 }

 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public String yearInWord(byte y){
 switch (y){
 case 1: return "First Year";
 case 2: return "Second Year";
 case 3: return "Third Year";
 case 4: return "Fourth Year";
 }
 return "Unknown year";
 }
 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public String termInWord(byte t){
 switch (t){
 case 1: return "First Semester";
 case 2: return "Second Semester";
 case 3: return "Summer";
 }
 return "Unknown year";
 }

 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public int readInt(){
 int value=0;
 boolean noProblem = true;
 do {
 try {
 value = Integer.parseInt(kbd.nextLine());
 noProblem = true;
 } catch (Exception e ){
 System.out.print("You entered an invalid datum. Please enter integer: ");
 noProblem = false;
 }
 } while (!noProblem);
 return value;
 }

 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public byte readByte(){
 byte value=0;
 boolean noProblem = true;
 do {
 try {
 value = Byte.parseByte(kbd.nextLine());
 noProblem = true;
 } catch (Exception e ){
 System.out.print("You entered an invalid value. Please enter a small whole number: ");
 noProblem = false;
 }
 } while (!noProblem);
 return value;
 }
 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public float readFloat(){
 float value=0;
 boolean noProblem = true;
 do {
 try {
 value = Float.parseFloat(kbd.nextLine());
 noProblem = true;
 } catch (Exception e ){
 System.out.print("You entered an invalid value. Please enter a number: ");
 noProblem = false;
 }
 } while (!noProblem);
return value;
 }
 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public boolean readBoolean(){
 boolean value=true;
 boolean noProblem = true;
 do {
 try {
 value = Boolean.parseBoolean(kbd.nextLine());
 noProblem = true;
 } catch (Exception e ){
 System.out.print("You entered an invalid value. Please enter a number: ");
 noProblem = false;
 }
 } while (!noProblem);
 return value;
 }
 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public void enterGrades(Course[] c) throws Exception{
 Scanner kbd = new Scanner(System.in);
 Course course=null;
 boolean moreEntry = false;
 do {
 System.out.print("Enter the course number of the course for which you will enter a grade: ");
 String n = kbd.nextLine();
 if (isCourseFound(n,c)) {
 course = getSubject(n,c);
 System.out.print("Enter the grade you earned for " + n + " : ");
 int g = Integer.parseInt(kbd.nextLine());
 course.setGrade(g);
 // writeData(sourceFile, c);
 }
 else
 System.out.println(n + " is not in your checklist. You should add the course in your checklist first.");
 System.out.print("Do you have more grades to enter?<y>es or <n>o : ");
 String answer = kbd.nextLine();
 if (Character.toUpperCase(answer.charAt(0))=='Y')
 moreEntry = true;
 else
 moreEntry = false;
 } while (moreEntry);
 	 }
 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public Course[] addACourse(Course[] c) throws Exception{
 Scanner kbd = new Scanner(System.in);
 Course[] courses= new Course[c.length];
 boolean moreEntry = false;
 do {
 System.out.print("Enter the course number of the course: ");
 String n = kbd.nextLine();
 System.out.print("Enter the descriptive title of the course: ");
 String t = kbd.nextLine();
 System.out.print("Enter the number credit units of the course: ");
 byte u = readByte();
 System.out.print("Enter the year level for the course< 1 for first year, 2 for second year, ...>: ");
 byte y = readByte();
 System.out.print("Enter the term for the course: ");
 byte term = readByte();
 System.out.print("Enter the grade for the course <enter 0 of not yet taken>: ");
 float g = readFloat();
 System.out.print("Is the subject already taken < false for no, true for yes>:");
 boolean st = readBoolean();
 System.out.print("Do you have more courses to add?<y>es or <n>o : ");
 String answer = kbd.nextLine();
 if (Character.toUpperCase(answer.charAt(0))=='Y')
 moreEntry = true;
 else
 moreEntry = false;
 } while (moreEntry);

 return courses;
 }
 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public boolean isCourseFound(String n, Course[] list){
 boolean result=false;
 for(int index=0; index<list.length; index++){
 if (list[index].getNumber().equalsIgnoreCase(n))
 result = true;
 }
 return result;
 }
  /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public int isFound(String courseNumber, Course[] list){
 for(int index=0; index<list.length; index++){
 if (list[index].getNumber().equalsIgnoreCase(courseNumber))
 return index;
 }
 return -1;
 }
 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public Course getSubject(String n, Course[] list){
 Course result= null;
 for(int index=0; index<list.length; index++){
 if (list[index].getNumber().equalsIgnoreCase(n))
 result = list[index];
 }
 return result;
 }
 /**
 *ALGORITHM:
 *Place algorithm here:
 *
 **/
 public static void main(String[] args) {
 MyChecklist1 myTry;
 try {
 myTry = new MyChecklist1();
 myTry.run();
 } catch (Exception e) {
 e.printStackTrace();
 }
 System.exit(0);
   }
  }
}
