package ticTacToe;
import javax.swing.JButton;

import javax.swing.JFrame;

import main.MainPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeMainMenu extends JFrame implements ActionListener{
	
	JButton play;
	JButton quit;
	JButton exit;
	
	TicTacToeSelect tttSelect;
	
	public TicTacToeMainMenu(){
		
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		play = new JButton("Play Tic Tac Toe");
		quit = new JButton("Quit to main menu");
		exit = new JButton("Exit the application");
		
		play.setBounds(175,10,150,50);
		quit.setBounds(175,70,150,50);
		exit.setBounds(175,150,150,50);
		
		play.addActionListener(this);
		quit.addActionListener(this);
		exit.addActionListener(this);
		
		
		this.add(play);
		this.add(quit);
		this.add(exit);
		
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==play) {
			this.dispose();
			tttSelect = new TicTacToeSelect();
		}
		
		else if(e.getSource()==quit) {
			this.dispose();
			MainPage main = new MainPage();
			
		}
		
		else if(e.getSource()==exit) {
			
			this.dispose();
			
		}
	}

}
