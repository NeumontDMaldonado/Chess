package module3;

import module1.Board;

public class QueenMovement extends PieceMovement
{
	String queen;
	String q = "q";
	Board board = new Board();
	
	public QueenMovement(String queen, Board board)
	{
		this.queen = queen;
		this.board = board;
	}
	
	public void checkMove(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(q.compareTo(queen) == 0)
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
					placePiece(originLetter, originNum, newLetter, newNum, queen);
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
					placePiece(originLetter, originNum, newLetter, newNum, queen);
				}
			}
			else if(originNum > newNum)
			{
				if(originNum - newLetter == 1)
				{
					landingOnBlack(originLetter, originNum, newLetter, newNum);
				}
				else if(checkSidwaysUp(originLetter, originNum, newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, queen);
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
					placePiece(originLetter, originNum, newLetter, newNum, queen);
				}
			}

		}
		else
		{
			//white
//			up right not working, down right not working, down left not working
			if(originLetter == newLetter)
			{
				if(newNum-originNum == 1 || originNum-newNum ==1)
				{
					landingOnWhite(originLetter, originNum, newLetter, newNum);
				}
				else if(checkInBetweenVertical(originLetter, originNum, newLetter, newNum, board) == 1 && checkIfLandOnBlack(newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, queen);
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
					placePiece(originLetter, originNum, newLetter, newNum, queen);
				}
			}
			else if(originNum > newNum)
			{
				if(originNum - newLetter == 1)
				{
					landingOnWhite(originLetter, originNum, newLetter, newNum);
				}
				else if(checkSidwaysUp(originLetter, originNum, newLetter, newNum, board) == 1)
				{
					placePiece(originLetter, originNum, newLetter, newNum, queen);
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
					placePiece(originLetter, originNum, newLetter, newNum, queen);
				}
			}
		}
	}
	
	public void landingOnBlack(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(checkIfLandOnBlack(newLetter, newNum, board) == 1)
		{
			placePiece(originLetter, originNum, newLetter, newNum, queen);
		}
	}
	
	public void landingOnWhite(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(checkIfLandOnWhite(newLetter, newNum, board) == 1)
		{
			placePiece(originLetter, originNum, newLetter, newNum, queen);
		}
	}
}
