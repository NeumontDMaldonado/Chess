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
	Board b = new Board();

	public RookMovement(String rook, Board b)
	{
		this.rook = rook;
		this.b = b;
	}
	public void checkMove(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(r.compareTo(rook) == 0)
		{
			//black
			if(originLetter == newLetter)
			{
				if(checkInBetweenVertical(originLetter, originNum, newLetter, newNum) == 1 && checkIfLandOnBlack(newLetter, newNum, b) == 1)
				{
					b.placePiece(newNum, newLetter, rook);
					b.placePiece(originNum, originLetter, b.EMPTYSPACE);
				}
			}
		}
		else
		{
			//white
		}
	}
}