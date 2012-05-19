package fr.imac.jwbreaker;


import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 9015559088800516054L;
	
	private JPanel _mainPanel;
	private SecretWordPanel _secretWordPanel;
	private SidePanel _sidePanel; public SidePanel get_sidePanel() { return _sidePanel; } public void set_sidePanel(SidePanel _sidePanel) {this._sidePanel = _sidePanel;}

	public GamePanel() {
		_mainPanel = new JPanel();
		_secretWordPanel = new SecretWordPanel();
		_sidePanel = new SidePanel();
		
		initLayout();
		initConstraints();
	}
	
	public void initLayout() {
		setLayout(new BorderLayout());
	}
	
public void initConstraints() {		
		add(_mainPanel, BorderLayout.CENTER);
		add(_sidePanel, BorderLayout.EAST);
		add(_secretWordPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//dispatchEvent(e);
	}
	
}
