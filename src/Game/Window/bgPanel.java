package Game.Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class bgPanel extends JPanel {
	private Image backgroundImage[] = new Image[3];
	private Image backgroundImagee;
	private JPanel HintergrundPanel = new JPanel();

	public bgPanel(int i) {
		// ii = i;
		if (i == 0) {
			HintergrundPanel.setBackground(Color.lightGray);
		}

		if (i == 1) {
			try {
				backgroundImage[2] = ImageIO.read(System.class.getResource("/backgroundimage.jpg"));
				backgroundImagee = backgroundImage[2];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (i == 2) {
			try {
				backgroundImage[1] = ImageIO.read(System.class.getResource("/bg2.jpg"));
				backgroundImagee = backgroundImage[1];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (i == 3) {
			try {
				backgroundImage[0] = ImageIO.read(System.class.getResource("/transparent.png"));
				backgroundImagee = backgroundImage[0];
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

//		g.drawImage(backgroundImage, 0, 0, null);
		g.drawImage(backgroundImagee, 0, 0, getWidth(), getHeight(), null);
	}

	public JPanel getHintergrundPanel() {
		return HintergrundPanel;
	}
}
