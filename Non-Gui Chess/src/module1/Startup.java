package module1;

public class Startup {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Board board = new Board();
		InformationReader reader = new InformationReader("ChessPlacement.txt", board);
		reader.end();
	}

}
