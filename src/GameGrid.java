

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameGrid {
	private JFrame gameFrame = new JFrame("Game Grid"); //create gameFrame
	private JPanel gamePanel = new JPanel();//create panel
	private JButton[][] grid; //names the grid of buttons
	private Container container = gameFrame.getContentPane();
	private JButton panelButton;
	
	public GameGrid() {
		
	}
	
	public GameGrid(int width, int length){ //take grid parameters
		//set grid's layout
		String letters[] = {" X ","A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		String numbers[] = {" X ", "1","2","3","4","5","6","7","8","9","10"};
		gameFrame.setLayout(new GridLayout(width,length));
		gamePanel.setLayout(new GridBagLayout());
		gamePanel.setPreferredSize(new Dimension(340, 340));
		grid = new JButton[width][length];
		//nested for loop to display values on each button
		for (int y=0; y<length; y++){
			for(int x = 0; x< width; x++){	
				GridBagConstraints constraint = new GridBagConstraints();
				//number each column of the grid
				if(y == 0){					
					panelButton = new JButton(numbers[x]);
					constraint.fill = GridBagConstraints.BOTH;
					constraint.weightx = .5;
					constraint.weighty = .5;
					constraint.gridx = x;
					constraint.gridy = y;
					
					gamePanel.add(panelButton, constraint);
				} 
				//put letters for each row of the grid
				else if (x == 0 && y>0){
					panelButton = new JButton(letters[y]);
					constraint.fill = GridBagConstraints.BOTH;
					constraint.weightx = .5;
					constraint.weighty = .5;
					constraint.gridx = x;
					constraint.gridy = y;
					gamePanel.add(panelButton, constraint);
				}
				//testing to display ship to hard coded spot
				else if (x == 2 && y == 2){
					//grid[x][y] = new JButton();
					panelButton = new JButton();
					try { //insert image onto a certain tile
						Image img = ImageIO.read(getClass().getResource("/images/battleship-4.png"));
						panelButton.setIcon(new ImageIcon (img));
						constraint.fill = GridBagConstraints.BOTH;
						constraint.weightx = .5;
						constraint.weighty = .5;
						constraint.gridx = x;
						constraint.gridy = y;
						gamePanel.add(panelButton, constraint);
						//need to see if image can be stretched to cover two buttons?
					} catch (IOException ex){}
				}
				else {
					panelButton = new JButton("("+letters[y]+","+x+")");
					constraint.fill = GridBagConstraints.BOTH;
					constraint.weightx = .5;
					constraint.weighty = .5;
					constraint.gridx = x;
					constraint.gridy = y;
					gamePanel.add(panelButton, constraint);
				}
			}
		}
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//gameFrame.add(gamePanel);
		//gameFrame.setPreferredSize(new Dimension(400,400));
		gameFrame.setContentPane(gamePanel);
		gameFrame.pack();
		gameFrame.setVisible(true);
		
		
	}
	
	
	

}
