package fr.imac.jwbreaker;

public class Player {
	private String _login;
	
	private static Player s_instance;
    @SuppressWarnings("unused")
	private Boolean m_state = false;
	
	private Player() {
		m_state = true;
		_login = "Anonymous";
	}
	
	public static Player getInstance() {
		if (s_instance == null) {
			synchronized (Player.class) {
				s_instance = new Player();
			}
		}
		return s_instance;	
	}

	public String get_login() {
		return _login;
	}

	public void set_login(String login) {
		System.out.println("pseudo " + login);
		_login = login;
		System.out.println("pseudo " + _login);
	}
}
