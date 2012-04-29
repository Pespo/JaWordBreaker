package fr.imac.jwbreaker;


import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Mat22;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;


public class WindowGame extends Window implements ActionListener {
	
	private SecretWordPanel _secretWordPanel = new SecretWordPanel();
	private SidePanel _sidePanel = new SidePanel();
	
	public WindowGame() {
		_name = "Game";
		_width = 800;
		_height = 600;
		
		initWindow();
		initLayout();	
		initConstraints();
		//initContainer();	
	}
	
	public void initLayout() {
		BorderLayout layout = new BorderLayout();
		_container.setLayout(layout);
	}
	
	public void initConstraints() {		
		this.add(_container, BorderLayout.CENTER);
		this.add(_sidePanel, BorderLayout.EAST);
		this.add(_secretWordPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void initContainer() {
		super.initContainer();
		getContentPane().add(_sidePanel);	
		getContentPane().add(_secretWordPanel);	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
