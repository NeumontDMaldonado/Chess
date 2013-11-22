package module3;

import module1.Board;

public class PieceMovement 
{
	Board board = new Board();
	int valid;
	String blackChessPieces = "[rnbqkp]";
	String whiteChessPieces = "[RNBQKP]";
	String chessPieces = "[rnbqkpRNBQKP]";
	String error = "invalid move, this piece can not jump over pieces";
	String error2 = "invalid move";
	
	public void checkMove(int originLetter, int originNum, int newLetter, int newNum){}
	
	public void landingOnBlack(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(checkIfLandOnBlack(newLetter, newNum, board) == 1)
		{
			
		}
	}
	
	public void landingOnWhite(int originLetter, int originNum, int newLetter, int newNum)
	{
		if(checkIfLandOnWhite(newLetter, newNum, board) == 1)
		{
			
		}
	}
	
	public void placePiece(int originLetter, int originNum, int newLetter, int newNum, String chessPiece)
	{
		board.placePiece(newNum, newLetter, chessPiece);
		board.placePiece(originNum, originLetter, board.EMPTYSPACE);
	}
	
	public int checkIfLandOnBlack(int newLetter, int newNum, Board b)
	{
		int blackValid = 0;
		this.board = b;
		
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
		int whiteValid = 0;
		this.board = b;
		
		if(b.checkBoard(newNum, newLetter).matches(whiteChessPieces))
		{
			System.out.println("invalid move, black chess piece is on the end location");
		}
		else
		{
			whiteValid = 1;
		}
		return whiteValid;
	}
	
	public int checkInBetweenVertical(int originLetter, int originNum, int newLetter, int newNum, Board b)
	{
		valid = 0;
		this.board = b;
		if(originNum > newNum)
		{
			int upValid = 0;
			int verticalUpNum = originNum;
			for(int counter = 0; counter < ((originNum-newNum)-1); counter++)
			{
				verticalUpNum = verticalUpNum - 1;
				if(b.checkBoard(verticalUpNum, originLetter).matches(chessPieces))
				{
					System.out.println(error);
				}
				else
				{
					upValid = 1;
				}
			}
			valid = upValid;
		}
		else if(newNum > originNum)
		{
			int downValid = 0;
			int verticalDownNum = newNum;
			for(int counter = 0; counter < ((newNum-originNum)-1); counter++)
			{
				verticalDownNum= verticalDownNum + 1;
				if(b.checkBoard(verticalDownNum, originLetter).matches(chessPieces))
				{
					System.out.println(error);
				}
				else
				{
					downValid = 1;
				}
			}
			valid = downValid;
		}
		return valid;
	}
	
	public int checkInBetweenHorizontal(int originLetter, int originNum, int newLetter, int newNum, Board b)
	{
		valid = 0;
		this.board = b;
		if(originLetter > newLetter)
		{
			int leftValid = 0;
			int horizontalLeftNum = originLetter;
			for(int counter = 0; counter < ((originLetter-newLetter)-1); counter++)
			{
				horizontalLeftNum = horizontalLeftNum - 1;
				if(b.checkBoard(originNum, horizontalLeftNum).matches(chessPieces))
				{
					System.out.println(error);
				}
				else
				{
					leftValid = 1;
				}
			}
			valid = leftValid;
		}
		else if(newLetter > originLetter)
		{
			int rightValid = 0;
			int horizontalRightNum = newNum;
			for(int counter = 0; counter < ((newLetter-originLetter)-1); counter++)
			{
				horizontalRightNum= horizontalRightNum + 1;
				if(b.checkBoard(originLetter,horizontalRightNum).matches(chessPieces))
				{
					System.out.println(error);
				}
				else
				{
					rightValid = 1;
				}
			}
			valid = rightValid;
		}
		return valid;
	}
	
	public int checkSidwaysUp(int originLetter, int originNum, int newLetter, int newNum, Board b)
	{
		valid = 0;
		int diagnalUpLetter = originLetter;
		int diagnalUpNumber = originNum;
		
		if(originLetter > newLetter) //diagnal up left
		{
			int diagnalLeftValid = 0;
			for(int counter = 0; counter < ((originLetter-newLetter)-1); counter++)
			{
				diagnalUpLetter = diagnalUpLetter - 1;
				diagnalUpNumber = diagnalUpNumber - 1;
				if(b.checkBoard(diagnalUpLetter,diagnalUpNumber).matches(chessPieces))
				{
					System.out.println(error);
				}
				else
				{
					diagnalLeftValid = 1;
				}
			}
			valid = diagnalLeftValid;
		}
		else if(newLetter > originLetter) //diagnal up right
		{
			int diagnalRightValid = 0;
			for(int counter = 0; counter < ((newLetter-originLetter)-1);counter++)
			{
				diagnalUpLetter = diagnalUpLetter + 1;
				diagnalUpNumber = diagnalUpNumber - 1;
				if(b.checkBoard(diagnalUpLetter,diagnalUpNumber).matches(chessPieces))
				{
					System.out.println(error);
				}
				else
				{
					diagnalRightValid = 1;
				}
			}
			valid = diagnalRightValid;
		}
		return valid;
	}
	
	public int checkSidwaysDown(int originLetter, int originNum, int newLetter, int newNum, Board b)
	{
		valid = 0;
		int diagnalDownLetter = originLetter;
		int diagnalDownNumber = originNum;
		if(newLetter > originLetter)
		{
			int downRightValid = 0;
			for(int counter = 0; counter < ((newNum-originNum)-1); counter++)
			{
				diagnalDownLetter = diagnalDownLetter + 1;
				diagnalDownNumber = diagnalDownNumber + 1;
				if(b.checkBoard(diagnalDownLetter,diagnalDownNumber).matches(chessPieces))
				{
					System.out.println(error);
				}
				else
				{
					downRightValid = 1;
				}
				valid = downRightValid;
			}
			
		}
		else if(originLetter > newLetter)
		{
			int downLeftValid = 0;
			for(int counter = 0; counter < ((newNum-originNum)-1); counter++)
			{
				diagnalDownLetter = diagnalDownLetter - 1;
				diagnalDownNumber = diagnalDownNumber + 1;
				if(b.checkBoard(diagnalDownLetter,diagnalDownNumber).matches(chessPieces))
				{
					System.out.println(error);
				}
				else
				{
					downLeftValid = 1;
				}
				valid = downLeftValid;
			}
			
		}
		return valid;
	}
}
