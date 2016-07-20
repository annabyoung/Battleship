
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GameGrid {
	JFrame gameFrame = new JFrame("Game Grid"); //create gameFrame
	private JButton[][] grid; //names the grid of buttons
	private JPanel gamePanel = new JPanel();
	
	public GameGrid() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		this.gameFrame = gameFrame;
		//panel's settings
		gamePanel.setLayout(new GridBagLayout());
		gamePanel.setPreferredSize(new Dimension(340,340));
		gamePanel.setBackground(new Color(131, 209, 232));
		gamePanel.setBorder(BorderFactory.createLineBorder(new Color(32,156,185)));
		
		//this.setTitle("Battleship");
	}
	
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
				else {
					grid[x][y] = new JButton("("+x+","+y+")"); 
					gameFrame.add(grid[x][y]); //adding the buttons to the gameFrame
				}
			}
		}
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.pack();
		gameFrame.setVisible(true);
	}
	
	public void displayShip(String type, int x, int y, boolean horizontal, int length){
		 //create new button
		JButton button = new JButton();
		button.setOpaque(false); 
		button.setContentAreaFilled(false); //make transparent
		button.setCursor(new Cursor(Cursor.HAND_CURSOR)); //sets cursor image
		button.setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
		
		//button dimensions
		int width = 34;
		int height = 34;
		
		//set constraints for new button
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.BOTH; //fill display area entirely
		constraint.gridx = x; 
		constraint.gridy = y;
		
		if(horizontal){
			//horizontal = true
			constraint.gridwidth = length;
			constraint.gridheight = 1;
			width = 34*length;
		} else {
			//horizontal = false AKA vertical
			constraint.gridwidth  = 1;
			constraint.gridheight = length;
			height = 34 * length;
		}
		
		button.setPreferredSize(new Dimension(width, height));
		
		gamePanel.add(button, constraint); //add button with constraints to panel
		gamePanel.revalidate(); //
		gamePanel.repaint();
		
	}
	

}
