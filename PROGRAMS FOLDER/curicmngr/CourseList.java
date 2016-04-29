import java.io.*;
import java.util.*;

public class CourseList extends CurriculumManager
{
	private Scanner kbd = new Scanner(System.in);
	private String sourceFile = "checklist.txt";
	private String printFile = "checklist.dat";
	private int NUMBER_OF_COURSES;
	
	/**
	 *returns a LinkedList that is populated with course objects
	 *where the course objects are constructed for the data
	 *read from a text file of course details
	 */

	 public LinkedList<Course> readData(String f)
	 {
	 	LinkedList<Course> list = new LinkedList<Course>();
	 		Scanner b;
	 		String lineOfText = "";
	 		int index = 0;
	 		File g = new File(printFile);
	 		if(g.isFile())
	 		{
	 			try
	 			{
	 				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(printFile));
	 				while(true)
	 				{
					 	list.add((Course) ois.readObject());
					 	index++;
					 	NUMBER_OF_COURSES = index;
	 				}
	 				
	 			}
	 			catch(FileNotFoundException e1)
			 	{
			 		System.out.println("File does not exist. " + e1.toString());
			 	}
	 			catch(EOFException e)
	 			{
	 				return list;
	 			}
	 			catch(Exception e2)
			 	{
			 		e2.printStackTrace();
			 	}
	 		}
	 		else
	 		{
	 			try
		 		{
			 		b = new Scanner(new File(f));
			 		while(b.hasNextLine())
			 		{
				 		lineOfText = b.nextLine();
				 		String[]data = lineOfText.split(",");
				 		int year = Integer.parseInt(data[0]);
				 		int term = Integer.parseInt(data[1]);
				 		String number = data[2];
				 		String title = data[3];
				 		int units = Integer.parseInt(data[4]);
				 		list.add(index, new Course(year,term,number,title,units));
				 		index++;
			 		}
			 		NUMBER_OF_COURSES = index;
			 		b.close();
		 		}
		 		catch(FileNotFoundException e1)
		 		{
		 			System.out.println("File does not exist. " + e1.toString());
		 		}
		 		catch(Exception e2)
		 		{
		 			e2.printStackTrace();
		 		}
	 		}

	 		
	 		return list;
	 }//end of readData

	 /**
	  *displays a typical checklist where courses in an
 	  *Array of Course that are assigned for year
 	  *level y and school school term t are shown*/
 	  public void showChecklistPerTerm(int y, int t)
 	  {
 	  	for(int year = 1; year <= y; year++)
 	  	{
 	  		for(int term = 1; term <= t; term++)
 	  		{
 	  			System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("Year = " + yearInWord(year) + " Term = " + termInWord(term));
				System.out.printf("%-13s%-55s%-6s%n","Course No", "Descriptive title", "Units");
				System.out.println("------------------------------------------------------------------------------------------------------");

				for(int index = 0; index < courses.size(); index++)
				{
					if(courses.get(index).getYearLevel() == year && courses.get(index).getTerm() == term)
					{
						System.out.printf("%-13s%-55s%-6d",
						courses.get(index).getNumber(),courses.get(index).getTitle(),courses.get(index).getUnits());
						System.out.println();
					}
				}
				System.out.println();
				System.out.println("Press enter key to see courses for the next term.");
				kbd.nextLine();
 	  		}
 	  	}
 	  }
 	  //end of showCheckListPerTerm

 	  /**
 	   *displays a checklist where courses in an Array
 	   *of Course that are assigned for year level y and
 	   *school term t with the grade for each course
 	   *are shown*/
 	  public void showChecklistPerTermWithGrades(int y, int t)
 	  {
 	  	for(int year = 1; year <= y; year++)
 	  	{
 	  		for(int term = 1; term <= t; term++)
 	  		{
 	  			System.out.println("------------------------------------------------------------------------------------------------");
				System.out.println("Year = " + yearInWord(year) + " Term = " + termInWord(term));
				System.out.printf("%-13s%-55s%-6s%-6s%n","Course Number", "Descriptive title", "Units", "Grade");
				System.out.println("------------------------------------------------------------------------------------------------");
				for(int index = 0; index < courses.size(); index++)
				{
					if(courses.get(index).getYearLevel() == year && courses.get(index).getTerm() == term)
					{
						System.out.printf("%-13s%-55s%-6d",
						courses.get(index).getNumber(),courses.get(index).getTitle(),courses.get(index).getUnits());
						if(!courses.get(index).getTaken())
							System.out.println("Not yet taken");
						else
							System.out.printf("%-6d%n",courses.get(index).getGrade());
					}
				}
				System.out.println("Press enter key to see courses for the next term.");
				kbd.nextLine();
 	  		}
 	  	}
 	  }// end of showChecklistPerTermWithGrades


	/**
 	 *returns the index of the location of a course with a
	 *given courseNumber if the course exists in an Array of Course
	 *and returns -1 if a course with the given
	 *courseNumber does not belong to the Array of Course
	 **/
 	  public int isFound(String courseNumber)
 	  {
 	  	for(int i = 0; i < courses.size(); i++)
 	  	{
 	  		if(courseNumber.equalsIgnoreCase(courses.get(i).getNumber()))
 	  		{
 	  			return i;
 	  		}
 	  	}

 	  	return -1;
 	  }

	/**
	 *updates an Array of Course by editing the attributes
	 * of a course with a given course number
	 **/

	 public void editCourse(String courseNumber) throws Exception
	 {
	 	int i = isFound(courseNumber);
	 	if(i != -1)
	 	{
	 		System.out.print("Enter new Course Title: ");
	 		String t = kbd.nextLine();
	 		courses.get(i).setTitle(t);
	 		System.out.print("Enter new number of units: ");
	 		int u = readInt();
	 		courses.get(i).setUnits(u);
	 		System.out.print("Enter new year level: ");
	 		int y = readInt();
	 		courses.get(i).setYearLevel(y);
	 		System.out.print("Enter new term: ");
	 		int te = readInt();
	 		courses.get(i).setTerm(te);
	 	}
	 }

	 public void enterGrade() throws Exception
	 {
	 	char choice = 'y';
	 	while(choice == 'y')
	 	{
	 		System.out.print("Enter the course number you want to enter a grade to: ");
		 	String courseNumber = kbd.nextLine();
		 	int i = isFound(courseNumber);
		 	if(i != -1)
		 	{
		 		System.out.print("Enter new grade for " + courseNumber + ": ");
		 		int g = readInt();
		 		courses.get(i).setGrade(g);
		 	}
		 	else
		 	{
		 		System.out.println(courseNumber + " does not exist.");
		 	}
		 	System.out.print("Do you want to enter another grade?(y/n)");
		 	choice = kbd.nextLine().charAt(0);
	 	}
	 	outputFile();
	 }
	 
	 public void outputFile()
	 {
	 	try
	 	{
		 	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(printFile));
		 	for(int i = 0; i < NUMBER_OF_COURSES; i++)
		 		oos.writeObject(courses.get(i));
		 	oos.close();	
	 	}
	 	catch(Exception e2)
		{
			e2.printStackTrace();
		}
	 	
	 }


	 public double computeGPA(){
		double average=0.0;
		double units = 0.0;
		for(int i = 0; i < courses.size(); i++)
		{
			average += (courses.get(i).getGrade() * courses.get(i).getUnits());
			units += courses.get(i).getUnits();
		}
		average = average / units;

		return average;
		}

		public void showGPA()
		{
			System.out.println("Your GPA is: " + computeGPA());
		}



 	  public String yearInWord(int y)
 	  {
 	  	switch(y)
 	  	{
 	  		case 1: return "First Year";
 	  		case 2: return "Second Year";
 	  		case 3: return "Third Year";
 	  		case 4: return "Fourth Year";
 	  		case 5: return "Fifth Year";
 	  	}
 	  	return "Unknown Year";
 	  }

 	  public String termInWord(int t)
 	  {
 	  	switch(t)
 	  	{
 	  		case 1: return "First Semester";
 	  		case 2: return "Second Semester";
 	  		case 3: return "Summer";
 	  	}
 	  	return "Unknown Term";
 	  }

 	  public void run() throws Exception {
		courses = new LinkedList<Course>();
		courses = readData(sourceFile);
		int choice=0;
		while (choice != 4) {
		showMenu();
		choice = readChoice();
		switch (choice){
		case 1: showChecklistPerTerm(4,3);
		break;
		case 2:
		showChecklistPerTermWithGrades(4,3);
		break;
		case 3:
		enterGrade();
		break;
		case 4:
		outputFile();
		System.out.println("..Thank you. ");
		} // end of switch
		} // end of while
		} // end of run

 	  public void showMenu()
 	  {
		System.out.println("My Checklist Management");
		System.out.println("<1> Show subjects for each school term");
		System.out.println("<2> Show subjects with grades for each term");
		System.out.println("<3> Enter grades for subjects recently finished");
		System.out.println("<4> Quit");
	}
		/**
		*ALGORITHM:
		*Place algorithm here.
		**/
		public int readChoice(){
		int choice=0;
		Scanner kbd = new Scanner(System.in);
		while (choice!=1 && choice !=2 && choice !=3 && choice != 4){
		System.out.print("Enter the number corresponding to your choice: " );
		choice = readInt();
		if (choice!=1 && choice !=2 && choice !=3 && choice != 4){
		System.out.println("The choice must be a number from 1 to 5.");
		}
		}
		return choice;
		}

 	  public int readInt()
 	  {
		int value=0;
		boolean noProblem = true;
		do
		{
			try
			{
				value = Integer.parseInt(kbd.nextLine());
				noProblem = true;
			}
			catch (Exception e )
			{
				System.out.print("You entered an invalid datum. Please enter integer: ");
				noProblem = false;
			}
		} while (!noProblem);
			return value;
	}

	public boolean readBoolean()
	{
		boolean value=true;
		boolean noProblem = true;
		do
		{
			try
			{
				value = Boolean.parseBoolean(kbd.nextLine());
				noProblem = true;
			}
			catch (Exception e )
			{
				System.out.print("You entered an invalid value. Please enter a number: ");
				noProblem = false;
			}
		} while (!noProblem);
		return value;
	}

	public static void main(String[]args)
	{
 	  	CourseList myTry;
 	  	try
 	  	{
 	  		myTry = new CourseList();
 	  		myTry.run();
 	  	}
 	  	catch(Exception e)
 	  	{
 	  		e.printStackTrace();
 	  	}
 	  	System.exit(0);
 	}
}