package module3;

import module1.Board;

public class KnightMovement extends PieceMovement
{
	String knight;
	String n = "n";
	Board board = new Board();
	
	public KnightMovement(String knight, Board board)
	{
		this.knight = knight;
		this.board = board;
	}
	
	public void checkMove(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(n.compareTo(knight) == 0)
		{
			//black
			if(originNum - newNum == 2)
			{
				move1Black(originLetter, originNum, newLetter, newNum);
			}
			else if(originNum - newNum == 1)
			{
				move2Black(originLetter, originNum, newLetter, newNum);
			}
			else if(newNum - originNum == 1)
			{
				move2Black(originLetter, originNum, newLetter, newNum);
			}
			else if(newNum - originNum ==2)
			{
				move1Black(originLetter, originNum, newLetter, newNum);
			}
				
		}
		else
		{
			//white
			if(originNum - newNum == 2)
			{
				move1White(originLetter, originNum, newLetter, newNum);
			}
			else if(originNum - newNum == 1)
			{
				move2White(originLetter, originNum, newLetter, newNum);
			}
			else if(newNum - originNum == 1)
			{
				move2White(originLetter, originNum, newLetter, newNum);
			}
			else if(newNum - originNum ==2)
			{
				move1White(originLetter, originNum, newLetter, newNum);
			}
		}
	}
	
	public void move1Black(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(originLetter - newLetter == 1)
		{
			landingOnBlack(originLetter, originNum, newLetter, newNum);
		}
		else if(newLetter - originLetter == 1)
		{
			landingOnBlack(originLetter, originNum, newLetter, newNum);
		}
	}
	
	public void move2Black(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(originLetter - newLetter == 2)
		{
			landingOnBlack(originLetter, originNum, newLetter, newNum);
		}
		else if(newLetter - originLetter == 2)
		{
			landingOnBlack(originLetter, originNum, newLetter, newNum);
		}
	}
	
	public void move1White(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(originLetter - newLetter == 1)
		{
			landingOnWhite(originLetter, originNum, newLetter, newNum);
		}
		else if(newLetter - originLetter == 1)
		{
			landingOnWhite(originLetter, originNum, newLetter, newNum);
		}
	}
	
	public void move2White(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(originLetter - newLetter == 2)
		{
			landingOnWhite(originLetter, originNum, newLetter, newNum);
		}
		else if(newLetter - originLetter == 2)
		{
			landingOnWhite(originLetter, originNum, newLetter, newNum);
		}
	}
	
	public void landingOnBlack(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(checkIfLandOnBlack(newLetter, newNum, board) ==1);
		{
			placePiece(originLetter, originNum, newLetter, newNum, knight);
		}
	}
	
	public void landingOnWhite(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(checkIfLandOnWhite(newLetter, newNum, board) == 1)
		{
			placePiece(originLetter, originNum, newLetter, newNum, knight);
		}
	}
}
