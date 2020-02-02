import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class BGTest extends JFrame implements ActionListener{

	Image img;
	JPanel listPanel;
	JScrollPane mainScrollPane = null;
	
	public BGTest() throws IOException {

		
		// Einlesen des Hintergrundbildes
		Image img = Toolkit.getDefaultToolkit().getImage(System.class.getResource("/backgroundimage.jpg"));
		
		// Wenn der Wert für die Höhe < 0 ist, ist das Bild noch nicht geladen und es
		// kommt nicht zur Anzeige des Hintergrunds. Daher max. 500ms warten.
		int trycounter = 0;
		while (img.getHeight(null) < 0 && trycounter < 50) {
			try {
				Thread.sleep(10);
				trycounter++;
			} catch (InterruptedException e) {
			}
		}
		
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    //initiale Window-Größe
		this.setPreferredSize(new Dimension(800,600));
		/*
		 * Frame MUSS ein Borderlayout haben, weil der Scrollbalken an den
		 * rechten Rand einen Borderlayouts eingesteuert wird.
		 * Hier explizit gesetzt, ist aber auch default.
		 */
		this.setLayout(new BorderLayout(0, 0));
		
		// Button an die Kopfseite, damit er nicht mitgescrollt wird
		JButton button = new JButton("new JPanel");
		button.addActionListener(this);
		button.setAlignmentX(CENTER_ALIGNMENT);
		this.getContentPane().add(button, BorderLayout.PAGE_START);

		
		// Listenpanel mit Boxlayout erstellen.
		// In dem Panel wird auch der Hintergrund gesetzt.
		listPanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.fill( new Rectangle(0, 0, getSize().width, getSize().height) );
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.drawImage(img, 0, 0, getSize().width, getSize().height, null);
			}
		};
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		listPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3, true));
		
		// Erstes Subpanel erstellen und dem Hauptpanel hinzufügen
		addSubPanel();
		
		// Scrollpane erstellen
		mainScrollPane = new JScrollPane(listPanel);
		
		
		// Scrollpane in die Mitte einfügen
		this.getContentPane().add(mainScrollPane, BorderLayout.CENTER);
		
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	/*
	 * fügt dem Listen-Panel eine Sub-Panel hinzu
	 */
	
	private void addSubPanel() {
		JPanel subPanel = new JPanel();
		subPanel.setPreferredSize(new Dimension(500, 200));
		subPanel.setMinimumSize(new Dimension(500, 200));
		subPanel.setMaximumSize(new Dimension(500, 200));
		subPanel.setBackground(Color.RED);
		subPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3, true));
		listPanel.add(subPanel);
	}
	

	public static void main(String[] args) throws IOException {
		new BGTest();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		addSubPanel();
		setVisible(true);
		// immer ans untere Ende scrollen
		JScrollBar sb = mainScrollPane.getVerticalScrollBar();
		if (sb != null) {
			sb.setValue( sb.getMaximum() );
		}
	}

}
