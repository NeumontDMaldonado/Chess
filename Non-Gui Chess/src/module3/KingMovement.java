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
	Board b = new Board();
	
	public KingMovement(String king, Board b)
	{
		this.king = king;
		this.b = b;
	}
	
	public void checkMove(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(k.compareTo(king) == 0)
		{
			if(checkIfLandOnBlack(newLetter, newNum, b) == 1)
			{
				validMove(originLetter, originNum, newLetter, newNum);
			}
		}
		else
		{
			if(checkIfLandOnWhite(newLetter, newNum, b) == 1)
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
				b.placePiece(newNum, newLetter, king);
				b.placePiece(originNum, originLetter, b.EMPTYSPACE);
			}
			else if(newLetter - originLetter == 0)
			{
				b.placePiece(newNum, newLetter, king);
				b.placePiece(originNum, originLetter, b.EMPTYSPACE);
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
			b.placePiece(newNum, newLetter, king);
			b.placePiece(originNum, originLetter, b.EMPTYSPACE);
		}
		else if(originLetter - newLetter == 1)
		{
			b.placePiece(newNum, newLetter, king);
			b.placePiece(originNum, originLetter, b.EMPTYSPACE);
		}
		else if(newLetter - originLetter == 1)
		{
			b.placePiece(newNum, newLetter, king);
			b.placePiece(originNum, originLetter, b.EMPTYSPACE);
		}
		else
		{
			System.err.println("the king has made an invalid move");
		}
	}
}
