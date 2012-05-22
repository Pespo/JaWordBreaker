package fr.imac.jwbreaker;

import org.jbox2d.common.Vec2;

/**
 * The global world for physical simulations
 * @see <code>org.jbox2d.dynamics.World</code>
 * @author muxisar
 */
public class World extends org.jbox2d.dynamics.World {
	private Model m_model;
	
	public World(org.jbox2d.common.Vec2 gravity, boolean doSleep) {
		super(gravity, doSleep);
		m_model = Model.newInstance();

	}
	
	public static Vec2 screenPosition(Vec2 v) {
		return new Vec2(0, 0);
	}
	
	public static Vec2 worldPosition(Vec2 v) {
		return new Vec2(0f, 0f);
	}
	

	public static Vec2 screenDimensions(Vec2 v) {
		return new Vec2(0, 0);
	
	}
	
	public static Vec2 worldDimensions(Vec2 v) {
		return new Vec2(0f, 0f);
		
	}

	private Vec2i positionJboxToBoard(Vec2 JBox) {
	       int x = (int) (JBox.x * m_model.getVec2(Model.Property.board).x / m_model.getVec2(Model.Property.world).x);
	       int y = (int) (JBox.y * m_model.getVec2(Model.Property.board).y / m_model.getVec2(Model.Property.world).y);
	       return new Vec2i(x, y);
	}

	private Vec2 positionBoardToJbox(Vec2i board) {
	       float x = board.x * m_model.getVec2(Model.Property.world).x / m_model.getVec2(Model.Property.board).x;
	       float y = board.y * m_model.getVec2(Model.Property.world).y / m_model.getVec2(Model.Property.board).y;
	       return new Vec2(x, y);
	}

	public Vec2i objJBoxToBoard(DrawableElement objJBox) {
	       return positionJboxToBoard(new Vec2(objJBox.x() - objJBox.width() / 2, objJBox.y() + objJBox.height() / 2));
	}

	public Vec2 objBoardToJbox(DrawableElement objBoard) {
	       return positionBoardToJbox(new Vec2i(objBoard.x() + objBoard.width() / 2, objBoard.y() - objBoard.height() / 2));
	}
	
}