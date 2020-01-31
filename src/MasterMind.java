import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class MasterMind {

	
	private Set<MasterMindPanel> MasterMindPanelSet = new HashSet<MasterMindPanel>();
	private JPanel panelcontainer = new JPanel();
	private JScrollPane scrollpane;
	
	public static void main(String[] args) {

		new MasterMind();
	}
	
	public MasterMind() {
		
		// Test-Frame
		JFrame Frame = new JFrame("mastermind TEST");
		
		Dimension  screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		double verhaeltnis = (double) 1200/450;
		
		//initiale Window-Größe
		Frame.setSize((int)(screen.getWidth()/2), (int)((screen.getHeight()/2)));
		
		//minimale Window-Größe
		Frame.setMinimumSize(new Dimension((int)(screen.getWidth()/8), (int)((screen.getHeight()/8)*verhaeltnis)));
		

		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelcontainer.setLayout(new GridLayout(12, 1));

		int mastermindpanelwidth = Frame.getWidth() - 40;
		int mastermindpanelheight = (int) Math.round(mastermindpanelwidth/4.5);
		
		Dimension mastermindpanelsize = new Dimension(mastermindpanelwidth, mastermindpanelheight);
		
		Frame.setVisible(true);
		
		for (int i = 0; i < 12; i++) {
			
			MasterMindPanel Panel = new MasterMindPanel(mastermindpanelsize);
			
			MasterMindPanelSet.add(Panel);
			
			panelcontainer.add(Panel);
		}
		
		scrollpane = new JScrollPane(panelcontainer);
		scrollpane.getVerticalScrollBar().setUnitIncrement(20);		//Scroll Speed
		
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	//Keine Horizontale Scrollbar
		Frame.add(scrollpane);
		
		Frame.setVisible(true);

		Frame.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentResized(ComponentEvent e) {

				int mastermindpanelwidth = Frame.getWidth() - 40;
				int mastermindpanelheight = (int) Math.round(mastermindpanelwidth/4.5);
				
				Dimension mastermindpanelsize = new Dimension(mastermindpanelwidth, mastermindpanelheight);

				Iterator<MasterMindPanel> i = MasterMindPanelSet.iterator();
				
				while (i.hasNext()) {
					
					MasterMindPanel p = (MasterMindPanel) i.next();
					p.resizePanel(mastermindpanelsize);
				}
				
				panelcontainer.setPreferredSize(new Dimension(Frame.getWidth() -40, (int)mastermindpanelheight*12));
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
		
		

		lookAndFeel();

		Frame.setVisible(true);

	}
	
	public static void lookAndFeel() {

		try {
			String Plaf = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(Plaf);
		}

		catch (Exception X) {
			System.err.println("Fehler");
		}
	}

}
