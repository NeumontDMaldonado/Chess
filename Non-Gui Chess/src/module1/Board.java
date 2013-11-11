package module1;

public class Board 
{
	final int BOARD_SIZE = 8;
	final String EMPTY = "ee";
	String board[][] = new String[BOARD_SIZE][BOARD_SIZE];

	
	/**
	 * Sets board up
	 */
	public void startBoard()
	{
		for (int i = 0; i < BOARD_SIZE; i++)
		{
			System.out.println("");

			for (int j = 0; j < BOARD_SIZE; j++)
			{
				board [i][j] = EMPTY;
			}
		}
	}
	
	/**
	 * displays current board
	 */
	public void displayBoard()
	{
		for (int i = 0; i < BOARD_SIZE; i++)
		{
			System.out.println("");

			for (int j = 0; j < BOARD_SIZE; j++)
			{
				System.out.print(board [i][j] + " ");
			}
		}
	}
	
	public void setBoard(int a, int b, String piece)
	{
		board[a][b] = piece;
	}
}