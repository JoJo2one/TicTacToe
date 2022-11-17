package ticTacToe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TicTacToeSelect extends JFrame implements ActionListener{
	
	JButton btnPvB;
	JButton btnPvP;
	JButton btnMain;
	
	TicTacToeSelect(){
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//player v poundland AI
		btnPvB = new JButton("Player vs Computer");
		btnPvB.setBounds(20,20,200,50);
		btnPvB.addActionListener(this);
		
		//player v player
		btnPvP = new JButton("Player 1 (blue) Vs Player 2 (red)");
		btnPvP.setBounds(20,150,250,50);
		btnPvP.addActionListener(this);
		
		//back to main menu
		btnMain = new JButton("Back to menu");
		btnMain.setBounds(20,300,150,50);
		btnMain.addActionListener(this);
	
		this.add(btnPvB);
		this.add(btnPvP);
		this.add(btnMain);
		this.setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPvB) {
			this.dispose();
			TicTacToePlay playAI = new TicTacToePlay(1);	
		}
		else if(e.getSource()==btnPvP) {	
			this.dispose();
			TicTacToePlay play = new TicTacToePlay(2);
		}
		else if(e.getSource()==btnMain) {
			this.dispose();
			TicTacToeMainMenu tttMain = new TicTacToeMainMenu();
		}
	}
}