package module3;

import module1.Board;

public class PieceMovement 
{
	Board b = new Board();
	int blackValid, whiteValid, valid;
	String blackChessPieces = "[rnbqkp]";
	String whiteChessPieces = "[RNBQKP]";
	String chessPieces = "[rnbqkpRNBQKP]";
	String error = "invalid move, this piece can not jump over pieces";
	
	public int checkIfLandOnBlack(int newLetter, int newNum, Board b)
	{
		blackValid = 0;
		this.b = b;
		
		if(b.checkBoard(newNum, newLetter).matches(blackChessPieces))
		{
			System.out.println("invalid move, black chess piece is on the end location");
		}
		else
		{
			blackValid = 1;
		}
		return blackValid;
	}
	
	public int checkIfLandOnWhite(int newLetter, int newNum, Board b)
	{
		whiteValid = 0;
		this.b = b;
		
		if(b.checkBoard(newNum, newLetter).matches(whiteChessPieces))
		{
			System.out.println("invalid move, black chess piece is on the end location");
		}
		else
		{
			blackValid = 1;
		}
		return whiteValid;
	}
	
	public int checkInBetweenVertical(int originLetter, int originNum, int newLetter, int newNum)
	{
		valid = 0;
		if(originNum > newNum)
		{
			int verticalUpNum = originNum;
			for(int counter = 0; counter < ((originNum-newNum)-1); counter++)
			{
				verticalUpNum =- 1;
				if(b.checkBoard(verticalUpNum, originLetter).matches(chessPieces))
				{
					System.out.println(error);
				}
				else
				{
					valid = 1;
				}
			}
		}
		else if(newNum > originNum)
		{
			valid = 0;
			int verticalDownNum = newNum;
			for(int counter = 0; counter < ((newNum-originNum)-1); counter++)
			{
				verticalDownNum++;
				if(b.checkBoard(verticalDownNum, originLetter).matches(chessPieces))
				{
					System.out.println(error);
				}
				else
				{
					valid = 1;
				}
			}
		}
		return valid;
	}
}
