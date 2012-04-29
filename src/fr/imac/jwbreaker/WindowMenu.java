package fr.imac.jwbreaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class WindowMenu extends Window implements ActionListener {
	
	private JButton startButton = new JButton("Jeux");
	private JButton optionButton = new JButton("Option");
	private JButton pseudoButton = new JButton("Valider");
	private JLabel title = new JLabel("JaWorkBreaker");
	private JLabel pseudo = new JLabel("Pseudo :");
	private JTextField pseudoTextField = new JTextField();
		
	public WindowMenu() {
                
		_name = "Menu";
		_width = _height = 300;  
		
		initWindow();	
		initButton();
		initLayout();	
		initConstraints();
		initContainer();
		setVisible(true);
	}
	
	public void initButton() {
		
		startButton.addActionListener(this);
		optionButton.addActionListener(this);
		
		startButton.setPreferredSize(optionButton.getPreferredSize());
		startButton.setMinimumSize(optionButton.getMinimumSize());
	}
	
	public void initLayout() {
		GridBagLayout layout = new GridBagLayout();
		_container.setLayout(layout);
	}
	
	public void initConstraints() {
		GridBagConstraints constraint = new GridBagConstraints();
		
		//title : label
		constraint.gridx = constraint.gridy = 0;
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		constraint.gridheight = 1;
		constraint.insets = new Insets(0, 0, 40, 0);
		_container.add(title, constraint);
		
		//Pseudo : label
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		constraint.insets = new Insets(10, 0, 10, 10);
		_container.add(pseudo, constraint);

		//Pseudo : textfield
		constraint.gridx = 1;
		constraint.ipadx = 100;
		//constraint.gridwidth = 1;
		_container.add(pseudoTextField, constraint);
		
		//Pseudo : button
		constraint.gridx = 2;
		constraint.ipadx = 10;
		//constraint.gridwidth = GridBagConstraints.WEST;
		_container.add(pseudoButton, constraint);
		
		//Game : button
		constraint.gridx = 0;
		constraint.gridy = 2;
		constraint.gridwidth = GridBagConstraints.CENTER;
		constraint.insets = new Insets(10, 0, 10, 0);
		_container.add(startButton, constraint);
	
		//Option : button
		constraint.gridy = 3;		
		_container.add(optionButton, constraint);
	}
	
	public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == startButton) {
        	final WindowGame fen = new WindowGame(); 
        	fen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        	fen.addWindowListener(
    			new WindowAdapter(){
    		        public void windowClosing(WindowEvent e){
    		              int reponse = JOptionPane.showConfirmDialog(
    	            		   fen,
                               "Voulez-vous quitter l'application",
                               "Confirmation",
                               JOptionPane.YES_NO_OPTION,
                               JOptionPane.QUESTION_MESSAGE);
    		              if (reponse==JOptionPane.YES_OPTION){
    		            	  fen.dispose();
    		              }
    		        }
    			}
        	);
        	fen.setVisible(true);
        	setVisible(false);
        }
        
        if(e.getSource() == optionButton) {
        	WindowOption fen = new WindowOption(); 
    		fen.setVisible(true);
    		setVisible(false);
        }
	}

}
