
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GameGrid {
	JFrame frame = new JFrame("Game Grid"); //create frame
	JButton[][] grid; //names the grid of buttons
	
	public GameGrid(int width, int length){
		frame.setLayout(new GridLayout(width,length));
		grid = new JButton[width][length];
		for (int y=0; y<length; y++){
			for(int x = 0; x< width; x++){
				grid[x][y] = new JButton("("+x+","+y+")"); 
				frame.add(grid[x][y]); //adding the buttons to the frame
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameGrid(3,3); //new ButtonGrid with 2 parameters
	}

}
