package module1;

public class Startup {

	/**
	 * @param args
	 * main method
	 */
	public static void main(String[] args) 
	{
		Board board = new Board();
		InformationReader reader = new InformationReader(args[0], board);
		reader.end();
		System.out.println("UpperCase is light chess piece");
	}

}
