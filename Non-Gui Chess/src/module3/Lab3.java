package module3;

import module1.Board;

public class Lab3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Board board = new Board();
		ReadFile pieceMovement = new ReadFile(args[0], board);
		pieceMovement.end();
		System.out.println("UpperCase is light chess piece");
	}
}