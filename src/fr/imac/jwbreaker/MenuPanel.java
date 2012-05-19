package fr.imac.jwbreaker;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class MenuPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -5143945113223210506L;

	private JButton _startButton;
	private JButton _optionButton;
	private JLabel _homeTitle;

	public MenuPanel() {
		
		_startButton = new JButton("Start");
		_optionButton = new JButton("Option");
		_homeTitle = new JLabel("JaWorkBreaker");
		
		initLayout();	
		initConstraints();
	}
		
	public void initLayout() {
		setLayout(new GridBagLayout());
	}
	
	public void initConstraints() {
		
		GridBagConstraints constraint = new GridBagConstraints();

		//title : label
		constraint.gridx = constraint.gridy = 0;
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		constraint.gridheight = 1;
		constraint.insets = new Insets(0, 0, 40, 0);
		add(_homeTitle, constraint);
		
		//Game : button
		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.gridwidth = GridBagConstraints.CENTER;
		constraint.insets = new Insets(10, 0, 10, 0);
		add(_startButton, constraint);
		
		_startButton.addActionListener(this);
		_startButton.setPreferredSize(_optionButton.getPreferredSize());
		_startButton.setMinimumSize(_optionButton.getMinimumSize());
		
		//Option : button
		constraint.gridy = 2;		
		add(_optionButton, constraint);
		_optionButton.addActionListener(this);	

	}
	
	public void actionPerformed(ActionEvent e) {
		MainWindow mainWindow = MainWindow.getInstance();
		
        if(e.getSource() == _startButton) {
        	mainWindow.changeCards(MainWindow.Cards.GAME);
        }
        
        if(e.getSource() == _optionButton) {
        	mainWindow.changeCards(MainWindow.Cards.OPTION);
        }
	}

}
