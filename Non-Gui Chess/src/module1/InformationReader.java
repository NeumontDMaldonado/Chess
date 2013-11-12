package module1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationReader 
{
	private Board b;
	public String line;
	private final String PIECEPLACEMENT = "([RNMBQKP][ld])([a-h])([1-8])";
	private final String PIECEMOVEMENT = "[a-h][1-8] [a-h][1-8]";
//	public final int A = 7, B = 6, C = 5, D = 4, F = 3, G = 2, H = 1;
//	int place = 2;
	int chessLetter, chessNum;
	Matcher piecePlace, pieceMove;
	/**
	 * @param args
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
		this.b = b;
		read(buff);
	}

	public void read(BufferedReader buff)
	{
		try 
		{
			while(buff.ready())
			{
				line = buff.readLine();
				Pattern piecePlacement = Pattern.compile(PIECEPLACEMENT);
				piecePlace = piecePlacement.matcher(line);
				Pattern pieceMovement = Pattern.compile(PIECEMOVEMENT);
				pieceMove = pieceMovement.matcher(line);
				
				if(piecePlace.find())
				{
					translateToDoubleArray(piecePlace.group(2), piecePlace.group(3));
					b.setBoard(chessLetter, chessNum, piecePlace.group(1));
				}
				else if(pieceMove.find())
				{
					moveChessPiece();
				}
				else
				{
					System.err.println("Not a valid input");
				}
			}
		} 
		catch (IOException e) 
		{
			System.err.println("IO exception");
		}
	}

	public void translateToDoubleArray(String letter, String num)
	{
		switch (letter)
		{
		case "a": chessNum = 0;break;
		case "b": chessNum = 1;break;
		case "c": chessNum = 2;break;
		case "d": chessNum = 3;break;
		case "e": chessNum = 4;break;
		case "f": chessNum = 5;break;
		case "g": chessNum = 6;break;
		case "h": chessNum = 7;break;
		}
		
		switch (num)
		{
		case "1": chessLetter = 7;break;
		case "2": chessLetter = 6;break;
		case "3": chessLetter = 5;break;
		case "4": chessLetter = 4;break;
		case "5": chessLetter = 3;break;
		case "6": chessLetter = 2;break;
		case "7": chessLetter = 1;break;
		case "8": chessLetter = 0;break;
		}
	}
	
	private void moveChessPiece()
	{
		System.out.println("hi");
		
	}

	public void end()
	{
		b.displayBoard();
		System.out.println("There is no more information to parse");
	}
}