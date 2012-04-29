package fr.imac.jwbreaker;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Window extends JFrame {

	protected String _name;
	protected int _width, _height;
	protected JPanel _container = new JPanel();
	
	
	public void initWindow() {
		setTitle(_name);
		setSize(_width, _height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setBackground(Color.BLACK);
	}
	
	public void initContainer() {
		setContentPane(_container);
	}
}
