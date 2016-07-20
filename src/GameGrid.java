
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GameGrid {
	private JFrame gameFrame = new JFrame("Game Grid"); //create gameFrame
	private JButton[][] grid; //names the grid of buttons
	
	public GameGrid(int width, int length){ //take grid parameters
		//set grid's layout
		String letters[] = {" X ","A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		String numbers[] = {" X ", "1","2","3","4","5","6","7","8","9","10"};
		gameFrame.setLayout(new GridLayout(width,length)); 
		grid = new JButton[width][length];
		for (int y=0; y<length; y++){
			for(int x = 0; x< width; x++){				
				//number each column of the grid
				if(y == 0){
					grid[x][y] = new JButton(numbers[x]);
					gameFrame.add(grid[x][y]); 
				} 
				//put letters for each row of the grid
				else if (x == 0 && y>0){
					grid[x][y] = new JButton(letters[y]);
					gameFrame.add(grid[x][y]); 
				}
				else if (x == 2 && y == 2){
					grid[x][y] = new JButton();
					try { //insert image onto a certain tile
						Image img = ImageIO.read(getClass().getResource("/images/battleship-1.png"));
						grid[x][y].setIcon(new ImageIcon(img));
						gameFrame.add(grid[x][y]);
						//need to see if image can be stretched to cover two tiles?
					} catch (IOException ex){}
				}
				else {
					grid[x][y] = new JButton("("+letters[y]+","+x+")"); 
					gameFrame.add(grid[x][y]); //adding the buttons to the gameFrame
				}
			}
		}

		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.pack();
		gameFrame.setVisible(true);
		
		
	}
	

}
