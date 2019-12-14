//Import Statements
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.util.Random;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeListener;

import javax.swing.event.ChangeEvent;
import java.awt.Component;
import javax.swing.Box;

//Main GUI Class
public class ticTacToe extends JFrame {

	//Variables
	private static boolean isXTurn = true;
	private static boolean winner = false;
	private static int playAgain = 0;
	private static int[] scores = new int[2];
	private static Object difficulty = "";
	private static boolean placed = false;
	
	private static Random rand = new Random();
	
	//Components
	private static JPanel contentPane;
	private static JLabel scoreLabel;
	private static JLabel disp;
	private JSpinner diffSelect;
	private JButton restartBt;
	private Component horizontalStrut;
		
	//Win Condition Function
	public static void winCheck (JButton bt) {
		if (bt.equals(board[0][0])) {
			//Top Row
			if ((board[0][0].getText().equals(board[0][1].getText())) && (board[0][0].getText().equals(board[0][2].getText()))) {
				winner = true;
			}
			
			//Top Column
			else if (board[0][0].getText().equals(board[1][0].getText()) && board[0][0].getText().equals(board[2][0].getText())) {
				winner = true;
			}
			
			//Diagonal from top left
			else if ((board[0][0].getText().equals(board[1][1].getText())) && (board[0][0].getText().equals(board[2][2].getText()))) {
				winner = true;
			}
			
			//Draw
			else if (!board[0][0].getText().equals("") && !board[0][1].getText().equals("") && !board[0][2].getText().equals("") && !board[1][0].getText().equals("") && !board[1][1].getText().equals("") && !board[1][2].getText().equals("") && !board[2][0].getText().equals("") && !board[2][1].getText().equals("") && !board[2][2].getText().equals("")) {
				playAgain = JOptionPane.showOptionDialog(contentPane, "Draw! Play Again?", "Draw!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
					System.exit(0);
				
				}
			}
		}

		else if (bt.equals(board[0][1])) {
			//Middle column
			if ((board[0][1].getText().equals(board[1][1].getText())) && (board[0][1].getText().equals(board[2][1].getText()))) {
				winner = true;
			}
			
			//Top row
			else if ((board[0][1].getText().equals(board[0][0].getText())) && (board[0][1].getText().equals(board[0][2].getText()))) {
				winner = true;
			}
			
			//Draw
			else if (!board[0][0].getText().equals("") && !board[0][1].getText().equals("") && !board[0][2].getText().equals("") && !board[1][0].getText().equals("") && !board[1][1].getText().equals("") && !board[1][2].getText().equals("") && !board[2][0].getText().equals("") && !board[2][1].getText().equals("") && !board[2][2].getText().equals("")) {
				playAgain = JOptionPane.showOptionDialog(contentPane, "Draw! Play Again?", "Draw!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					isXTurn = false;
					
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
					System.exit(0);
				}
			}
		}

		else if (bt.equals(board[0][2])) {
			//Top column
			if ((board[0][2].getText().equals(board[1][2].getText())) && (board[0][2].getText().equals(board[2][2].getText()))) {
				winner = true;
			}
			
			//Top row
			else if ((board[0][2].getText().equals(board[0][1].getText())) && (board[0][2].getText().equals(board[0][0].getText()))) {
				winner = true;
			}
			
			//Diagonal from top right
			else if ((board[0][2].getText().equals(board[1][1].getText())) && (board[0][2].getText().equals(board[2][0].getText()))) {
				winner = true;
			}
			
			//Draw
			else if (!board[0][0].getText().equals("") && !board[0][1].getText().equals("") && !board[0][2].getText().equals("") && !board[1][0].getText().equals("") && !board[1][1].getText().equals("") && !board[1][2].getText().equals("") && !board[2][0].getText().equals("") && !board[2][1].getText().equals("") && !board[2][2].getText().equals("")) {
				playAgain = JOptionPane.showOptionDialog(contentPane, "Draw! Play Again?", "Draw!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					isXTurn = false;
					
				
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
					System.exit(0);
				}
			}
		}
		
		else if (bt.equals(board[1][0])) {
			//Middle row
			if ((board[1][0].getText().equals(board[1][1].getText())) && (board[1][0].getText().equals(board[1][2].getText()))) {
				winner = true;
			}
			
			//Top left column
			else if ((board[1][0].getText().equals(board[0][0].getText())) && (board[1][0].getText().equals(board[2][0].getText()))) {
				winner = true;
			}
			
			//Draw
			else if (!board[0][0].getText().equals("") && !board[0][1].getText().equals("") && !board[0][2].getText().equals("") && !board[1][0].getText().equals("") && !board[1][1].getText().equals("") && !board[1][2].getText().equals("") && !board[2][0].getText().equals("") && !board[2][1].getText().equals("") && !board[2][2].getText().equals("")) {
				playAgain = JOptionPane.showOptionDialog(contentPane, "Draw! Play Again?", "Draw!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					isXTurn = false;
					
		
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
					System.exit(0);
				}
			}
		}

		else if (bt.equals(board[1][1])) {
			//Middle column
			if ((board[1][1].getText().equals(board[0][1].getText())) && (board[1][1].getText().equals(board[2][1].getText()))) {
				winner = true;
			}
			
			//middle row
			else if ((board[1][1].getText().equals(board[1][0].getText())) && (board[1][1].getText().equals(board[1][2].getText()))) {
				winner = true;
			}
			
			//Diagonal from top left
			else if ((board[1][1].getText().equals(board[0][0].getText())) && (board[1][1].getText().equals(board[2][2].getText()))) {
				winner = true;
			}
			
			//Diagonal from top right
			else if ((board[1][1].getText().equals(board[0][2].getText())) && (board[1][1].getText().equals(board[2][0].getText()))) {
				winner = true;
			}
			
			//Draw
			else if (!board[0][0].getText().equals("") && !board[0][1].getText().equals("") && !board[0][2].getText().equals("") && !board[1][0].getText().equals("") && !board[1][1].getText().equals("") && !board[1][2].getText().equals("") && !board[2][0].getText().equals("") && !board[2][1].getText().equals("") && !board[2][2].getText().equals("")) {
				playAgain = JOptionPane.showOptionDialog(contentPane, "Draw! Play Again?", "Draw!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					isXTurn = false;
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
					System.exit(0);
				}
			}
		}

		else if (bt.equals(board[1][2])) {
			//Top right column
			if ((board[1][2].getText().equals(board[0][2].getText())) && (board[1][2].getText().equals(board[2][2].getText()))) {
				winner = true;
			}
			
			//Middle row
			else if ((board[1][2].getText().equals(board[1][0].getText())) && (board[1][2].getText().equals(board[1][1].getText()))) {
				winner = true;
			}
			
			//Draw
			else if (!board[0][0].getText().equals("") && !board[0][1].getText().equals("") && !board[0][2].getText().equals("") && !board[1][0].getText().equals("") && !board[1][1].getText().equals("") && !board[1][2].getText().equals("") && !board[2][0].getText().equals("") && !board[2][1].getText().equals("") && !board[2][2].getText().equals("")) {
				playAgain = JOptionPane.showOptionDialog(contentPane, "Draw! Play Again?", "Draw!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					isXTurn = false;
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
					System.exit(0);
				}
			}
		}

		else if (bt.equals(board[2][0])) {
			//Top left column
			if ((board[2][0].getText().equals(board[0][0].getText())) && (board[2][0].getText().equals(board[1][0].getText()))) {
				winner = true;
			}
			
			//bottom row
			else if ((board[2][0].getText().equals(board[2][1].getText())) && (board[2][0].getText().equals(board[2][2].getText()))) {
				winner = true;
			}
			
			//Diagonal from bottom left
			else if ((board[2][0].getText().equals(board[1][1].getText())) && (board[2][0].getText().equals(board[0][2].getText()))) {
				winner = true;
			}
			
			//Draw
			else if (!board[0][0].getText().equals("") && !board[0][1].getText().equals("") && !board[0][2].getText().equals("") && !board[1][0].getText().equals("") && !board[1][1].getText().equals("") && !board[1][2].getText().equals("") && !board[2][0].getText().equals("") && !board[2][1].getText().equals("") && !board[2][2].getText().equals("")) {
				playAgain = JOptionPane.showOptionDialog(contentPane, "Draw! Play Again?", "Draw!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					isXTurn = false;
					
				
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
					System.exit(0);
				}
			}
		}

		else if (bt.equals(board[2][1])) {
			//Middle column
			if ((board[2][1].getText().equals(board[1][1].getText())) && (board[2][1].getText().equals(board[0][1].getText()))) {
				winner = true;
			}
			
			//bottom row
			else if ((board[2][1].getText().equals(board[2][0].getText())) && (board[2][1].getText().equals(board[2][2].getText()))) {
				winner = true;
			}
			
			//Draw
			else if (!board[0][0].getText().equals("") && !board[0][1].getText().equals("") && !board[0][2].getText().equals("") && !board[1][0].getText().equals("") && !board[1][1].getText().equals("") && !board[1][2].getText().equals("") && !board[2][0].getText().equals("") && !board[2][1].getText().equals("") && !board[2][2].getText().equals("")) {
				playAgain = JOptionPane.showOptionDialog(contentPane, "Draw! Play Again?", "Draw!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					isXTurn = false;
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
					System.exit(0);
				}
			}
		}

		else if (bt.equals(board[2][2])) {
			//Top right  column
			if ((board[2][2].getText().equals(board[1][2].getText())) && (board[2][2].getText().equals(board[0][2].getText()))) {
				winner = true;
			}
			
			//bottom row
			else if ((board[2][2].getText().equals(board[2][1].getText())) && (board[2][2].getText().equals(board[2][0].getText()))) {
				winner = true;
			}
			
			//Diagonal from bottom right
			else if ((board[2][2].getText().equals(board[1][1].getText())) && (board[2][2].getText().equals(board[0][0].getText()))) {
				winner = true;
			}
			
			//Draw
			else if (!board[0][0].getText().equals("") && !board[0][1].getText().equals("") && !board[0][2].getText().equals("") && !board[1][0].getText().equals("") && !board[1][1].getText().equals("") && !board[1][2].getText().equals("") && !board[2][0].getText().equals("") && !board[2][1].getText().equals("") && !board[2][2].getText().equals("")) {
				playAgain = JOptionPane.showOptionDialog(contentPane, "Draw! Play Again?", "Draw!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					isXTurn = false;
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
					System.exit(0);
				}
			}
		}
	}

	//Game End Function for PVP (in case of win)
	public static void gameEndPVP (JButton bt) {
		if (bt.getText().equals("X")) {
			scores[0] += 1;
			scoreLabel.setText("Score: X: " +scores[0]+  "  O: " + scores[1]);
			playAgain = JOptionPane.showOptionDialog(contentPane, "X Wins! Play Again?", "X Wins!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (playAgain != 1) {
				//Reset all buttons, winner variable, x turn variable, and append score
				board[0][0].setText("");
				board[0][1].setText("");
				board[0][2].setText("");
				board[1][0].setText("");
				board[1][1].setText("");
				board[1][2].setText("");
				board[2][0].setText("");
				board[2][1].setText("");
				board[2][2].setText("");
				winner = false;
				isXTurn = false;
				disp.setText("It's O's Turn");
				
			} else {
				JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
				System.exit(0);
			}
		}
		
		else if (bt.getText().equals("O")) {
			scores[1] += 1;
			scoreLabel.setText("Score: X: " +scores[0]+  "  O: " + scores[1]);
			playAgain = JOptionPane.showOptionDialog(contentPane, "O Wins! Play Again?", "O Wins!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (playAgain != 1) {
				//Reset all buttons, winner variable, x turn variable, and append score
				board[0][0].setText("");
				board[0][1].setText("");
				board[0][2].setText("");
				board[1][0].setText("");
				board[1][1].setText("");
				board[1][2].setText("");
				board[2][0].setText("");
				board[2][1].setText("");
				board[2][2].setText("");
				winner = false;
				isXTurn = false;
				disp.setText("It's O's Turn");

			} else {
				JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was X: " + scores[0] + "  , O: " + scores[1]);
				System.exit(0);
			}
		}
	}
	
	//Compairison function
	public static boolean compare(JButton original, JButton second) {
		if (original.getText().equals(second.getText())) {
			return true;
		}
		else {
			return false;
		}
	}
	//Bot Random Move function
	public static void randMove() {
		do {
			int easyBotMove = rand.nextInt(9) + 1;
			
			switch (easyBotMove) {	
				case 1:
					if (board[0][0].getText().equals("")) {
						board[0][0].setText("O");
						winCheck(board[0][0]);
						placed = true;
					}
					else {
						placed = false;
					}
					break;
					
				case 2:
					if (board[0][1].getText().equals("")) {
						board[0][1].setText("O");
						winCheck(board[0][1]);
						placed = true;
					}
					else {
						placed = false;
					}
					break;
				case 3:
					if (board[0][2].getText().equals("")) {
						board[0][2].setText("O");
						winCheck(board[0][2]);
						placed = true;
					}
					else {
						placed = false;
					}
					break;
				case 4:
					if (board[1][0].getText().equals("")) {
						board[1][0].setText("O");
						winCheck(board[1][0]);
						placed = true;
					}
					else {
						placed = false;
					}
					break;
				case 5:
					if (board[1][1].getText().equals("")) {
						board[1][1].setText("O");
						winCheck(board[1][1]);
						placed = true;
					}
					else {
						placed = false;
					}
					break;
				case 6:
					if (board[1][2].getText().equals("")) {
						board[1][2].setText("O");
						winCheck(board[1][2]);
						placed = true;
					}
					else {
						placed = false;
					}
					break;
				case 7:
					if (board[2][0].getText().equals("")) {
						board[2][0].setText("O");
						winCheck(board[2][0]);
						placed = true;
					}
					else {
						placed = false;
					}
					break;
				case 8:
					if (board[2][1].getText().equals("")) {
						board[2][1].setText("O");
						winCheck(board[2][1]);
						placed = true;
					}
					else {
						placed = false;
					}
					break;
				case 9:
					if (board[2][2].getText().equals("")) {
						board[2][2].setText("O");
						winCheck(board[2][2]);
						placed = true;
					}
					else {
						placed = false;
					}
					break;
			}	
		}
		while(!placed);	
	}
	
	//Bot Functions
	//If there is a draw don't let the bot go 
	public static boolean botMove(JButton[][] board) {
		//Check all the boxes
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				//If any box is populated that means the player has gone, so return true, allowing the bot to move
				if (!board[i][j].getText().equals("")) {
					return true;
				}
			}
		}
		//If we make it through the whole loop that means the board is empty, so return false; the bot can't move
		return false;
	}
	
	//Easy Difficulty Bot
	public static int easyBot(JButton bt) {
		//First user moves, check if box is empty
		if (!bt.getText().equals("")) {
			disp.setText("You Cannot Go Here!");			
		}

		//Check all win conditions
		else {
			bt.setText("X");
			winCheck(bt);
			
			//If winner is true end game
			if (winner) {
				scores[0] += 1;
				scoreLabel.setText("Score: X: " +scores[0]+  "  O: " + scores[1]);
				playAgain = JOptionPane.showOptionDialog(contentPane, "You Win! Play Again?", "You Win!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					return 1;
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was You: " + scores[0] + "  , Bot: " + scores[1]);
					System.exit(0);
				}	
			}

			//Otherwise Let Bot Go, ensuring the player has already gone using the botMove method
			if (botMove(board)) {
				//Generate   
				randMove();
			}
		//End game for bot victory
		if (winner) {
				scores[1] += 1;
				scoreLabel.setText("Score: X: " +scores[0]+  "  O: " + scores[1]);
				playAgain = JOptionPane.showOptionDialog(contentPane, "The Bot Wins! Play Again?", "Bot Wins!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					return 1;
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was You: " + scores[0] + "  , Bot: " + scores[1]);
					System.exit(0);
				}	
			}

		}//Else for main if statement
		return 1;
	}//Function
	
	//Medium Difficulty Bot
	public static int medBot(JButton bt) {
		//First user moves, check if box is empty
		if (!bt.getText().equals("")) {
			disp.setText("You Cannot Go Here!");			
		}

		//Check all win conditions
		else {
			bt.setText("X");
			winCheck(bt);
			
			//If winner is true end game
			if (winner) {
				scores[0] += 1;
				scoreLabel.setText("Score: X: " +scores[0]+  "  O: " + scores[1]);
				playAgain = JOptionPane.showOptionDialog(contentPane, "You Win! Play Again?", "You Win!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					return 1;
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was You: " + scores[0] + "  , Bot: " + scores[1]);
					System.exit(0);
				}	
			}//If Winner

			//Otherwise bot moves
			else {
			//Starting from top left check for all the win conditions going in each box can block
				//Top Left Bot Move
				if (bt.equals(board[0][0])) {
					if (compare(board[0][0], board[0][1]) && board[0][2].getText().equals("")) {
						if (botMove(board)) {	
							board[0][2].setText("O");
							winCheck(board[0][2]);
						}
					}
					else if (compare(board[0][0],board[0][2]) && board[0][1].getText().equals("")) {
						if (botMove(board)) {
							board[0][1].setText("O");
							winCheck(board[0][1]);
						}
					}
					else if (compare(board[0][0],board[1][0]) && board[2][0].getText().equals("")) {
						if (botMove(board)) {
							board[2][0].setText("O");
							winCheck(board[2][0]);
						}
					}
					else if (compare(board[0][0],board[2][0]) && board[1][0].getText().equals("")) {
						if (botMove(board)) {
							board[1][0].setText("O");
							winCheck(board[1][0]);
						}
					}
					else if (compare(board[0][0], board[2][2]) && board[1][1].getText().equals("")) {
						if (botMove(board)) {
							board[1][1].setText("O");
							winCheck(board[1][1]);
						}
					}
					else if (compare(board[0][0],board[1][1])) {
						if (botMove(board)) {
							board[2][2].setText("O");
							winCheck(board[2][2]);
						}
					}
					else {
						if (botMove(board)) {
							randMove();
						}
					}
				}
				else if (bt.equals(board[0][1])) {
					if (compare(board[0][1],board[0][2]) && board[0][0].getText().equals("")) {
						if (botMove(board)) {
							board[0][0].setText("O");
							winCheck(board[0][1]);
						}
					}
					else if (compare(board[0][1],board[0][0]) && board[0][2].getText().equals("")) {
						if (botMove(board)) {
							board[0][2].setText("O");
							winCheck(board[0][2]);
						}
					}
					else if (compare(board[0][1],board[1][1]) && board[2][1].getText().equals("")) {
						if (botMove(board)) {
							board[2][1].setText("O");
							winCheck(board[2][1]);
						}
					}
					else if (compare(board[0][1], board[2][1]) && board[1][1].getText().equals("")) {
						if (botMove(board)) {
							board[1][1].setText("O");
							winCheck(board[1][1]);
						}
					}
					else {
						if (botMove(board)) {
							randMove();
						}
					}
				}
				else if (bt.equals(board[0][2])) {
					//IF top row with mid empty
					if (compare(board[0][2],board[0][0]) && board[0][1].getText().equals("")) {
						if (botMove(board)) {
							board[0][1].setText("O");
							winCheck(board[0][1]);
						}
					}
					else if (compare(board[0][2],board[0][1]) && board[0][0].getText().equals("")) {
						if (botMove(board)) {
							board[0][0].setText("O");
							winCheck(board[0][0]);
						}
					}
					//Top right column when bot right is empty 
					else if (compare(board[0][2],board[1][2]) && board[2][2].getText().equals("")) {
						if (botMove(board)) {
							board[2][2].setText("O");
							winCheck(board[2][2]);
						}
					}
					//Right column when mid right is empty
					else if (compare(board[0][2],board[2][2]) && board[1][2].getText().equals("")) {
						if (botMove(board)) {
						board[1][2].setText("O");
						winCheck(board[1][2]);
						}
					}
					//Diagonal when bot left is empty
					else if (compare(board[0][2],board[1][1]) && board[2][0].getText().equals("")) {
						if (botMove(board)) {
						board[2][0].setText("O");
						winCheck(board[2][0]);
						}
					}
					//Diagonal when middle is empty
					else if (compare(board[0][2],board[2][0]) && board[1][1].getText().equals("")) {
						if (botMove(board)) {
						board[1][1].setText("O");
						winCheck(board[1][1]);
						}
					}
					else {
						if (botMove(board)) {
							randMove();
						}
					}
					
				}
				else if (bt.equals(board[1][0])) {
					//Left column when bot left is empty
					if (compare(board[1][0],board[0][0]) && board[2][0].getText().equals("")) {
						if (botMove(board)) {
						board[2][0].setText("O");
						winCheck(board[2][0]);
						}
					}
					//Left column when top left is empty
					else if (compare(board[1][0],board[2][0]) && board[0][0].getText().equals("")) {
						if (botMove(board)) {
						board[0][0].setText("O");
						winCheck(board[0][0]);
						}
					}
					//Middle row when board[1][2] is empty
					else if (compare(board[1][0],board[1][1]) && board[1][2].getText().equals("")) {
						if (botMove(board)) {
						board[1][2].setText("O");
						winCheck(board[1][2]);
						}
					}
					//Middle row when middle is empty
					else if (compare(board[1][0], board[1][2]) && board[1][1].getText().equals("")) {
						if (botMove(board)) {
						board[1][1].setText("O");
						winCheck(board[1][1]);
						}
					}
					else {
						if (botMove(board)) {
						randMove();
						}
					}
				}
				else if (bt.equals(board[1][1])) {
					//Mid column when bot mid is empty
					if (compare(board[1][1],board[0][1]) && board[2][1].getText().equals("")) {
						if (botMove(board)) {
						board[2][1].setText("O");
						winCheck(board[2][1]);
						}
					}
					//Mid column when top mid is empty
					else if (compare(board[1][1],board[2][1]) && board[0][1].getText().equals("")) {
						if (botMove(board)) {
						board[0][1].setText("O");
						winCheck(board[0][1]);
						}
					}
					//Mid row if mid right is empty
					else if (compare(board[1][1],board[1][0]) && board[1][2].getText().equals("")) {
						if (botMove(board)) {
						board[1][2].setText("O");
						winCheck(board[1][2]);
						}
					}
					//Mid row if mid left is empty
					else if (compare(board[1][1],board[1][0]) && board[1][0].getText().equals("")) {
						if (botMove(board)) {
						board[1][0].setText("O");
						winCheck(board[1][0]);
						}
					}
					//Top Left diagonal if top left is empty
					else if (compare(board[1][1],board[2][2]) && board[0][0].getText().equals("")) {
						if (botMove(board)) {
						board[0][0].setText("O");
						winCheck(board[0][0]);
						}
					}
					//Top left diagonal if bot right is empty
					else if (compare(board[1][1],board[0][0]) && board[2][2].getText().equals("")) {
						if (botMove(board)) {
						board[2][2].setText("O");
						winCheck(board[2][2]);
						}
					
					}
					//Top right diagonal if top right is empty
					else if (compare(board[1][1],board[2][0]) && board[0][2].getText().equals("")) {
						if (botMove(board)) {
						board[0][2].setText("O");
						winCheck(board[0][2]);
						}
					}
					//Top right diagonal if bot left is empty
					else if (compare(board[1][1],board[0][2]) &&  board[2][0].getText().equals("")) {
						if (botMove(board)) {
						board[2][0].setText("O");
						winCheck(board[2][0]);
						}
					}
					else {
						if (botMove(board)) {
							randMove();
						}
					}
					
				}
				
				else if (bt.equals(board[1][2])) {
					//Middle row if mid left empty
					if (compare(board[1][2],board[1][1]) && board[1][0].getText().equals("")) {
						if (botMove(board)) {
						board[1][0].setText("O");
						winCheck(board[1][0]);
						}
					}
					//Middle row if middle is empty
					else if (compare(board[1][2],board[1][0]) && board[1][1].getText().equals("")) {
						if (botMove(board)) {
						board[1][1].setText("O");
						winCheck(board[1][1]);
						}
					}
					//Right column if top right is empty
					else if (compare(board[1][2], board[2][2]) && board[0][2].getText().equals("")) {
						if (botMove(board)) {
						board[0][2].setText("O");
						winCheck(board[0][2]);
						}
					}
					//Right column if bot right is empty
					else if (compare(board[1][2], board[0][2]) && board[2][2].getText().equals("")) {
						if (botMove(board)) {
						board[2][2].setText("O");
						winCheck(board[2][2]);
						}
					}
					else {
						if (botMove(board)) {
							randMove();
						}
					}
				}
				else if (bt.equals(board[2][0])) {
					//Bottom row if bot right is empty
					if (compare(board[2][0], board[2][1]) && board[2][2].getText().equals("")) {
						board[2][2].setText("O");
						winCheck(board[2][2]);
					}
					//Bottom row if bot mid is empty
					else if (compare(board[2][0], board[2][2]) && board[2][1].getText().equals("")) {
						board[2][1].setText("O");
						winCheck(board[2][1]);
					}
					//Left column if top left is empty
					else if (compare(board[2][0], board[1][0]) && board[0][0].getText().equals("")) {
						board[0][0].setText("O");
						winCheck(board[0][0]);
					}
					//Left column if mid left is empty
					else if (compare(board[2][0], board[0][0]) && board[1][0].getText().equals("")) {
						board[1][0].setText("O");
						winCheck(board[1][0]);
					}
					//Left diagonal if top right is empty
					else if (compare(board[2][0], board[1][1]) && board[0][2].getText().equals("")) {
						board[0][2].setText("O");
						winCheck(board[0][2]);
					}
					//Left diagonal if mid is empty
					else if (compare(board[2][0], board[0][2]) && board[1][1].getText().equals("")) {
						board[1][1].setText("O");
						winCheck(board[1][1]);
					}
					else {
						randMove();
					}
					
				}
				else if (bt.equals(board[2][1])) {
					//Bottom row if bot right is empty
					if (compare(board[2][1], board[2][0]) && board[2][2].getText().equals("")) {
						board[2][2].setText("O");
						winCheck(board[2][2]);
					}
					//Bottom row if bot left is empty
					else if (compare(board[2][1], board[2][2]) && board[2][0].getText().equals("")) {
						board[2][0].setText("O");
						winCheck(board[2][0]);
					}
					//Middle column if top mid is empty
					else if (compare(board[2][1], board[1][1]) && board[0][1].getText().equals("")) {
						board[0][1].setText("O");
						winCheck(board[0][1]);
					}
					//Middle column if middle is empty
					else if (compare(board[2][1], board[0][1]) && board[1][1].getText().equals("")) {
						board[1][1].setText("O");
						winCheck(board[1][1]);
					}
					else {
						randMove();
					}
				}
				else if (bt.equals(board[2][2])) {
					//Bottom row if bot left is empty
					if (compare(board[2][2], board[2][1]) && board[2][0].getText().equals("")) {
							board[2][0].setText("O");
							winCheck(board[2][0]);
					}
					//Bottom row if bot mid is empty
					else if (compare(board[2][2], board[2][0]) && board[2][1].getText().equals("")) {
						board[2][1].setText("O");
						winCheck(board[2][1]);
					}
					//Right column if top right is empty
					else if (compare(board[2][2], board[2][1]) && board[0][2].getText().equals("")) {
						board[0][2].setText("O");
						winCheck(board[0][2]);
					}
					//Right column if mid right is empty
					else if (compare(board[2][2], board[0][2]) && board[1][2].getText().equals("")) {
						board[1][2].setText("O");
						winCheck(board[1][2]);
					}
					//Bot right diagonal if top left is empty
					else if (compare(board[2][2], board[1][1]) && board[0][0].getText().equals("")) {
						board[0][0].setText("O");
						winCheck(board[0][0]);
					}
					//Bot right diagonal if mid is empty
					else if (compare(board[2][2], board[0][0]) && board[1][1].getText().equals("")) {
						board[1][1].setText("O");
						winCheck(board[1][1]);
					}
					else {
						randMove();
					}
				}
				
				//End game for bot victory
				if (winner) {
						scores[1] += 1;
						scoreLabel.setText("Score: X: " +scores[0]+  "  O: " + scores[1]);
						playAgain = JOptionPane.showOptionDialog(contentPane, "The Bot Wins! Play Again?", "Bot Wins!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
						if (playAgain != 1) {
							//Reset all buttons, winner variable, x turn variable, and append score
							board[0][0].setText("");
							board[0][1].setText("");
							board[0][2].setText("");
							board[1][0].setText("");
							board[1][1].setText("");
							board[1][2].setText("");
							board[2][0].setText("");
							board[2][1].setText("");
							board[2][2].setText("");
							winner = false;
							return 1;
						} else {
							JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was You: " + scores[0] + "  , Bot: " + scores[1]);
							System.exit(0);
						}	
					}
				}
			}
		return 1;
		}
	
	//Methods/Data for Impossible Bot AI
	static JButton[][] board = new JButton[3][3];
	
	public static class Move { 
	    int row, col; 
	}; 
	  
	static char player = 'x';
	static char opponent = 'o'; 
	  
	// This function returns true if there are moves 
	// remaining on the board. It returns false if 
	// there are no moves left to play. 
	public static boolean isMovesLeft(char board[][]) { 
	    for (int i = 0; i<3; i++) {
	        for (int j = 0; j<3; j++) { 
	            if (board[i][j]=='_') {
	                return true; 
	            }
	        }
	    }
	    return false; 
	} 
	  
	// This is the evaluation function as discussed 
	// in the previous article ( http://goo.gl/sJgv68 ) 
	public static int evaluate(char b[][]) { 
	    // Checking for Rows for X or O victory. 
	    for (int row = 0; row<3; row++) { 
	        if (b[row][0]==b[row][1] && 
	            b[row][1]==b[row][2]) { 
	            if (b[row][0]==player) {
	                return -10; 
	            }
	            else if (b[row][0]==opponent) {
	                return +10; 
	            }
	        } 
	    } 
	  
	    // Checking for Columns for X or O victory. 
	    for (int col = 0; col<3; col++) { 
	        if (b[0][col]==b[1][col] && 
	            b[1][col]==b[2][col]) { 
	            if (b[0][col]==player) {
	                return -10; 
	            }
	  
	            else if (b[0][col]==opponent)  {
	                return +10; 
	            }
	        } 
	    } 
	  
	    // Checking for Diagonals for X or O victory. 
	    if (b[0][0]==b[1][1] && b[1][1]==b[2][2]) { 
	        if (b[0][0]==player) {
	            return -10; 
	        }
	        else if (b[0][0]==opponent) { 
	            return +10; 
	        }
	    } 
	  
	    if (b[0][2]==b[1][1] && b[1][1]==b[2][0]) { 
	        if (b[0][2]==player) { 
	            return -10; 
	        }
	        else if (b[0][2]==opponent) {
	            return +10; 
	        }
	    } 
	  
	    // Else if none of them have won then return 0 
	    return 0; 
	} 
	  
	// This is the minimax function. It considers all 
	// the possible ways the game can go and returns 
	// the value of the board 
	public static int minimax(char board[][], int depth, boolean isMax) { 
	    int score = evaluate(board); 
	  
	    // If Maximizer has won the game return his/her 
	    // evaluated score 
	    if (score == 10) {
	        return score; 
	    }
	  
	    // If Minimizer has won the game return his/her 
	    // evaluated score 
	    if (score == -10) {
	        return score; 
	    }
	  
	    // If there are no more moves and no winner then 
	    // it is a tie 
	    if (isMovesLeft(board)==false) {
	        return 0; 
	    }
	  
	    // If this maximizer's move 
	    if (isMax) { 
	        int best = -1000; 
	  
	        // Traverse all cells 
	        for (int i = 0; i<3; i++) { 
	            for (int j = 0; j<3; j++) { 
	                // Check if cell is empty 
	                if (board[i][j]=='_') { 
	                    // Make the move 
	                    board[i][j] = opponent; 
	  
	                    // Call minimax recursively and choose 
	                    // the maximum value 
	                    best = Math.max(best, minimax(board, depth+1, !isMax) ); 
	  
	                    // Undo the move 
	                    board[i][j] = '_'; 
	                } 
	            } 
	        } 
	        return best; 
	    } 
	  
	    // If this minimizer's move 
	    else { 
	        int best = 1000; 
	  
	        // Traverse all cells 
	        for (int i = 0; i<3; i++) { 
	            for (int j = 0; j<3; j++) { 
	                // Check if cell is empty 
	                if (board[i][j]=='_') { 
	                    // Make the move 
	                    board[i][j] = player; 
	  
	                    // Call minimax recursively and choose 
	                    // the minimum value 
	                    best = Math.min(best, minimax(board, depth+1, !isMax)); 
	  
	                    // Undo the move 
	                    board[i][j] = '_'; 
	                } 
	            } 
	        } 
	        return best; 
	    } 
	} 
	  
	 // This will return the best possible move for the player 
	public static Move findBestMove(char board[][]) { 
	    int bestVal = -1000; 
	    Move bestMove = new Move(); 
	    bestMove.row = -1; 
	    bestMove.col = -1; 
	  
	    // Traverse all cells, evaluate minimax function for 
	    // all empty cells. And return the cell with optimal 
	    // value. 
	    for (int i = 0; i<3; i++) { 
	        for (int j = 0; j<3; j++) { 
	            // Check if cell is empty 
	            if (board[i][j]=='_') { 
	                // Make the move 
	                board[i][j] = opponent; 
	  
	                // compute evaluation function for this 
	                // move. 
	                int moveVal = minimax(board, 0, false); 
	  
	                // Undo the move 
	                board[i][j] = '_'; 
	  
	                // If the value of the current move is 
	                // more than the best value, then update 
	                // best/ 
	                if (moveVal > bestVal) { 
	                    bestMove.row = i; 
	                    bestMove.col = j; 
	                    bestVal = moveVal; 
	                } 
	            } 
	        } 
	    }
	    return bestMove; 
	} 
	
	//Actual Impossible Bot Function
	public static int impossibleBot(JButton bt) {
		if (!bt.getText().equals("")) {
			disp.setText("You Can't Go Here!");
		}
		else {
			bt.setText("X");
			winCheck(bt);
			//If winner is true end game
			if (winner) {
				scores[0] += 1;
				scoreLabel.setText("Score: X: " +scores[0]+  "  O: " + scores[1]);
				playAgain = JOptionPane.showOptionDialog(contentPane, "You Win! Play Again?", "You Win!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (playAgain != 1) {
					//Reset all buttons, winner variable, x turn variable, and append score
					board[0][0].setText("");
					board[0][1].setText("");
					board[0][2].setText("");
					board[1][0].setText("");
					board[1][1].setText("");
					board[1][2].setText("");
					board[2][0].setText("");
					board[2][1].setText("");
					board[2][2].setText("");
					winner = false;
					return 1;
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was You: " + scores[0] + "  , Bot: " + scores[1]);
					System.exit(0);
				}	
			}
			else {
				char [][] field = new char[3][3];
				
				for (int i = 0; i < 3; i++) {
					for (int x = 0; x < 3; x++ ) {
						if (!board[i][x].getText().equals("")) {
							field[i][x] = board[i][x].getText().toLowerCase().charAt(0);
						}
						else if (board[i][x].getText().equals("")) {
							field[i][x] = '_';
						}
					}
				}
				Move bestMove = findBestMove(field);

			    
				board[bestMove.row][bestMove.col].setText("O");	
				winCheck(board[bestMove.row][bestMove.col]);
				
				//End game for bot victory
				if (winner) {
						scores[1] += 1;
						scoreLabel.setText("Score: X: " +scores[0]+  "  O: " + scores[1]);
						playAgain = JOptionPane.showOptionDialog(contentPane, "The Bot Wins! Play Again?", "Bot Wins!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
						if (playAgain != 1) {
							//Reset all buttons, winner variable, x turn variable, and append score
							board[0][0].setText("");
							board[0][1].setText("");
							board[0][2].setText("");
							board[1][0].setText("");
							board[1][1].setText("");
							board[1][2].setText("");
							board[2][0].setText("");
							board[2][1].setText("");
							board[2][2].setText("");
							winner = false;
							return 1;
						} else {
							JOptionPane.showMessageDialog(contentPane, "Thanks for playing! The final score was You: " + scores[0] + "  , Bot: " + scores[1]);
							System.exit(0);
						}	
					}
			}
		}
		return 1;
	}
	/**find
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticTacToe frame = new ticTacToe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	//Function for program frame
	public ticTacToe() {
		
		//Set window to close upon exit button being pressed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set Size of Window
		setBounds(100, 100, 450, 300);
		
		//Create a main JPanel to hold all content, set the background colour, give it a border, and layout
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 99, 71));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Create panel to hold all buttons, give it a 3x3 grid layout
		JPanel gridPanel = new JPanel();
		contentPane.add(gridPanel, BorderLayout.CENTER);
		gridPanel.setLayout(new GridLayout(3, 3, 0, 0));
		
		//Create all 9 buttons that will serve as main game field, set font and opacity
		board[0][0] = new JButton("");
		board[0][0].setFont(new Font("Lao UI", Font.BOLD, 28));
		board[0][0].setOpaque(true);
		gridPanel.add(board[0][0]);
		
		board[0][1] = new JButton("");
		board[0][1].setFont(new Font("Lao UI", Font.BOLD, 28));
		board[0][1].setOpaque(true);
		gridPanel.add(board[0][1]);
		
		board[0][2] = new JButton("");
		board[0][2].setFont(new Font("Lao UI", Font.BOLD, 28));
		board[0][2].setOpaque(true);
		gridPanel.add(board[0][2]);
		
		board[1][0] = new JButton("");
		board[1][0].setFont(new Font("Lao UI", Font.BOLD, 28));
		board[1][0].setOpaque(true);
		gridPanel.add(board[1][0]);
		
		board[1][1] = new JButton("");
		board[1][1].setFont(new Font("Lao UI", Font.BOLD, 28));
		board[1][1].setOpaque(true);
		gridPanel.add(board[1][1]);
		
		board[1][2] = new JButton("");
		board[1][2].setFont(new Font("Lao UI", Font.BOLD, 28));
		board[1][2].setOpaque(true);
		gridPanel.add(board[1][2]);
		
		board[2][0] = new JButton("");
		board[2][0].setFont(new Font("Lao UI", Font.BOLD, 28));
		board[2][0].setOpaque(true);
		gridPanel.add(board[2][0]);
		
		board[2][1] = new JButton("");
		board[2][1].setFont(new Font("Lao UI", Font.BOLD, 28));
		board[2][1].setOpaque(true);
		gridPanel.add(board[2][1]);
		
		board[2][2] = new JButton("");
		board[2][2].setFont(new Font("Lao UI", Font.BOLD, 28));
		board[2][2].setOpaque(true);
		gridPanel.add(board[2][2]);
				
		//Create panel to hold content below buttons, set it's colour
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(255, 160, 122));
		bottomPanel.setForeground(new Color(0, 0, 0));
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
		//Create JLabel to display score
		scoreLabel = new JLabel("Score: X: " +scores[0]+  "  O: " + scores[1]);
		scoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		scoreLabel.setFont(new Font("Lao UI", Font.PLAIN, 18));
		scoreLabel.setForeground(new Color(240, 255, 255));
		bottomPanel.add(scoreLabel);
		
		//Strut to space between score label and restart button
		horizontalStrut = Box.createHorizontalStrut(20);
		bottomPanel.add(horizontalStrut);
		
		//Create restart button and add an actionlistener that will listen for a mouse click, running a method when this happens
		restartBt = new JButton("Restart");
		restartBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				board[0][0].setText("");
				board[0][1].setText("");
				board[0][2].setText("");
				board[1][0].setText("");
				board[1][1].setText("");
				board[1][2].setText("");
				board[2][0].setText("");
				board[2][1].setText("");
				board[2][2].setText("");
				winner = false;
				isXTurn = true;
				disp.setText("It's X's Turn");
			}
		});
		restartBt.setFont(new Font("Lao UI", Font.PLAIN, 16));
		restartBt.setHorizontalAlignment(SwingConstants.RIGHT);
		bottomPanel.add(restartBt);
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new EmptyBorder(0, 0, 5, 0));
		topPanel.setBackground(new Color(255, 99, 71));
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new GridLayout(0, 3, 3, 0));
		
		JLabel leftBlankTitlePanel = new JLabel("");
		topPanel.add(leftBlankTitlePanel);
		
		JLabel label = new JLabel("Tic Tac Toe");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(240, 255, 255));
		label.setFont(new Font("Lao UI", Font.PLAIN, 25));
		topPanel.add(label);
		
		JLabel rightBlankTitleLabel = new JLabel("");
		rightBlankTitleLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		topPanel.add(rightBlankTitleLabel);
		
		/*JScrollPane listScroller = new JScrollPane(diffList);
		listScroller.setPreferredSize(new Dimension(250,80));*/
		
		diffSelect = new JSpinner();
		diffSelect.setFont(new Font("Lao UI", Font.PLAIN, 14));
		diffSelect.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				difficulty = diffSelect.getValue();
			}
		});
		diffSelect.setModel(new SpinnerListModel(new String[] {"Player vs Player", "Easy Bot", "Medium Bot", "Impossible Bot"}));
		diffSelect.setToolTipText("Select Difficulty");
		topPanel.add(diffSelect);
		
		disp = new JLabel("Click on a Box to Start");
		disp.setHorizontalAlignment(SwingConstants.CENTER);
		disp.setForeground(new Color(240, 255, 255));
		disp.setFont(new Font("Dialog", Font.PLAIN, 14));
		topPanel.add(disp);
			
		//Top row
		
		board[0][0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (difficulty.equals("Easy Bot")) {
					easyBot(board[0][0]);
				}
				
				else if (difficulty.equals("Medium Bot")) {
					medBot(board[0][0]);
				}
				else if (difficulty.equals("Impossible Bot")) {
					impossibleBot(board[0][0]);
				}

				else {
					if (!board[0][0].getText().equals("")) {
						disp.setText("You can't go here!");
					}
					
					else {
						if (isXTurn) {
							board[0][0].setText("X");
						}
						
						else if (!isXTurn) {
							board[0][0].setText("O");
						}
						
						winCheck(board[0][0]);
								
						if (winner) {
							gameEndPVP(board[0][0]);
						}
						
						else {
							isXTurn = !isXTurn;
							if (isXTurn) {
								disp.setText("It's X's Turn");
							}
							else if (!isXTurn) {
								disp.setText("It's O's Turn");
							}
						}
					}
				}
			}
		});
		
		board[0][1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (difficulty.equals("Easy Bot")) {
					easyBot(board[0][1]);
				}
				
				else if (difficulty.equals("Medium Bot")) {
					medBot(board[0][1]);
				}
				else if (difficulty.equals("Impossible Bot")) {
					impossibleBot(board[0][1]);
				}

				else {
					if (!board[0][1].getText().equals("")) {
					disp.setText("You can't go here!");
				}
				
				else {
					if (isXTurn) {
						board[0][1].setText("X");
					}
					
					else if (!isXTurn) {
						board[0][1].setText("O");
					}
					
					winCheck(board[0][1]);
					
					if (winner) {
						gameEndPVP(board[0][1]);		
					}
					
					else {
						isXTurn = !isXTurn;
						if (isXTurn) {
							disp.setText("It's X's Turn");
							}

						else if (!isXTurn) {
							disp.setText("It's O's Turn");
							}
						}
					}	
				}	
			}
		});
		
		board[0][2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				if (difficulty.equals("Easy Bot")) {
					easyBot(board[0][2]);
				}
				
				else if (difficulty.equals("Medium Bot")) {
					medBot(board[0][2]);
				}
				else if (difficulty.equals("Impossible Bot")) {
					impossibleBot(board[0][2]);
				}

				else {
					if (!board[0][2].getText().equals("")) {
					disp.setText("You can't go here!");
				}
				
					else {
						if (isXTurn) {
							board[0][2].setText("X");
						}
						
						else if (!isXTurn) {
							board[0][2].setText("O");
						}
						
						winCheck(board[0][2]);

						if (winner) {
							gameEndPVP(board[0][2]);
						}	
						
						else {

							isXTurn = !isXTurn;
							if (isXTurn) {
								disp.setText("It's X's Turn");
							}
							else if (!isXTurn) {
								disp.setText("It's O's Turn");
							}
						}
					}	
				}	
			}
		});
		
		//Middle row
		
		board[1][0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (difficulty.equals("Easy Bot")) {
					easyBot(board[1][0]);
				}
				
				else if (difficulty.equals("Medium Bot")) {
					medBot(board[1][0]);
				}
				else if (difficulty.equals("Impossible Bot")) {
					impossibleBot(board[1][0]);
				}
				else {
					if (!board[1][0].getText().equals("")) {
					disp.setText("You can't go here!");
				}
					
				
					else {
						if (isXTurn) {
							board[1][0].setText("X");
						}
						
						else if (!isXTurn) {
							board[1][0].setText("O");
						}
						
						winCheck(board[1][0]);
						
						if (winner) {
							gameEndPVP(board[1][0]);
						}
						
						else {
							isXTurn = !isXTurn;
							if (isXTurn) {
								disp.setText("It's X's Turn");
							}
							else if (!isXTurn) {
								disp.setText("It's O's Turn");
							}
						}
					}
				}		
			}
		});
		
		board[1][1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (difficulty.equals("Easy Bot")) {
					easyBot(board[1][1]);
				}
				
				else if (difficulty.equals("Medium Bot")) {
					medBot(board[1][1]);
				}
				else if (difficulty.equals("Impossible Bot")) {
					impossibleBot(board[1][1]);
				}
				else {
									if (!board[1][1].getText().equals("")) {
					disp.setText("You can't go here!");
				}
				
					else {
						if (isXTurn) {
							board[1][1].setText("X");
						}
						
						else if (!isXTurn) {
							board[1][1].setText("O");
						}
						
						winCheck(board[1][1]);
						
						if (winner) {
							gameEndPVP(board[1][1]);
						}
						
						else {
							isXTurn = !isXTurn;
							if (isXTurn) {
								disp.setText("It's X's Turn");
							}
							else if (!isXTurn) {
								disp.setText("It's O's Turn");
							}
						}
					}
				}
			
			}
		});
		
		board[1][2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (difficulty.equals("Easy Bot")) {
					easyBot(board[1][2]);
				}
				
				else if (difficulty.equals("Medium Bot")) {
					medBot(board[1][2]);
				}
				else if (difficulty.equals("Impossible Bot")) {
					impossibleBot(board[1][2]);
				}
				else {
					if (!board[1][2].getText().equals("")) {
					disp.setText("You can't go here!");
				}
					
					else {
						if (isXTurn) {
							board[1][2].setText("X");
						}
						
						else if (!isXTurn) {
							board[1][2].setText("O");
						}
						
						winCheck(board[1][2]);
						
						if (winner) {
							gameEndPVP(board[1][2]);
						}
						
						else {
							isXTurn = !isXTurn;
							if (isXTurn) {
								disp.setText("It's X's Turn");
							}
							else if (!isXTurn) {
								disp.setText("It's O's Turn");
							}
						}
					}	
				}		
			}
		});
		
		//Bottom Row
		
		board[2][0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (difficulty.equals("Easy Bot")) {
					easyBot(board[2][0]);
				}
				
				else if (difficulty.equals("Medium Bot")) {
					medBot(board[2][0]);
				}
				else if (difficulty.equals("Impossible Bot")) {
					impossibleBot(board[2][0]);
				}
				else {
					if (!board[2][0].getText().equals("")) {
					disp.setText("You can't go here!");
				}
				
					else {
						if (isXTurn) {
							board[2][0].setText("X");
						}
						
						else if (!isXTurn) {
							board[2][0].setText("O");
						}
						
						winCheck(board[2][0]);
						
						if (winner) {
							gameEndPVP(board[2][0]);
						}
						
						else {
							isXTurn = !isXTurn;
							if (isXTurn) {
								disp.setText("It's X's Turn");
							}
							else if (!isXTurn) {
								disp.setText("It's O's Turn");
							}
						}
					}	
				}	
			}
		});
		
		board[2][1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (difficulty.equals("Easy Bot")) {
					easyBot(board[2][1]);
				}
				
				else if (difficulty.equals("Medium Bot")) {
					medBot(board[2][1]);
				}
				else if (difficulty.equals("Impossible Bot")) {
					impossibleBot(board[2][1]);
				}
				else {
					if (!board[2][1].getText().equals("")) {
					disp.setText("You can't go here!");
				}
				
					else {
						if (isXTurn) {
							board[2][1].setText("X");
						}
						
						else if (!isXTurn) {
							board[2][1].setText("O");
						}
						
						winCheck(board[2][1]);

						if (winner) {
							gameEndPVP(board[2][1]);
						}
						
						else {
							isXTurn = !isXTurn;
							if (isXTurn) {
								disp.setText("It's X's Turn");
							}
							else if (!isXTurn) {
								disp.setText("It's O's Turn");
							}
						}
					}	
				}	
			}
		});
		
		board[2][2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (difficulty.equals("Easy Bot")) {
					easyBot(board[2][2]);
				}
				
				else if (difficulty.equals("Medium Bot")) {
					medBot(board[2][2]);
				}
				else if (difficulty.equals("Impossible Bot")) {
					impossibleBot(board[2][2]);
				}
				else {
					if (!board[2][2].getText().equals("")) {
					disp.setText("You can't go here!");
				}
				
					else {
						if (isXTurn) {
							board[2][2].setText("X");
						}
						
						else if (!isXTurn) {
							board[2][2].setText("O");
						}
						
						winCheck(board[2][2]);

						if (winner) {
							gameEndPVP(board[2][2]);
						}
						
						else {
							isXTurn = !isXTurn;
							if (isXTurn) {
								disp.setText("It's X's Turn");
							}
							else if (!isXTurn) {
								disp.setText("It's O's Turn");
							}
						}
					}	
				}		
			}
		});	
	}
}