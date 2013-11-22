package module3;

import module1.Board;

public class BishopMovement extends PieceMovement 
{
	String bishop;
	String b = "b";
	Board board = new Board();
	
	public BishopMovement(String bishop, Board board)
	{
		this.bishop = bishop;
		this.board = board;
	}
	
	public void checkMove(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(b.compareTo(bishop) == 0)
		{
			//black 
			if(originNum > newNum)
			{
				if(originNum - newLetter == 1)
				{
					landingOnBlack(originLetter, originNum, newLetter, newNum);
				}
				else if(checkSidwaysUp(originLetter, originNum, newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, bishop);
				}
			}
			else if(newNum > originNum)
			{
				if(newNum - originLetter == 1)
				{
					landingOnWhite(originLetter, originNum, newLetter, newNum);
				}
				else if(checkSidwaysDown(originLetter, originNum, newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, bishop);
				}
			}
		}
		else
		{
			//white
			if(originNum > newNum)
			{
				if(originNum - newLetter == 1)
				{
					landingOnWhite(originLetter, originNum, newLetter, newNum);
				}
				else if(checkSidwaysUp(originLetter, originNum, newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, bishop);
				}
			}
			else if(newNum > originNum)
			{
				if(newNum - originLetter == 1)
				{
					landingOnWhite(originLetter, originNum, newLetter, newNum);
				}
				else if(checkSidwaysDown(originLetter, originNum, newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, bishop);
				}
			}
			
		}
	}
	
	public void landingOnBlack(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(checkIfLandOnBlack(newLetter, newNum, board) == 1)
		{
			placePiece(originLetter, originNum, newLetter, newNum, bishop);
		}
	}
	
	public void landingOnWhite(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(checkIfLandOnWhite(newLetter, newNum, board) == 1)
		{
			placePiece(originLetter, originNum, newLetter, newNum, bishop);
		}
	}
}
