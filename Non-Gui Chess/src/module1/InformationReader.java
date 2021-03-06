package module1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationReader 
{
	private static Board b;
	public String line;
	private final String PIECEPLACEMENT = "(?<ChessPiece>[RNMBQLKP])(?<ChessColor>[ld])(?<Column>[a-h])(?<Row>[1-8])";
	private final String PIECEMOVEMENT = "(?<OriginColumn>[a-h])(?<OriginRow>[1-8]) (?<NewColumn>[a-h])(?<NewRow>[1-8])";
	private final String CASTLING = "(?<KingOriginColumn>[a-h])(?<KingOriginRow>[1-8]) (?<KingNewColumn>[a-h])(?<KingNewRow>[1-8]) (?<RookOriginColumn>[a-h])(?<RookOriginRow>[1-8]) " +
			"(?<RookNewColumn>[a-h])(?<RookNewRow>[1-8])";
	Pattern piecePlacement = Pattern.compile(PIECEPLACEMENT);
	Pattern pieceMovement = Pattern.compile(PIECEMOVEMENT);
	Pattern castling = Pattern.compile(CASTLING);
	Matcher piecePlace;
	Matcher pieceMove;
	Matcher castle;
	Pattern pattern[] = new Pattern[3];
	
	/**
	 * @param args
	 * @param b
	 * constructor
	 */
	public InformationReader(String args, Board b)
	{
		FileReader chessNotationFile = null;
		try 
		{
			chessNotationFile = new FileReader(args);
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("No file found");
		}
		b.startBoard();
		BufferedReader buff = new BufferedReader(chessNotationFile);
		InformationReader.b = b;
		patternArray();
		read(buff);
	}
	
	/**
	 * sets up the pattern array
	 */
	public void patternArray()
	{
		pattern[0] = Pattern.compile(PIECEPLACEMENT);
		pattern[1] = Pattern.compile(CASTLING);
		pattern[2] = Pattern.compile(PIECEMOVEMENT);
	}

	/**
	 * @param buff
	 * gets line from file and redirects to appropriate method
	 */
	public void read(BufferedReader buff)
	{
		try 
		{
			while(buff.ready())
			{
				line = buff.readLine();
				piecePlace = pattern[0].matcher(line);
				pieceMove = pattern[2].matcher(line);
				castle = pattern[1].matcher(line);
				
				if(piecePlace.find())
				{
					String chessPiece = piecePlace.group("ChessPiece");
					String chessColor = piecePlace.group("ChessColor");
					String chessLetter = piecePlace.group("Column");
					String chessNum = piecePlace.group("Row");
					
					if(chessColor.equals("d"))
					{
						chessPiece = chessPiece.toLowerCase();
					}
					placePiece(numberTranslation(chessNum),letterTranslation(chessLetter), chessPiece);
					System.out.println("Chess piece "+ chessPiece +" has been placed");
				}
				else if(castle.find())
				{
					String kingSpaceLetter1 = castle.group("KingOriginColumn");
					String kingSpaceNum1 = castle.group("KingOriginRow");
					String kingSpaceLetter2 = castle.group("KingNewColumn");
					String kingSpaceNum2 = castle.group("KingNewRow");
					String rookSpaceLetter1 = castle.group("RookOriginColumn");
					String rookSpaceNum1 = castle.group("RookOriginRow");
					String rookSpaceLetter2 = castle.group("RookNewColumn");
					String rookSpaceNum2 = castle.group("RookNewRow");
					
					
					moveTwoPieces(letterTranslation(kingSpaceLetter1), numberTranslation(kingSpaceNum1), letterTranslation(kingSpaceLetter2), numberTranslation(kingSpaceNum2), 
							letterTranslation(rookSpaceLetter1), numberTranslation(rookSpaceNum1), letterTranslation(rookSpaceLetter2), numberTranslation(rookSpaceNum2));		
					System.out.println("Castling has occured");
				}
				else if(pieceMove.find())
				{
					String firstSpaceLetter = pieceMove.group("OriginColumn");
					String firstSpaceNum = pieceMove.group("OriginRow");
					String secondSpaceLetter = pieceMove.group("NewColumn");
					String secondSpaceNum = pieceMove.group("NewRow");
 					
					
					moveChessPiece(letterTranslation(firstSpaceLetter), numberTranslation(firstSpaceNum), letterTranslation(secondSpaceLetter), numberTranslation(secondSpaceNum));
					System.out.println("Piece "+ b.checkBoard(numberTranslation(secondSpaceNum),letterTranslation(secondSpaceLetter)) +" has been moved");
				}
				else
				{
					System.err.println(line + " is not a valid input");
				}
			}
		} 
		catch (IOException e) 
		{
			System.err.println("IO exception");
		}
	}


	/**
	 * @param letter
	 * @param num
	 * the switch statement translates the chess notation to corresponding double array location and then sets the piece in the correct location
	 * @return 
	 */
	public void placePiece(int letter, int num, String chessPiece)
	{
		b.placePiece(letter, num, chessPiece);
	}
	
	/**
	 * @param currentLetter
	 * @param currentNum
	 * @param newLetter
	 * @param newNum
	 * the switch statement translate the chess notation to the corresponding double array location then moves the chess piece and sets the old location to empty
	 * @return 
	 */
	private void moveChessPiece(int currentLetter, int currentNum, int newLetter, int newNum)
	{
		b.board[newNum][newLetter] = b.board[currentNum][currentLetter];
		b.placePiece(currentNum, currentLetter, b.EMPTYSPACE);
	}
	
	/**
	 * @param currentLetter1
	 * @param currentNum1
	 * @param newLetter1
	 * @param newNum1
	 * @param currentLetter2
	 * @param currentNum2
	 * @param newLetter2
	 * @param newNum2
	 * moves two chess pieces
	 */
	private void moveTwoPieces(int currentLetter1, int currentNum1, int newLetter1, int newNum1, int currentLetter2, int currentNum2, int newLetter2, int newNum2)
	{
		moveChessPiece(currentLetter1,currentNum1,newLetter1,newNum1);
		moveChessPiece(currentLetter2,currentNum2,newLetter2,newNum2);
	}
	
	/**
	 * @param letter
	 * @return
	 * translate letter chess notation to double array
	 */
	private int letterTranslation(String letter)
	{
		return letter.charAt(0) - 'a';
	}
	
	/**
	 * @param num
	 * @return
	 * translate number chess notation to double array
	 */
	private int numberTranslation(String num)
	{
		return '8' - num.charAt(0);
	}

	/**
	 * displays the board and states when the file has reached the end
	 */
	public void end()
	{
		b.displayBoard();
		System.out.println();
		System.out.println("There is no more information to parse");
	}
}