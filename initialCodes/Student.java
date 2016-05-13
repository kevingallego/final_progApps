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


	public Student(int prelim, int midterm, int tentative) {

		this.prelim = prelim;
		this.midterm = midterm;
		this.tentative = tentative;
	}

	Scanner scan = new Scanner(System.in);

	public double getAverage() {
		average = (prelim + midterm + tentative) / 3;
		return average;
	}


	public String toString() {
		return "Prelim: " + prelim + "\n" + "Midterm: " + midterm + "\n" + "Tentative Final: " + tentative + "\n" + "Final Grade:" + getAverage() ;
	}
}