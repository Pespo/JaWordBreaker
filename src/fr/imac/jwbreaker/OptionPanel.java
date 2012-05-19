package fr.imac.jwbreaker;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -7400724324817967039L;
	private JLabel _pseudoLabel;
	private JLabel _optionTitle;
	private JTextField _pseudoTextField;
	private JButton _pseudoButton;
	private JButton _returnButton;
	private Player _player;
	
	public OptionPanel() {
		
		_pseudoLabel = new JLabel("Pseudo :");
		_optionTitle = new JLabel("Option");
		_pseudoTextField = new JTextField();
		_pseudoButton = new JButton("Valider");
		_returnButton = new JButton("Retour");
		_player = Player.getInstance();
	
		initLayout();
		initConstraints();
	}
	
	public void initLayout() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
	}
	
	public void initConstraints() {		
		GridBagConstraints constraint = new GridBagConstraints();
		
		//Titre : label
		constraint.gridx = constraint.gridy = 0;
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		constraint.gridheight = 1;
		constraint.insets = new Insets(0, 0, 40, 0);
		this.add(_optionTitle, constraint);
		
		//Pseudo : label
		constraint.gridy = 1;
		constraint.gridwidth = 1;
		constraint.insets = new Insets(10, 0, 10, 10);
		add(_pseudoLabel, constraint);

		//Pseudo : textfield
		constraint.gridx = 1;
		constraint.ipadx = 100;
		//constraint.gridwidth = 1;
		_pseudoTextField.setText(_player.get_login());
		add(_pseudoTextField, constraint);
		
		//Pseudo : button
		constraint.gridx = 2;
		constraint.ipadx = 10;
		//constraint.gridwidth = GridBagConstraints.WEST;
		add(_pseudoButton, constraint);
		_pseudoButton.addActionListener(this);
		
		//Return : button
		constraint.gridx = 0;
		constraint.gridy = 2;
		constraint.gridwidth = GridBagConstraints.CENTER;
		constraint.insets = new Insets(10, 0, 10, 0);
		add(_returnButton, constraint);
		_returnButton.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainWindow mainWindow = MainWindow.getInstance();
		if(e.getSource() == _returnButton) {
			mainWindow.changeCards(MainWindow.Cards.HOME);
		}
		
		if(e.getSource() == _pseudoButton) {
			_player.set_login(_pseudoTextField.getText());
			revalidate();
			mainWindow.get_gamePanel().get_sidePanel().get_login().setText(_pseudoTextField.getText());
		}
	}
}
