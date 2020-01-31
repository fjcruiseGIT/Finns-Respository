package Game.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Game.Sound.Sound;

public class Window extends JFrame implements ActionListener {

	private JMenuItem quitItem;
	private JMenuItem newGame;
	private JMenuItem background0;
	private JMenuItem background1;
	private JMenuItem background2;
	private JMenuItem background3;
	private JMenuItem music1;
	private JMenuItem music2;
	private JMenuItem music3;
	private JMenuItem stop;
	private JButton farbe1 = new JButton();
	private JButton farbe2;
	private JButton farbe3;
	private JButton farbe4;
	private JButton los;
	private JPanel hintergrund;
	private JPanel panelcontainer = new JPanel();
	private Sound sound;
	private Color[] mainCode = new Color[4];
	private Color[] mmaincode = new Color[4];
	private int counter[] = {1,1,1,1};
	private Color[] Colors = { Color.white, Color.red, Color.orange, Color.green, Color.blue, Color.magenta };
	private Dimension mastermindpanelsize;
	
	private Set<MasterMindPanel> MasterMindPanelSet = new HashSet<MasterMindPanel>();
	private JScrollPane scrollpane;
	
	private void setmastermindpanelsize() {
		int mastermindpanelwidth = this.getWidth() - 40;
		int mastermindpanelheight = (int) Math.round(mastermindpanelwidth/4.5);
		
		mastermindpanelsize = new Dimension(mastermindpanelwidth, mastermindpanelheight);
	}
	public void NächsterZug() {
		resetMain();
		MasterMindPanel panel = new MasterMindPanel(this, mastermindpanelsize);
		MasterMindPanelSet.add(panel);
		panelcontainer.add(panel);
		
		setContentPane(hintergrund);
		panel.resizePanel(mastermindpanelsize);
		setVisible(true);
	}

	public Window() {
		super("MasterMind");
		setmastermindpanelsize();
		eingabe();
		
	}

	private void windoww() {
		hintergrund = setHintergrund(0);
		setContentPane(hintergrund);
		panelcontainer.setLayout(new GridLayout(12, 1));
		
		Dimension  screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		double verhaeltnis = (double) 1200/450;
		
		//initiale Window-Größe
		this.setSize((int)(screen.getWidth()/2), (int)((screen.getHeight()/2)));
		
		//minimale Window-Größe
		this.setMinimumSize(new Dimension((int)(screen.getWidth()/8), (int)((screen.getHeight()/8)*verhaeltnis)));
		
		
		
		MasterMindPanel spielzug = new MasterMindPanel(this, mastermindpanelsize);
		MasterMindPanelSet.add(spielzug);
		panelcontainer.add(spielzug);
		
		
		registerWindowListener();
		createMenu();
		panelcontainer.setOpaque(false);
		setTitle("MasterMind");
		setLocation(10, 10);
		
		
		scrollpane = new JScrollPane(panelcontainer);
		scrollpane.getVerticalScrollBar().setUnitIncrement(20);		//Scroll Speed
		
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	//Keine Horizontale Scrollbar
		this.add(scrollpane);
		
		
		
		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentResized(ComponentEvent e) {

				int mastermindpanelwidth = getWidth() - 40;
				int mastermindpanelheight = (int) Math.round(mastermindpanelwidth/4.5);
				
				Dimension mastermindpanelsize = new Dimension(mastermindpanelwidth, mastermindpanelheight);

				Iterator<MasterMindPanel> i = MasterMindPanelSet.iterator();
				
				while (i.hasNext()) {
					
					MasterMindPanel p = (MasterMindPanel) i.next();
					p.resizePanel(mastermindpanelsize);
				}
				
				panelcontainer.setPreferredSize(new Dimension(getWidth() -40, (int)mastermindpanelheight*12));
			}
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		setVisible(true);
		sound = new Sound();
	}
	
	private JFrame eingabeFrame;
	
	private void eingabe() {
		// TODO Auto-generated method stub
		eingabeFrame = new JFrame();
		eingabeFrame.setSize(350, 155);
		eingabeFrame.setLayout(new GridLayout(1, 1));

		JPanel panel = new JPanel();
		panel.setBackground(Color.gray);
		panel.setLayout(null);

		farbe1 = new JButton("");
		farbe1.setOpaque(true);
		farbe1.setBackground(Color.white);
		farbe1.setBounds(20, 20, 50, 50);
		panel.add(farbe1);

		farbe2 = new JButton("");
		farbe2.setBackground(Color.white);
		farbe2.setOpaque(true);
		farbe2.setBounds(100, 20, 50, 50);
		panel.add(farbe2);

		farbe3 = new JButton("");
		farbe3.setBackground(Color.white);
		farbe3.setOpaque(true);
		farbe3.setBounds(180, 20, 50, 50);
		panel.add(farbe3);

		farbe4 = new JButton("");
		farbe4.setBackground(Color.white);
		farbe4.setOpaque(true);
		farbe4.setBounds(260, 20, 50, 50);
		panel.add(farbe4);

		los = new JButton("Eingabe");
		los.setBackground(Color.orange);
		los.setOpaque(true);
		los.setBounds(20, 70, 290, 25);

		panel.add(los);

		farbe1.addActionListener(this);
		farbe2.addActionListener(this);
		farbe3.addActionListener(this);
		farbe4.addActionListener(this);
		los.addActionListener(this);

		eingabeFrame.add(panel);

		Object[] options = { "Eingene Eingabe", "Computergeneriert" };
		int n = JOptionPane.showOptionDialog(null, "Herzlich willkommen, bitte wähle eine Eingabemethode", "Starten", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
		if (n == 0) {
			eingabeFrame.setVisible(true);
		} else {
			random();
			windoww();
		}
	}

	private void random() {
		// TODO Auto-generated method stub
		mainCode[0] = Colors[(int) (Math.random() * 4)];
		mainCode[1] = Colors[(int) (Math.random() * 4)];
		mainCode[2] = Colors[(int) (Math.random() * 4)];
		mainCode[3] = Colors[(int) (Math.random() * 4)];
		resetMain();
	}

	private void resetMain() {
		for (int i = 0; i < 4; i++) {
			mmaincode[i] = mainCode[i];
		}
	}

	public Color[] getMainCode() {
		resetMain();
		return mmaincode;
	}

	public JPanel setHintergrund(int i) {
		if (i == 0) {
			hintergrund = new bgPanel(0).getHintergrundPanel();
		} else {
			hintergrund = new bgPanel(i);
		}
		return hintergrund;
	}

	private void registerWindowListener() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// hier werden wir später unser Spiel pausieren
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// hier werden wir später unser Spiel wieder fortsetzen
			}
		});
	}

	private void createMenu() {

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
		JMenu gameMenu = new JMenu("Game");
		JMenu prefMenu = new JMenu("Preferences");

		menuBar.add(fileMenu);
		menuBar.add(gameMenu);
		menuBar.add(prefMenu);

		addFileMenuItems(fileMenu);
		addPreferencsMenuItems(prefMenu);
		addGameMenuItems(gameMenu);
	}

	private void addGameMenuItems(JMenu gameMenu) {
		// TODO Auto-generated method stub
		newGame = new JMenuItem("Neues Spiel");
		gameMenu.add(newGame);
		newGame.addActionListener(this);
	}

	private void addFileMenuItems(JMenu fileMenu) {

		quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		quitItem.addActionListener(this);
	}

	private void addPreferencsMenuItems(JMenu prefMenu) {
		JMenu bg = new JMenu("Hintergründe");
		background0 = new JMenuItem("Hintergund grau");
		background1 = new JMenuItem("Spielsteinhintergrund");
		background2 = new JMenuItem("Hintergrund Lavafall");
		background3 = new JMenuItem("Transparent ");

		bg.add(background0);
		bg.add(background1);
		bg.add(background2);
		bg.add(background3);
		prefMenu.add(bg);
		background0.addActionListener(this);
		background1.addActionListener(this);
		background2.addActionListener(this);
		background3.addActionListener(this);

		JMenu sound = new JMenu("Musik");
		music1 = new JMenuItem("chillout energetisch");
		music2 = new JMenuItem("Piano");
		music3 = new JMenuItem("rock oder so");
		stop = new JMenuItem("stopp");
		sound.add(music1);
		sound.add(music2);
		sound.add(music3);
		sound.add(stop);
		prefMenu.add(sound);
		music1.addActionListener(this);
		music2.addActionListener(this);
		music3.addActionListener(this);
		stop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object Quelle = e.getSource();
		if (Quelle == quitItem) {
			System.exit(0);
		}
		if (Quelle == newGame) {
			dispose();
			new Window();
		}
		if (Quelle == background0) {
			hintergrund = setHintergrund(0);
			setContentPane(hintergrund);
			add(panelcontainer);
			setVisible(true);
		}
		if (Quelle == background1) {
			hintergrund = setHintergrund(1);
			setContentPane(hintergrund);
			add(panelcontainer);
			setVisible(true);

		}
		if (Quelle == background2) {
			hintergrund = setHintergrund(2);
			setContentPane(hintergrund);
			add(panelcontainer);
			setVisible(true);

		}
		if (Quelle == background3) {
			hintergrund = setHintergrund(3);
			setContentPane(hintergrund);
			add(panelcontainer);
			setVisible(true);
		}

		if (Quelle == music1) {
			sound.play1();
		}
		if (Quelle == music2) {
			sound.play2();
		}
		if (Quelle == music3) {
			sound.play3();
		}
		if (Quelle == stop) {
			sound.stopAll();
		}

		if (Quelle == farbe1) {
			nextcolor(farbe1, 0);
		}
		if (Quelle == farbe2) {
			nextcolor(farbe2, 1);
		}
		if (Quelle == farbe3) {
			nextcolor(farbe3, 2);
		}
		if (Quelle == farbe4) {
			nextcolor(farbe4, 3);
		}
		if(Quelle == los) {
			mainCode[0]=farbe1.getBackground();
			mainCode[1]=farbe2.getBackground();
			mainCode[2]=farbe3.getBackground();
			mainCode[3]=farbe4.getBackground();
			eingabeFrame.setVisible(false);
			windoww();
		}
	}

	private void nextcolor(JButton farbe1, int i) {
		// TODO Auto-generated method stub
		farbe1.setBackground(Colors[counter[i]]);
		if (counter[i] + 1 > 5) {
			counter[i] = 0;
		} else {
			counter[i]++;
		}
	}

	public void schließen(int i) {
		// TODO Auto-generated method stub
		System.out.println(i);
		panelcontainer.removeAll();
	}
}