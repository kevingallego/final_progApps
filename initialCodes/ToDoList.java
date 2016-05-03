/**
 * This application provides a simple To-Do-List. Adding and removing
 * last items or removing specific items can be done.
 *
 *
 * @author Princes Criste
 */
public class ToDoList {

  //instance variables
  private String[] todo; //storage of tasks
  private int count;     //how many tasks have been added to todo

  /**
   *  Builds a new, empty ToDoList. Current max capacity is 50.
   */
  public ToDoList() {
    this.todo = new String[50];
    this.count = 0;
  }

  /**
   * Adds the given item to this ToDoList.  Returns true if successfully
   * added, or false if not (such as when the list is full).
   */
  public boolean add(String item) {
    if (this.count == this.todo.length) {
      return false;  //can't add to full list
    }else {
      this.todo[count] = item;
      this.count++;
      return true;
    }
  }

  /**
   * Returns how many items are currently stored in this list.
   */
  public int getSize() {
    return count;
  }

  /**
   * Removes the item at the given 1-based index in this list.
   * Returns the removed item, or null if the given index did not correspond
   * to a valid item.
   */
  public String remove(int index) {
    if (index < 1 || index > this.count) {
      return null;  //no such element
    }else {
      index--;  //convert to 0-based indexing used by array
      String deleted = this.todo[index];
      //delete by shifting everything down into removed item's space
      for (int i = index; i < this.count - 1; i++) {
        this.todo[i] = this.todo[i + 1];
      }
      this.count--;  //removed an element
      return deleted;
    }
  }

  /**
   * Returns a String representation of this ToDoList.
   * Specifically, "TODO:" followed by a numbered list of tasks.
   */
  public String toString() {
    String output = "TODO:\n";
    for (int i = 0; i < this.count; i++) {
      output += (i + 1) + ". " + this.todo[i] + "\n";
    }
    return output;
  }



  /**
   * Provides a simple menu-based interface for the user to use a single
   * ToDoList.
   */
  public static void main(String[] args) {

    java.util.Scanner keybd = new java.util.Scanner(System.in);
    ToDoList list = new ToDoList();

    int choice = 1;
    while (choice != 0) {
      //print list
      System.out.println();
      System.out.println(list);  //calls toString()

      //print menu choices
      System.out.println("MENU:");
      System.out.println("1 - Add item");
      System.out.println("2 - Remove last item");
      System.out.println("3 - Remove specific item");
      System.out.println("0 - Quit");
      System.out.print("Enter your menu choice: ");

      //process user's menu choice
      try {
        choice = keybd.nextInt();
        keybd.nextLine();  //clear input stream
        switch (choice) {
          case 1:  //ADD
            System.out.print("Enter the thing you need to do: ");
            String task = keybd.nextLine();
            boolean added = list.add(task);
            if (!added) {
              System.out.println("Sorry, but this to-do list is already full!");
            }
            break;

          case 2:  //REMOVE LAST
            String removed = list.remove(list.getSize());
            if (removed != null) {
              System.out.println("Removed: " + removed);
            }else {
              System.out.println("The to-do list is already empty.");
            }
            break;

          case 3:  //REMOVE AT
            System.out.print("Enter the index of the item to remove: ");
            int index = keybd.nextInt();
            removed = list.remove(index);
            if (removed != null) {
              System.out.println("Removed: " + removed);
            }else {
              System.out.println("There is no item to be removed at index " +
                  index + ".");
            }
            break;

          case 0:
            System.out.println("Goodbye!");
            break;

          default:
            System.out.println("Sorry, but " + choice + " is not one of " +
                "the menu choices. Please try again.");
            break;
        }
      }catch (java.util.InputMismatchException ime) {
        System.out.println("Sorry, but you must enter a number.");
        keybd.nextLine();  //clear bad input from stream
      }
    }//end while
  }//end main

}