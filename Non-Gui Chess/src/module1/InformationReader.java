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
	Matcher piecePlace;
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

				if(piecePlace.find())
				{
					if(piecePlace.group(3).equals("1"))
					{
						placeFirstRow();
					}
					else if(piecePlace.group(3).equals("2"))
					{
						placeSecondRow();
					}
					else if(piecePlace.group(3).equals("7"))
					{
						placeSeventhRow();
					}
					else if(piecePlace.group(3).equals("8"))
					{
						placeEightRow();
					}
				}
			}
		} 
		catch (IOException e) 
		{
			System.err.println("IO exception");
		}
	}

	private void placeFirstRow() 
	{
		if(piecePlace.group(2).equals("a"))
		{
			b.setBoard(7, 0, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("b"))
		{
			b.setBoard(7, 1, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("c"))
		{
			b.setBoard(7, 2, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("d"))
		{
			b.setBoard(7, 3, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("e"))
		{
			b.setBoard(7, 4, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("f"))
		{
			b.setBoard(7, 5, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("g"))
		{
			b.setBoard(7, 6, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("h"))
		{
			b.setBoard(7, 7, piecePlace.group(1));
		}
	}
	
	private void placeSecondRow()
	{
		if(piecePlace.group(2).equals("a"))
		{
			b.setBoard(6, 0, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("b"))
		{
			b.setBoard(6, 1, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("c"))
		{
			b.setBoard(6, 2, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("d"))
		{
			b.setBoard(6, 3, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("e"))
		{
			b.setBoard(6, 4, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("f"))
		{
			b.setBoard(6, 5, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("g"))
		{
			b.setBoard(6, 6, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("h"))
		{
			b.setBoard(6, 7, piecePlace.group(1));
		}
	}
	
	private void placeSeventhRow()
	{
		if(piecePlace.group(2).equals("a"))
		{
			b.setBoard(1, 0, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("b"))
		{
			b.setBoard(1, 1, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("c"))
		{
			b.setBoard(1, 2, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("d"))
		{
			b.setBoard(1, 3, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("e"))
		{
			b.setBoard(1, 4, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("f"))
		{
			b.setBoard(1, 5, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("g"))
		{
			b.setBoard(1, 6, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("h"))
		{
			b.setBoard(1, 7, piecePlace.group(1));
		}
	}

	private void placeEightRow()
	{
		if(piecePlace.group(2).equals("a"))
		{
			b.setBoard(0, 0, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("b"))
		{
			b.setBoard(0, 1, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("c"))
		{
			b.setBoard(0, 2, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("d"))
		{
			b.setBoard(0, 3, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("e"))
		{
			b.setBoard(0, 4, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("f"))
		{
			b.setBoard(0, 5, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("g"))
		{
			b.setBoard(0, 6, piecePlace.group(1));
		}
		else if(piecePlace.group(2).equals("h"))
		{
			b.setBoard(0, 7, piecePlace.group(1));
		}
	}

	public void end()
	{
		b.displayBoard();
		System.out.println("There is no more information to parse");
	}
}