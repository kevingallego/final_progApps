import java.util.*;

public abstract class CurriculumManager
{
	protected LinkedList<Course> courses;


	/**
 	 *returns an Array that is populated with course objects
	 *where the course objects are constructed for the data
	 *read from a text file of course details
	 */

	public abstract LinkedList<Course> readData(String f);

	 /**
 	  *displays a typical checklist where courses in an
	  * Array of Course that are assigned for year
  	  * level y and school school term t are shown
	  **/

	public abstract void showChecklistPerTerm(int y, int t);

	/**
	 *displays a checklist where courses in an Array
	 *of Course that are assigned for year level y and
	 *school term t with the grade for each course
	 *are shown
	 **/

	public abstract void showChecklistPerTermWithGrades(int y, int t);

	/**
	 *returns the index of the location of a course with a
	 *given courseNumber if the course exists in an Array of Course
	 *and returns -1 if a course with the given
	 *courseNumber does not belong to the Array of Course
	 **/

	public abstract int isFound(String courseNumber);

	/**
	 *updates an Array of Course by editing the attributes
	 * of a course with a given course number
	 **/
	public abstract void editCourse(String courseNumber) throws Exception;

	/**
	 *updates the Array of Course after editing the
	 * grade attribute of a course with a given course
	 * number
	 **/

	public abstract void enterGrade() throws Exception;

	/**
	 *returns the grade point average of all courses taken.
	 **/

	public abstract double computeGPA();

	/**
	 *shows the grade point average of all courses taken.
	 **/

	public abstract void showGPA();


}