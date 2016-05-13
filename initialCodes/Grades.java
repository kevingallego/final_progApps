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
		int prelimg, midtermg, finalg;
		Scanner kbd = new Scanner(System.in);
		System.out.println("----------------------------------------------------");
		System.out.print("prelim grade : ");
		prelimg = kbd.nextInt();
		System.out.print("midterm grade : ");
		midtermg =kbd.nextInt();
		System.out.print("final grade : ");
		finalg =kbd.nextInt();

		Student student = new Student(prelimg, midtermg, finalg);

		System.out.println("average : " + student.getAverage());
		System.out.println("=================================" );

		System.out.println(student.toString());

		System.out.println("----------------------------------------------------");
	/*	enterprelim = kbd.nextInt();
	/	entermidterm = kbd.nextInt();
		enterfinal = kbd.nextInt();

		Student prelim = new Student(enterprelim);
		Student midterm = new Student(entermidterm);
		Student tentative = new Student(enterfinal);
*/

/*
	//input grades for Mary
	student.inputGrades();

*/

	}
}