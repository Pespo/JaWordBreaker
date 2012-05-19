package fr.imac.jwbreaker;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SidePanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 6748225477838690142L;
	private JLabel _sideLabel;
	private JButton _returnButton;
	private Player _player;
	private JLabel _login; public JLabel get_login() { return _login; }	public void set_login(JLabel _login) { this._login = _login; }
	
	public SidePanel() {
		 _sideLabel = new JLabel("Side Panel");
		_returnButton = new JButton("Retour");
		_player = Player.getInstance();
		_login = new JLabel(_player.get_login()); 
				
		initLayout();	
		initConstraints();
	}
	
	public void initLayout() {
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
	}
	
	public void initConstraints() {
		GridBagConstraints constraint = new GridBagConstraints();
		
		//Side panel : label
		constraint.gridx = constraint.gridy = 0;
		constraint.gridwidth = 1;
		constraint.gridheight = 1;
		constraint.insets = new Insets(10, 0, 10, 10);
		this.add(_sideLabel, constraint);
		
		constraint.gridy = 1;
		add(_login, constraint);

		//Return : button
		constraint.gridy = 2;
		constraint.ipadx = 10;
		this.add(_returnButton, constraint);
		_returnButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainWindow mainWindow = MainWindow.getInstance();
		
		if(e.getSource() == _returnButton) {
			mainWindow.changeCards(MainWindow.Cards.HOME);
		}
	}
}
