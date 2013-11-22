/**
 * 
 */
package module3;

import module1.Board;

/**
 * @author dmaldonado
 *
 */
public class KingMovement extends PieceMovement
{
	String king;
	String k = "k";
	Board board = new Board();
	
	public KingMovement(String king, Board board)
	{
		this.king = king;
		this.board = board;
	}
	
	public void checkMove(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(k.compareTo(king) == 0)
		{
			if(checkIfLandOnBlack(newLetter, newNum, board) == 1)
			{
				validMove(originLetter, originNum, newLetter, newNum);
			}
		}
		else
		{
			if(checkIfLandOnWhite(newLetter, newNum, board) == 1)
			{
				validMove(originLetter, originNum, newLetter, newNum);
			}
		}
	}
	
	public void validMove(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(originNum - newNum == 1)
		{
			validMove2(originLetter, originNum, newLetter, newNum);
		}
		else if(originNum == newNum)
		{
			if(originLetter - newLetter == 0)
			{
				placePiece(originLetter, originNum, newLetter, newNum, king);
			}
			else if(newLetter - originLetter == 0)
			{
				placePiece(originLetter, originNum, newLetter, newNum, king);
			}
			else
			{
				System.err.println("the king has made an invalid move");
			}
		}
		else if(newNum - originNum == 1)
		{
			validMove2(originLetter, originNum, newLetter, newNum);
		}
		else
		{
			System.err.println("invalid move, the king can only move one space away");
		}
	}
	
	public void validMove2(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(newLetter == originLetter)
		{
			placePiece(originLetter, originNum, newLetter, newNum, king);
		}
		else if(originLetter - newLetter == 1)
		{
			placePiece(originLetter, originNum, newLetter, newNum, king);
		}
		else if(newLetter - originLetter == 1)
		{
			placePiece(originLetter, originNum, newLetter, newNum, king);
		}
		else
		{
			System.err.println("the king has made an invalid move");
		}
	}
}
