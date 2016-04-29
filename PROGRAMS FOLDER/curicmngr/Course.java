import java.io.*;

public class Course implements Comparable<Course>, Serializable
{
	private String number;
	private String title;
	private int units;
	private int grade;
	private int term;
	private int yearLevel;
	private boolean taken;

	/**
	 *Constructor for Course with default value
  	 **/
	public Course()
	{
		number = "";
		title = "";
		units = 0;
		grade = 0;
		term = 0;
		yearLevel = 0;
		taken = false;
	}


	/**
	 *Constructor for Course with value from parameter but without int grade and boolean taken
	 **/
	public Course(int yearLevel, int term, String number, String title, int units)
	{
		this.number = number;
		this.title = title;
		this.units = units;
		this.term = term;
		this.yearLevel = yearLevel;
		this.grade = 0;
	}

	/**
	 *Constructor for Course with value from parameter but with int grade
	 **/
	public Course(int yearLevel, int term, String number, String title, int units, int grade)
	{
		this.number = number;
		this.title = title;
		this.units = units;
		this.term = term;
		this.yearLevel = yearLevel;
		this.grade = grade;
		this.taken = true;
	}

	/**
	 *sets the value of String number from parameter
	 **/
	public void setNumber(String number)
	{
		this.number = number;
	}

	/**
	 *sets the value of String title from parameter
	 **/
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 *sets the value of int units from parameter
	 **/
	public void setUnits(int units)
	{
		this.units = units;
	}



	/**
	 *sets the value of int yearLevel from parameter
	 **/
	public void setYearLevel(int yearLevel)
	{
		this.yearLevel = yearLevel;
	}


	/**
	 *sets the value of int term from parameter
	 **/
	public void setTerm(int term)
	{
		this.term = term;
	}



	/**
	 *sets the value of int grade from parameter
	 **/
	public void setGrade(int grade)
	{
		this.grade = grade;
		if(grade >= 75)
			this.taken = true;
	}



	/**
	 *sets the value of boolean taken from parameter
	 **/
	public void setTaken(boolean taken)
	{
		this.taken = taken;
	}


	/**
	 *returns the value of String number
	 **/
	public String getNumber()
	{
		return number;
	}

	/**
	 *returns the value of String title
	 **/
	public String getTitle()
	{
		return title;
	}

	/**
	 *returns the value of int units
	 **/
	public int getUnits()
	{
		return units;
	}

	/**
	 *returns the value of int yearLevel
	 **/
	public int getYearLevel()
	{
		return yearLevel;
	}

	/**
	 *returns the value of int term
	 **/
	public int getTerm()
	{
		return term;
	}

	/**
	 *returns the value of int grade
	 **/
	public int getGrade()
	{
		return grade;
	}

	/**
	 *returns the value of boolean taken
	 **/
	public boolean getTaken()
	{
		return taken;
	}


	/**
	 *returns the string showing a complete description of the course
	 **/
	public String toString()
	{
		return number + "\t\t" + title + "\t\t" + units + "\t" + grade;
	}


	/**
	 *Returns 0 if this Course and another course has the same
	 * string representation
	 *Returns -1 if the sttring representation of this Course
	 * is lexicographically before the string representation
	 * of another Course
	 *Returns 1 if the sttring representation of this Course
	 * is lexicographically after the string representation
	 * of another Course
	 **/
	public int compareTo(Course another)
	{
		return this.toString().compareTo(another.toString());
	}
}