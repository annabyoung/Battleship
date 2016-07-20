import javax.swing.SwingUtilities;

public class Battleship {
	public static void main(String[] args) {
		//new GameGrid(3,3); //new ButtonGrid with 2 parameters
		Battleship game = new Battleship(11,11);
		
	}
	
	public Battleship(int boardSizeX, int boardSizeY){
		//GameGrid gameGrid = new GameGrid(boardSizeX, boardSizeY);
		new GameGrid(boardSizeX, boardSizeY);
	}
}
