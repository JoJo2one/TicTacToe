package ticTacToe;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToePlay extends JFrame implements ActionListener{
	
	ArrayList<Integer> position = new ArrayList<Integer>();
	
	JButton tl;
	JButton tm;
	JButton tr;
	JButton ml;
	JButton mm;
	JButton mr;
	JButton bl;
	JButton bm;
	JButton br;
	
	//used for grid design :)
	JButton lLine;
	JButton rLine;
	JButton tLine;
	JButton bLine;
	
	String play;
	
	Random random = new Random();
	
	//player v player button or player v AI button
	int whomst;
	
	// for player v player
	int turn;
	
	TicTacToePlay(int whomst){
		
		this.setSize(600,620);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		tl = new JButton();
		tm = new JButton();
		tr = new JButton();
		ml = new JButton();
		mm = new JButton();
		mr = new JButton();
		bl = new JButton();
		bm = new JButton();
		br = new JButton();
		
		position.add(0);
		position.add(1);
		position.add(2);
		position.add(3);
		position.add(4);
		position.add(5);
		position.add(6);
		position.add(7);
		position.add(8);
		
		tl.setBounds(0,0,195,195);
		tm.setBounds(205,0,190,195);
		tr.setBounds(405,0,190,195);
		ml.setBounds(0,205,195,190);
		mm.setBounds(205,205,190,190);
		mr.setBounds(405,205,190,190);
		bl.setBounds(0,405,195,195);
		bm.setBounds(205,405,190,195);
		br.setBounds(405,405,195,195);
		
		tl.addActionListener(this);
		tm.addActionListener(this);
		tr.addActionListener(this);
		ml.addActionListener(this);
		mm.addActionListener(this);
		mr.addActionListener(this);
		bl.addActionListener(this);
		bm.addActionListener(this);
		br.addActionListener(this);
		
		//working gird design:
		lLine = new JButton();
		rLine = new JButton();
		tLine = new JButton();
		bLine = new JButton();
		lLine.setBounds(195,0,10,600);
		rLine.setBounds(395,0,10,600);
		tLine.setBounds(0,195,600,10);
		bLine.setBounds(0,395,600,10);
		lLine.setBackground(Color.green);
		rLine.setBackground(Color.green);
		tLine.setBackground(Color.green);
		bLine.setBackground(Color.green);
		lLine.setBorder(null);
		rLine.setBorder(null);
		tLine.setBorder(null);
		bLine.setBorder(null);
		lLine.setEnabled(false);
		rLine.setEnabled(false);
		tLine.setEnabled(false);
		bLine.setEnabled(false);
		
		this.add(tl);
		this.add(tm);
		this.add(tr);
		this.add(ml);
		this.add(mm);
		this.add(mr);
		this.add(bl);
		this.add(bm);
		this.add(br);
				
		this.add(lLine);
		this.add(rLine);
		this.add(tLine);
		this.add(bLine);
		
		this.setVisible(true);
		
		play = "play";
		
		this.whomst = whomst;
	
		turn = 1;
		
		this.setVisible(true);
		
		
	}

	//grid design (doesn't work :( )
		/*public void paint(Graphics g) {
			Graphics2D g2D = (Graphics2D)g;
			//left vertical line
			g2D.drawLine(200, 0, 200, 600);
			//right vertical line
			g2D.drawLine(400, 0, 400, 600);
			//top horizontal line
			g2D.drawLine(0, 200, 600, 200);
			//bottom horizontal line
			g2D.drawLine(0, 400, 600, 400);
		}*/
	
	public void myAi() {
		//if the player v AI button was clicked
		if(play == "play") {
			//will get a random number from the current size of the arraylist
			int randomNumb = random.nextInt(position.size());
			//will then remove this position
			int availablePosition = position.get(randomNumb);

			position.remove(randomNumb);
				
			if(availablePosition == 0) {
				tl.setBackground(Color.red);
				tl.setEnabled(false);
				scoring();
			}
			else if(availablePosition == 1) {
						
				tm.setBackground(Color.red);
				tm.setEnabled(false);
				scoring();
			}
					
			else if(availablePosition == 2) {
						
				tr.setBackground(Color.red);
				tr.setEnabled(false);
				scoring();
			}
					
			else if(availablePosition == 3) {
						
				ml.setBackground(Color.red);
				ml.setEnabled(false);
				scoring();
						
			}
			else if(availablePosition == 4) {
						
				mm.setBackground(Color.red);
				mm.setEnabled(false);
				scoring();
			}
					
			else if(availablePosition == 5) {
					
				mr.setBackground(Color.red);
				mr.setEnabled(false);
				scoring();
						
						
			}
					
			else if(availablePosition == 6) {
						
				bl.setBackground(Color.red);
				bl.setEnabled(false);
				scoring();
					
			}
					
			else if(availablePosition == 7) {
						
				bm.setBackground(Color.red);
				bm.setEnabled(false);
				scoring();
						
			}
					
			else if(availablePosition == 8) {
						
				br.setBackground(Color.red);
				br.setEnabled(false);
				scoring();
			}
		
		}
		
	}
	
	//a value gets passed into this method which will sort out removing a specific value from an index
		public void removeIndex(int valuee) {
		
			for(int i=0; i<position.size(); i++) {
				//if that index contains the value that is passed in
				if(position.get(i) == valuee) {
					//remove that index
					position.remove(i);
				}
			}
			
		}
		
		public void scoring() {
			
			//if the player scores
			if(mm.getBackground() == Color.blue && ml.getBackground() == Color.blue && mr.getBackground() == Color.blue || // Middle Line (left to right)
			   tl.getBackground() == Color.blue && tm.getBackground() == Color.blue && tr.getBackground() == Color.blue || // Top Line (left to right)
			   bl.getBackground() == Color.blue && bm.getBackground() == Color.blue && br.getBackground() == Color.blue || // Bottom Line (left to right)
			   tl.getBackground() == Color.blue && mm.getBackground() == Color.blue && br.getBackground() == Color.blue || // Diagonal from top left to bottom right
		       bl.getBackground() == Color.blue && mm.getBackground() == Color.blue && tr.getBackground() == Color.blue || // Diagonal from top right to bottom left
			   tl.getBackground() == Color.blue && ml.getBackground() == Color.blue && bl.getBackground() == Color.blue || // Left line (top to bottom)
			   tm.getBackground() == Color.blue && mm.getBackground() == Color.blue && bm.getBackground() == Color.blue || // Middle line (top to bottom)
			   tr.getBackground() == Color.blue && mr.getBackground() == Color.blue && br.getBackground() == Color.blue) { // Right line (top to bottom)
				
				play = "no";
				if(whomst == 1) {
					int answer = JOptionPane.showConfirmDialog(null, "Congratulations, You Have Won :). Wanna Play Agian?", "Winnerrr",JOptionPane.YES_NO_OPTION);
				
					if(answer == 0) {
						this.dispose();
						TicTacToeSelect tttSelect = new TicTacToeSelect();	
					}
					else if(answer == 1) {
						this.dispose();
						TicTacToeMainMenu ticTacToe = new TicTacToeMainMenu();
					}
				}
				
				else if(whomst == 2) {
					
					int answer = JOptionPane.showConfirmDialog(null, "Congratulations, Player one has Won :) (Sorry Player 2 :( ). Wanna Play Agian?", "Winnerrr",JOptionPane.YES_NO_OPTION);
					
					if(answer == 0) {
						this.dispose();
						TicTacToeSelect tttSelect = new TicTacToeSelect();	
					}
					else if(answer == 1) {
						this.dispose();
						TicTacToeMainMenu ticTacToe = new TicTacToeMainMenu();
					}
					
				}
				
				
			}
			
			//if the AI or other player scores 
			else if(mm.getBackground() == Color.red && ml.getBackground() == Color.red && mr.getBackground() == Color.red ||
					tl.getBackground() == Color.red && tm.getBackground() == Color.red && tr.getBackground() == Color.red ||
					bl.getBackground() == Color.red && bm.getBackground() == Color.red && br.getBackground() == Color.red ||
					tl.getBackground() == Color.red && mm.getBackground() == Color.red && br.getBackground() == Color.red ||
					bl.getBackground() == Color.red && mm.getBackground() == Color.red && tr.getBackground() == Color.red ||
					tl.getBackground() == Color.red && ml.getBackground() == Color.red && bl.getBackground() == Color.red ||
					tm.getBackground() == Color.red && mm.getBackground() == Color.red && bm.getBackground() == Color.red ||
					tr.getBackground() == Color.red && mr.getBackground() == Color.red && br.getBackground() == Color.red) {
				
				play = "no";
				
				if(whomst == 1) {
					int answer = JOptionPane.showConfirmDialog(null, "You've lost! TO A TERRIBLE AI, how embarrasing :O. Wanna Play Agian?", "Loserrr",JOptionPane.YES_NO_OPTION);
	
					if(answer == 0) {
						this.dispose();
						TicTacToeSelect tttSelect = new TicTacToeSelect();	
					}
					else if(answer == 1) {
						this.dispose();
						TicTacToeMainMenu ticTacToe = new TicTacToeMainMenu();
					}
				}
				
				else if(whomst == 2) {
					
					int answer = JOptionPane.showConfirmDialog(null, "Congratulations, Player 2 has won :) (Sorry Player 1 :( ). Wanna Play Agian?", "Winnerrr",JOptionPane.YES_NO_OPTION);
					
					if(answer == 0) {
						this.dispose();
						TicTacToeSelect tttSelect = new TicTacToeSelect();	
					}
					else if(answer == 1) {
						this.dispose();
						TicTacToeMainMenu ticTacToe = new TicTacToeMainMenu();
					}
				}
				
			}
			 
			//if no one scores
			else if(tl.isEnabled() == false && tm.isEnabled() == false && tr.isEnabled() == false &&
					ml.isEnabled() == false && mm.isEnabled() == false && mr.isEnabled() == false &&
					bl.isEnabled() == false && bm.isEnabled() == false && br.isEnabled() == false) {
				
				play = "no";
				
				int answer = JOptionPane.showConfirmDialog(null, "You've both lost! how sad :(  Wanna Play Again?", "Loserrr",JOptionPane.YES_NO_OPTION);

				if(answer == 0) {
					this.dispose();
					TicTacToeSelect tttSelect = new TicTacToeSelect();	
				}
				else if(answer == 1) {
					this.dispose();
					TicTacToeMainMenu ticTacToe = new TicTacToeMainMenu();
				}
				
				
			}
			
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//if the game is going
		if(play == "play") {
			//when the button is clicked
			if(e.getSource()==tl) {
				//if the player vs AI button was clicked
				if(whomst == 1) {
					tl.setBackground(Color.blue);
					
					//position.remove(0); removes whatever the value is at index 0, 
					//doesn't remove the actual value which is 0
					//after first go, the top middle button will now be at index 0
					
					// works for first time around since size is 0-8 (9 elements)
					// however as soon as an index is removed the size of the arrayList goes down
					// therefore clicking on the bottom right button which is set to 8 wouldn't work
					// since the index is now 0-7 instead of 0-8
					
					//get the position within the array list that contains the value 0
					
					/*this will go through each index within the arrayList
					for(int i=0; i<position.size(); i++) {
						//if that index contains the value 0
						if(position.get(i) == 0) {
							//remove that index
							position.remove(i);
						}
					}
					*/
					
					//does the above but only utilises one if statement instead of many for each button
					removeIndex(0);
					tl.setEnabled(false); //makes it so that the player can't press the button anymore
					scoring();// checks to see if the player has gotten a line 
					myAi(); //calls the poundland AI
					
				}
				
				//if the player Vs player button was clicked
				else if(whomst == 2) {
					
					//if it's player 1s go
					if(turn == 1) {
						
						tl.setBackground(Color.blue);
						tl.setEnabled(false);
						scoring();
						
						//just the same as above apart from it doesn't need an ArrayList and myAI
						//doesn't need to be called
						
						turn = 2;
						
					}
					
					//if it's player 2s go
					else if(turn == 2) {
						
						tl.setBackground(Color.red);
						tl.setEnabled(false);
						scoring();
						turn = 1;
					}
						
				}
				
			}
			else if(e.getSource()==tm) {
				if(whomst == 1) {
					tm.setBackground(Color.blue);
					removeIndex(1);
					tm.setEnabled(false);
					scoring();
					myAi();
				}
				if(whomst == 2) {
					if(turn == 1) {
						tm.setBackground(Color.blue);
						tm.setEnabled(false);
						scoring();
						turn = 2;
					}
					else if(turn == 2) {
						tm.setBackground(Color.red);
						tm.setEnabled(false);
						scoring();
						turn = 1;
					}

				}
			}
			
			else if(e.getSource()==tr) {
				
				if(whomst == 1) {
					tr.setBackground(Color.blue);
					removeIndex(2);
					tr.setEnabled(false);
					scoring();
					myAi();
				}
				if(whomst == 2) {
					if(turn == 1) {
						tr.setBackground(Color.blue);
						tr.setEnabled(false);
						scoring();
						turn = 2;
					}
					else if(turn == 2) {
						tr.setBackground(Color.red);
						tr.setEnabled(false);
						scoring();
						turn = 1;
					}

				}
			}
			
			else if(e.getSource()==ml) {
				
				if(whomst == 1) {
					ml.setBackground(Color.blue);
					removeIndex(3);
					ml.setEnabled(false);
					scoring();
					myAi();
				}
				if(whomst == 2) {
					if(turn == 1) {
						ml.setBackground(Color.blue);
						ml.setEnabled(false);
						scoring();
						turn = 2;
					}
					else if(turn == 2) {
						ml.setBackground(Color.red);
						ml.setEnabled(false);
						scoring();
						turn = 1;
					}

				}
				
			}
			else if(e.getSource()==mm) {
				
				if(whomst == 1) {
					mm.setBackground(Color.blue);
					removeIndex(4);
					mm.setEnabled(false);
					scoring();
					myAi();
				}
				if(whomst == 2) {
					if(turn == 1) {
						mm.setBackground(Color.blue);
						mm.setEnabled(false);
						scoring();
						turn = 2;
					}
					else if(turn == 2) {
						mm.setBackground(Color.red);
						mm.setEnabled(false);
						scoring();
						turn = 1;
					}

				}
				
			}
			
			else if(e.getSource()==mr) {
				if(whomst == 1) {
					mr.setBackground(Color.blue);
					removeIndex(5);
					mr.setEnabled(false);
					scoring();
					myAi();
				}
				if(whomst == 2) {
					if(turn == 1) {
						mr.setBackground(Color.blue);
						mr.setEnabled(false);
						scoring();
						turn = 2;
					}
					else if(turn == 2) {
						mr.setBackground(Color.red);
						mr.setEnabled(false);
						scoring();
						turn = 1;
					}

				}
				
			}
			
			else if(e.getSource()==bl) {
				
				if(whomst == 1) {
					bl.setBackground(Color.blue);
					removeIndex(6);
					bl.setEnabled(false);
					scoring();
					myAi();
				}
				if(whomst == 2) {
					if(turn == 1) {
						bl.setBackground(Color.blue);
						bl.setEnabled(false);
						scoring();
						turn = 2;
					}
					else if(turn == 2) {
						bl.setBackground(Color.red);
						bl.setEnabled(false);
						scoring();
						turn = 1;
					}

				}
			}
			
			else if(e.getSource()==bm) {
				
				if(whomst == 1) {
					bm.setBackground(Color.blue);
					removeIndex(7);
					bm.setEnabled(false);
					scoring();
					myAi();
				}
				if(whomst == 2) {
					if(turn == 1) {
						bm.setBackground(Color.blue);
						bm.setEnabled(false);
						scoring();
						turn = 2;
					}
					else if(turn == 2) {
						bm.setBackground(Color.red);
						bm.setEnabled(false);
						scoring();
						turn = 1;
					}

				}
				
			}
			
			else if(e.getSource()==br) {
				
				if(whomst == 1) {
					br.setBackground(Color.blue);
					removeIndex(8);
					br.setEnabled(false);
					scoring();
					myAi();
				}
				if(whomst == 2) {
					if(turn == 1) {
						br.setBackground(Color.blue);
						br.setEnabled(false);
						scoring();
						turn = 2;
					}
					else if(turn == 2) {
						br.setBackground(Color.red);
						br.setEnabled(false);
						scoring();
						turn = 1;
					}

				}
			
			}
			
		}
		
	}
	
	
}
