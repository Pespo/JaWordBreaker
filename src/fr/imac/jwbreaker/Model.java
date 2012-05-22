package fr.imac.jwbreaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.jbox2d.common.Vec2;

/**
 * Used to store all variables values in the game
 * It follow the Singleton Pattern
 * @author muxisar
 */
public class Model extends Properties {
	private static final long serialVersionUID = -7553742164852222393L;
	private static String USER_LOCATION = "user.properties";
	private static String DEFAULT_LOCATION = "default.properties";
	private static Model s_instance;
	
	/**
	 * Define all settings name
	 */
	public static enum Property {
		gravity,
		board,
		world;
	}
	
	private Model() {
		load();
	}
	
	/**
	 * Read a <code>org.jbox2d.common.Vec2</code> in the game properties
	 * @param	p	the property to read
	 * @return the value of the property
	 */
	public Vec2 getVec2(Property p) {
		Float x = Float.parseFloat(this.getProperty(p.name() + "x"));
		Float y = Float.parseFloat(this.getProperty(p.name() + "x"));
		return new Vec2(x, y);
	}

	/**
	 * Write a <code>org.jbox2d.common.Vec2</code> in the game properties
	 * @param	p	the property to save
	 * @param	v	the value of the property
	 */
	public void setVec2(Property p, Vec2 v) {
		String x = String.valueOf(v.x);
		String y = String.valueOf(v.y);
		this.setProperty(p.name() + "x", x);
		this.setProperty(p.name() + "y", y);
	}
	
	/**
	 * Read a <code>java.lang.Float</code> in the game properties
	 * @param	p	the property to read
	 * @return the value of the property
	 */
	public Float getFloat(Property p) {
		return Float.parseFloat(this.getProperty(p.name()));
	}
	
	/**
	 * Write a <code>java.lang.Float</code> in the game properties
	 * @param	p	the property to save
	 * @param	v	the value of the property
	 */
	public void setFloat(Property p, Float v) {
		this.setProperty(p.name(), String.valueOf(v));
	}
	
	/**
	 * Alternative constructor for Model singleton
	 * @return the current instance of Model
	 */
	public static Model newInstance() {
		if (s_instance == null) {
			synchronized (Model.class) {
				s_instance = new Model();
			}
		}
		return s_instance;	
	}
	
	/**
	 * Save all the properties in the user settings file
	 */
	public void save() {
		OutputStream loc;
		try {
			loc = new FileOutputStream(new File(USER_LOCATION));
			this.store(loc, "");
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find the file " + USER_LOCATION);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while writing to " + USER_LOCATION);
			e.printStackTrace();
		}
	}
	
	/**
	 * Save all the properties from the specified settings file
	 */
	public void load(String location) {
		InputStream loc;
		try {
			loc = new FileInputStream(new File(location));
			this.load(loc);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find the file " + location);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while writing to " + location);
			e.printStackTrace();
		}
	}
	
	/**
	 * Load all the properties from the user settings file
	 */
	public void load() {
		load(USER_LOCATION);
	}
	
	/**
	 * Load all the properties from the default settings file
	 */
	public void reset() {
		load(DEFAULT_LOCATION);
	}
}
