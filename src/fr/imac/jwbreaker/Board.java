package fr.imac.jwbreaker;

import java.util.Vector;

import javax.swing.JPanel;

/**
 * @author muxisar
 *
 */
public class Board extends JPanel implements Runnable {

	private static final long serialVersionUID = -1618078400590773108L;

	private World m_world;
	private Vector<Brick> m_bricks;
	private Vector<Ball> m_balls;
	private Model m_model;
	
	public Board() {
		m_model = Model.newInstance();
		m_world = new World(m_model.getVec2(Model.Property.gravity), true);
		m_bricks = new Vector<Brick>();
		m_balls = new Vector<Ball>();
		
		
	}
	
	@Override
	public void run() {
		
	}

}
