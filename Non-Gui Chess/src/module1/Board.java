package module1;

public class Board 
{
	final int BOARD_SIZE = 8;
	public final String EMPTYSPACE = "-";
	public String board[][] = new String[BOARD_SIZE][BOARD_SIZE];

	
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
				board [i][j] = EMPTYSPACE;
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
	
	/**
	 * @param a
	 * @param b
	 * @param piece
	 * sets a piece at a specific spot
	 */
	public void placePiece(int a, int b, String piece)
	{
		board[a][b] = piece;
	}
	
	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public String checkBoard(int a, int b)
	{
		return board[a][b];
	}
}