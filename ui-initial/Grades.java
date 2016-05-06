// ************************************************************
//	Grades.java
//
//	Use Student class to get test grades for two students
//	and compute averages
//
// ************************************************************
import java.util.*;

public class Grades {

	//int enterprelim, entermidterm, enterfinal;

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		Student student = new Student();
	/*	enterprelim = kbd.nextInt();
	/	entermidterm = kbd.nextInt();
		enterfinal = kbd.nextInt();

		Student prelim = new Student(enterprelim);
		Student midterm = new Student(entermidterm);
		Student tentative = new Student(enterfinal);
*/
		System.out.println("----------------------------------------------------");

	//input grades for Mary
	student.inputGrades();
	student.getAverage();
	student.toString();
	}
}