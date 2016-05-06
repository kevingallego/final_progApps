//	Student.java
//
//	Define a student class that stores name, score on test 1, and
//	score on test 2.	Methods prompt for and read in grades,
//	compute the average, and return a string containing student's info.
// ************************************************************

import java.util.Scanner;

public class Student {

	//declare instance data
	private int prelim, midterm, tentative;
	private double average;


	// ---------------------------------------------
	//constructor
	// ---------------------------------------------
		public Student() {
		//add body of constructor
		this.prelim = 0 ;
		this.midterm = 0;
		this.tentative = 0;
		}

	public Student(int prelim, int midterm, int tentative) {
		//add body of constructor
		this.prelim = prelim;
		this.midterm = midterm;
		this.tentative = tentative;
	}

	// ---------------------------------------------
	//inputGrades: prompt for and read in student's grades for test1 and test2.
	//Use name in prompts, e.g., "Enter's Joe's score for test1".
	// ---------------------------------------------
	Scanner scan = new Scanner(System.in);

	public void inputGrades() {
		//add body of inputGrades
		System.out.print("Enter PRELIM grade: ");
   		prelim = scan.nextInt();

		System.out.print("Enter MIDETERM grade: ");
    	midterm = scan.nextInt();

    	System.out.print("Enter TENTATIVE FINAL grade: ");
    	tentative = scan.nextInt();
	}

	// ---------------------------------------------
	//getAverage: compute and return the student's test average
	// ---------------------------------------------

	//add header for getAverage
	public double getAverage() {
		//add body of getAverage
		return average = (double)(prelim + midterm + tentative) / 3;
	}



	// to string method
	public String toString() {
		return "Prelim: " + prelim + "\n" + "Midterm: " + midterm + "\n" + "Tentative Final: " + tentative + "\n" + "Final Grade: " + getAverage();
	}
}