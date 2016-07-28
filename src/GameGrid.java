
<<<<<<< HEAD

=======
//This is Annabelle's Program
import java.awt.Container;
>>>>>>> 7d7a19f0893c1f78408ea0119b202382c7b3b708
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameGrid {
	private JFrame gameFrame = new JFrame("Game Grid"); //create gameFrame
	private JPanel gamePanel = new JPanel();//create panel
	private JButton panelButton;
	//private static final int N = 11;
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	public GameGrid(){}
	
	public GameGrid(JFrame gameFrame, JPanel gamePanel) {
		this.gameFrame = gameFrame;
		this.gamePanel = gamePanel;
	}
	
	public GameGrid(int width, int length, int bounds1, int bounds2, String title){ //take grid parameters
		//set grid's layout
		String letters[] = {" X ","A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		String numbers[] = {" X ", "1","2","3","4","5","6","7","8","9","10"};
		gameFrame.setLayout(new GridLayout(width,length));
		gamePanel.setLayout(new GridBagLayout());
		gamePanel.setPreferredSize(new Dimension(800, 800));
		
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
				else {
					panelButton = new JButton("("+letters[y]+","+x+")");
					constraint.fill = GridBagConstraints.BOTH;
					constraint.weightx = .5;
					constraint.weighty = .5;
					constraint.gridx = x;
					constraint.gridy = y;
					gamePanel.add(panelButton, constraint);
					buttons.add(panelButton);
					panelButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							Image img = null;
							GridBagConstraints constraint = new GridBagConstraints();
						
							JButton gb = (JButton) e.getSource(); //get location of click
							
							try {
								img = ImageIO.read(getClass().getResource("/images/battleship-6.png"));
					
								constraint.fill = GridBagConstraints.BOTH;
								constraint.weightx = .5;
								constraint.weighty = .5;
								
							} catch (IOException exception) {
								exception.printStackTrace();
							}
							gb.setText("");
							gb.setIcon(new ImageIcon(img)); //set image to icon
							
							gamePanel.revalidate();
							gamePanel.repaint();
							
						}
					});
				}
			}
		}
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameFrame.setTitle(title);
		gameFrame.setContentPane(gamePanel);
		gameFrame.setBounds(bounds1,bounds2,800,800); //have boards display side by side
		gameFrame.pack();
		gameFrame.setVisible(true);
		GameField gameField = new GameField(gameFrame, gamePanel);
		
	}

	public JFrame getGameFrame() {
		return gameFrame;
	}

	public void setGameFrame(JFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public JPanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(JPanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	/*
	public JButton getButton(int w, int z){
		int index = w * N + z;
		return buttons.get(index);
	}
	
	public void removeButton(int x, int y){
		gamePanel.remove(getButton(x,y));
	}
	*/
	
}
