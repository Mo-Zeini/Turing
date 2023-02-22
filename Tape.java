package turing;

/**
 * This class implements a Turing machine tape represented by a doubly-linked list
 * where each cell has a pointer to the previous cell and to the next cell.
 * The pointers allow the machine to advance from one cell to the next cell on the left or on the right.
 */
public class Tape {
	
	private Cell currentCell; // An instance variable that points to the current cell.
	
	// A constructor that creates a blank tape with a single cell. Each cell contains a blank space.
	public Tape() {
		Cell newCell = new Cell();
		newCell.content = ' ';
		newCell.prev = null;
		newCell.next = null;
		currentCell = newCell;
	} // end of the constructor.
	
	// A method that returns the pointer that points to the current cell.
	public Cell getCurrentCell() {
		return currentCell;
	} // end of the getCurrentCell() method.
	
	// A method that returns the char from the current cell.
	public char getContent() {
		return currentCell.content;
	} // end of the getContent() method.
	
	// A method that changes the char in the current cell to the specified value.
	public void setContent(char ch) {
		currentCell.content = ch;
	} // end of the setContent() method.
	
	// A method that moves the current cell one position to the left along the tape.
	public void moveLeft() {
		if (currentCell.prev == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.prev = null;
			newCell.next = currentCell;
			currentCell.prev = newCell;
		}
		currentCell = currentCell.prev; // The previous cell is now the current cell.
	} // end of the moveLeft() method.
	
	// A method that moves the current cell one position to the right along the tape.
	public void moveRight() {
		if (currentCell.next == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.next = null;
			newCell.prev = currentCell;
			currentCell.next = newCell;
		}
		currentCell = currentCell.next;
	} // end of the moveRight() method.
	
	// A method that returns a String consisting of the chars from all the cells on the tape
	// except that leading or trailing blank characters should be discarded.
	public String getTapeContents() {
		Cell pointer = currentCell;
		while (pointer.prev != null) 
			pointer = pointer.prev;
		
		String stContent = "";
		while (pointer != null) {
			stContent += pointer.content;
			pointer = pointer.next;
		}
		// Returning a copy of the string.
		stContent = stContent.trim();
		return stContent;
	} // end of the getTapeContents() method.
} // end of class Tape.
