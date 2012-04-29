package fr.imac.jwbreaker;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowOption extends Window implements ActionListener {

	private JButton returnButton = new JButton("Retour");
	private JLabel title = new JLabel("Option");
	
	public WindowOption() {
        
		_name = "Option";
		_width = _height = 300;  
		
		initWindow();	
		initButton();
		//initLayout();	
		initConstraints();
		initContainer();
		setVisible(true);
	}
	
	public void initConstraints() {
		GridBagConstraints constraint = new GridBagConstraints();
		
		//Titre : label
		constraint.gridx = constraint.gridy = 0;
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		constraint.gridheight = 1;
		constraint.insets = new Insets(0, 0, 40, 0);
		_container.add(title, constraint);
		
		//Option : button
		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.gridwidth = GridBagConstraints.CENTER;
		constraint.insets = new Insets(10, 0, 10, 0);
		_container.add(returnButton, constraint);		
	}
	
	public void initButton() {
		returnButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == returnButton) {
        	WindowMenu fen = new WindowMenu(); 
        	fen.setVisible(true);
        	setVisible(false);
        }
		
	}
	
}
