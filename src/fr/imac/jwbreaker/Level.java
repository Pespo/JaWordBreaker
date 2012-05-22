package fr.imac.jwbreaker;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.table.DefaultTableModel;

public class Level extends DefaultTableModel {

	private static final long serialVersionUID = -3469818945361593152L;
	private int m_difficulty;
	
	public Level(int d) {
		m_difficulty = d;
	}

	public void save() {
        ObjectOutputStream oos;
        try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("level_" + m_difficulty))));
	        oos.writeObject(this);
	        oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load() {
		ObjectInputStream ois;
    	try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("level_" + m_difficulty))));
			Level readed = (Level)ois.readObject();
			this.dataVector = readed.dataVector;
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
