package module3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import module1.Board;

public class ReadFile 
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
	Pattern pattern[] = new Pattern[2];

	/**
	 * @param args
	 * @param b
	 * constructor
	 */
	public ReadFile(String args, Board b)
	{
		FileReader chessMovementFile = null;
		try 
		{
			chessMovementFile = new FileReader(args);
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("No file found");
		}
		b.startBoard();
		BufferedReader buff = new BufferedReader(chessMovementFile);
		ReadFile.b = b;
		patternArray();
		read(buff);
	}

	/**
	 * sets up the pattern array
	 */
	public void patternArray()
	{
		pattern[0] = Pattern.compile(PIECEPLACEMENT);
		pattern[1] = Pattern.compile(PIECEMOVEMENT);
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
				pieceMove = pattern[1].matcher(line);

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
				}
				else if(pieceMove.find())
				{
					b.displayBoard();
					String firstSpaceLetter = pieceMove.group("OriginColumn");
					String firstSpaceNum = pieceMove.group("OriginRow");
					String secondSpaceLetter = pieceMove.group("NewColumn");
					String secondSpaceNum = pieceMove.group("NewRow");

					chessPieceRedirection(letterTranslation(firstSpaceLetter), numberTranslation(firstSpaceNum), letterTranslation(secondSpaceLetter), numberTranslation(secondSpaceNum));
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

	public void chessPieceRedirection(int originLetter, int originNum, int newLetter, int newNum)
	{
		System.out.println();
		String chessPiece = b.checkBoard(originNum, originLetter);
		if(chessPiece.equalsIgnoreCase("r"))
		{
			RookMovement rook = new RookMovement(chessPiece, b);
			rook.checkMove(originLetter, originNum, newLetter, newNum);
		}
		else if(chessPiece.equalsIgnoreCase("k"))
		{
			KingMovement king = new KingMovement(chessPiece, b);
			king.checkMove(originLetter, originNum, newLetter, newNum);
		}
		else if(chessPiece.equalsIgnoreCase("b"))
		{
			BishopMovement bishop = new BishopMovement(chessPiece, b);
			bishop.checkMove(originLetter, originNum, newLetter, newNum);
		}
		else if(chessPiece.equalsIgnoreCase("q"))
		{
			QueenMovement queen = new QueenMovement(chessPiece, b);
			queen.checkMove(originLetter, originNum, newLetter, newNum);
		}
		else if(chessPiece.equalsIgnoreCase("n"))
		{
			KnightMovement knight = new KnightMovement(chessPiece, b);
			knight.checkMove(originLetter, originNum, newLetter, newNum);
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
	 * @param letter
	 * @return
	 * translate letter chess notation to double array
	 */
	private int letterTranslation(String letter)
	{
		String a = "a";
		return letter.charAt(0) - a.charAt(0);
	}

	/**
	 * @param num
	 * @return
	 * translate number chess notation to double array
	 */
	private int numberTranslation(String num)
	{
		String eight = "8";
		return eight.charAt(0) - num.charAt(0);
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