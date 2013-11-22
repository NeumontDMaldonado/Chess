/**
 * 
 */
package module3;

import module1.Board;

/**
 * @author dmaldonado
 *
 */
public class RookMovement extends PieceMovement
{
	String rook;
	String r = "r";
	Board board = new Board();

	public RookMovement(String rook, Board board)
	{
		this.rook = rook;
		this.board = board;
	}
	public void checkMove(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(r.compareTo(rook) == 0)
		{
			//black
			if(originLetter == newLetter)
			{
				if(newNum-originNum == 1 || originNum-newNum ==1)
				{
					landingOnBlack(originLetter, originNum, newLetter, newNum);
				}
				else if(checkInBetweenVertical(originLetter, originNum, newLetter, newNum, board) == 1 && checkIfLandOnBlack(newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, rook);
				}
			}
			else if(originNum == newNum)
			{
				if(newLetter-originLetter == 1 || originLetter-newLetter ==1)
				{
					landingOnBlack(originLetter, originNum, newLetter, newNum);
				}
				else if(checkInBetweenHorizontal(originLetter, originNum, newLetter, newNum, board) == 1 && checkIfLandOnBlack(newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, rook);
				}
			}
		}
		else
		{
			//white
			if(originLetter == newLetter)
			{
				if(newNum-originNum == 1 || originNum-newNum ==1)
				{
					landingOnWhite(originLetter, originNum, newLetter, newNum);
				}
				else if(checkInBetweenVertical(originLetter, originNum, newLetter, newNum, board) == 1 && checkIfLandOnBlack(newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, rook);
				}
			}
			else if(originNum == newNum)
			{
				if(newLetter-originLetter == 1 || originLetter-newLetter ==1)
				{
					landingOnWhite(originLetter, originNum, newLetter, newNum);
				}
				else if(checkInBetweenHorizontal(originLetter, originNum, newLetter, newNum, board) == 1 && checkIfLandOnBlack(newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, rook);
				}
			}
		}
	}
	
	public void landingOnBlack(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(checkIfLandOnBlack(newLetter, newNum, board) ==1);
		{
			placePiece(originLetter, originNum, newLetter, newNum, rook);
		}
	}
	
	public void landingOnWhite(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(checkIfLandOnWhite(newLetter, newNum, board) == 1)
		{
			placePiece(originLetter, originNum, newLetter, newNum, rook);
		}
	}
}