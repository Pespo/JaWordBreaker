package fr.imac.jwbreaker;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	

	private static final long serialVersionUID = -4879484598126750243L;
	
	private static MainWindow s_instance;
    @SuppressWarnings("unused")
	private Boolean m_state = false;
    private Player _player; public Player get_player() { return _player; } public void set_player(Player _player) { this._player = _player; }

	private MenuPanel _homePanel;
	private GamePanel _gamePanel; public GamePanel get_gamePanel() { return _gamePanel;} public void set_gamePanel(GamePanel _gamePanel) { this._gamePanel = _gamePanel;}
	private OptionPanel _optionPanel;
	private JPanel _mainPanel;
	private CardLayout _mainLayout;
	
	public static enum Cards {
		HOME, GAME, OPTION
	}

	private MainWindow() {
		m_state = true;
		
		_homePanel = new MenuPanel();
		_gamePanel = new GamePanel();
		_optionPanel =  new OptionPanel();
		_mainPanel = new JPanel();
		_mainLayout = new CardLayout();
		
		initParamWindow();
		initLayout();	
		initConstraints();
		
	}
	
	public static MainWindow getInstance() {
		if (s_instance == null) {
			synchronized (MainWindow.class) {
				s_instance = new MainWindow();
			}
		}
		return s_instance;	
	}
	
	public void initParamWindow() {
		setTitle("JaWordBreaker");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void initLayout() {
		_mainPanel.setLayout(_mainLayout);
	}
	
	public void initConstraints() {		
		_mainPanel.add(_homePanel, "Home");
		_mainPanel.add(_gamePanel, "Game");
		_mainPanel.add(_optionPanel, "Option");
		add(_mainPanel);
	}
	
	public void changeCards(Cards cards) {
		switch(cards) {
			case HOME:
				_mainLayout.show(_mainPanel, "Home");
				break;
			case GAME:
				_mainLayout.show(_mainPanel, "Game"); 	
				break;
			case OPTION:
				_mainLayout.show(_mainPanel, "Option");
				break;
			default:
				_mainLayout.show(_mainPanel, "Home");
				break;
		}
	}
	
}
