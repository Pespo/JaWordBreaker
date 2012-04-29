package fr.imac.jwbreaker;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SecretWordPanel extends JPanel {
	private JButton secretWordButton = new JButton("Valider");
	private JLabel secretWordLabel = new JLabel("Mot secret :");
	private JTextField secretWordTextField = new JTextField();
	
	public SecretWordPanel() {
		initLayout();	
		initConstraints();
	}
	
	public void initLayout() {
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
	}
	
	public void initConstraints() {
		GridBagConstraints constraint = new GridBagConstraints();
		
		//secretWord : label
		constraint.gridx = constraint.gridy = 0;
		constraint.gridwidth = 1;
		constraint.gridheight = 1;
		constraint.insets = new Insets(10, 0, 10, 10);
		this.add(secretWordLabel, constraint);

		//secretWord : textfield
		constraint.gridx = 1;
		constraint.ipadx = 100;
		this.add(secretWordTextField, constraint);
		
		//secretWord : button
		constraint.gridx = 2;
		constraint.ipadx = 10;
		this.add(secretWordButton, constraint);	
	}
	
}
