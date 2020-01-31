package Game.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Game.logic;
import Game.Sound.Sound;

public class MasterMindPanel extends JPanel implements ActionListener {

	private JLabel ckzwei;
	private static final long serialVersionUID = 1L;
	private JLabel ckeins;
	private JLabel ckdrei;
	private JLabel ckvier;
	private JButton beins;
	private JButton bzwei;
	private JButton bdrei;
	private JButton bvier;
	private JButton eingabe;
	private int counter0 = 1;
	private int counter1 = 1;
	private int counter2 = 1;
	private int counter3 = 1;
	private Window parent;
	private logic logic;

	private Sound sound = new Sound();
	private int[] hint = new int[4];
	private Color[] Colors = { Color.white, Color.red, Color.orange, Color.green, Color.blue, Color.magenta };
	private Color[] bColors = new Color[4];

	public MasterMindPanel(Window parent, Dimension mastermindpanelsize) {
		super();

		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3, true));

		this.setPreferredSize(mastermindpanelsize); 	// 450x100
		
		this.parent = parent;
		
		this.setLayout(null);

		this.setOpaque(false);

		// SCHWARZ, WEIß, GRAU BUTTONS 1-4
		ckeins = new JLabel("");
		ckeins.setOpaque(true);
		ckeins.setBackground(Color.gray);
		ckeins.setBounds((int)(mastermindpanelsize.getHeight()/5), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/15), (int)(mastermindpanelsize.getWidth()/15));
		this.add(ckeins);

		ckzwei = new JLabel("");
		ckzwei.setOpaque(true);
		ckzwei.setBackground(Color.gray);
		ckzwei.setBounds((int)(mastermindpanelsize.getHeight()/5), (int)(mastermindpanelsize.getWidth()/7.5), (int)(mastermindpanelsize.getWidth()/15), (int)(mastermindpanelsize.getWidth()/15));
		this.add(ckzwei);

		ckdrei = new JLabel("");
		ckdrei.setOpaque(true);
		ckdrei.setBackground(Color.gray);
		ckdrei.setBounds((int)(mastermindpanelsize.getWidth()/6.5), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/15), (int)(mastermindpanelsize.getWidth()/15));
		this.add(ckdrei);

		ckvier = new JLabel("");
		ckvier.setOpaque(true);
		ckvier.setBackground(Color.gray);
		ckvier.setBounds((int)(mastermindpanelsize.getWidth()/6.5), (int)(mastermindpanelsize.getWidth()/7.5), (int)(mastermindpanelsize.getWidth()/15), (int)(mastermindpanelsize.getWidth()/15));
		this.add(ckvier);
		
		
		// FARB BUTTONS 1-4
		beins = new JButton("");
		beins.setOpaque(true);
		beins.setBounds((int)(mastermindpanelsize.getWidth()/3), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/9), (int)(mastermindpanelsize.getWidth()/9));
		beins.setBackground(Color.white);
		this.add(beins);
		beins.addActionListener(this);

		bzwei = new JButton("");
		bzwei.setOpaque(true);
		bzwei.setBackground(Color.white);
		bzwei.setBounds((int)(mastermindpanelsize.getWidth()/2.141), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/9), (int)(mastermindpanelsize.getWidth()/9));
		this.add(bzwei);
		bzwei.addActionListener(this);

		bdrei = new JButton("");
		bdrei.setOpaque(true);
		bdrei.setBackground(Color.white);
		bdrei.setBounds((int)(mastermindpanelsize.getWidth()/1.551), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/9), (int)(mastermindpanelsize.getWidth()/9));
		this.add(bdrei);
		bdrei.addActionListener(this);

		bvier = new JButton("");
		bvier.setOpaque(true);
		bvier.setBackground(Color.white);
		bvier.setBounds((int)(mastermindpanelsize.getWidth()/1.216), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/9), (int)(mastermindpanelsize.getWidth()/9));
		this.add(bvier);
		bvier.addActionListener(this);

		// BESTÄTIGEN BUTTON
		eingabe = new JButton("Spielzug beenden");
		eingabe.setOpaque(true);
		eingabe.setBackground(new Color(13, 255, 148));
		eingabe.setBounds((int)(mastermindpanelsize.getWidth()/3.5), (int)(mastermindpanelsize.getHeight()/1.428), (int)(mastermindpanelsize.getWidth()/1.551), (int)(mastermindpanelsize.getHeight()/5));
		this.add(eingabe);
		eingabe.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object quelle = e.getSource();

		if (quelle == beins) {
			switchcolor0(beins);
		}
		if (quelle == bzwei) {
			switchcolor1(bzwei);
		}
		if (quelle == bdrei) {
			switchcolor2(bdrei);
		}
		if (quelle == bvier) {
			switchcolor3(bvier);
		}
		if (quelle == eingabe) {
			beins.setEnabled(false);
			bzwei.setEnabled(false);
			bdrei.setEnabled(false);
			bvier.setEnabled(false);
			eingabe.setEnabled(false);

			setColorsinbColors();
			logic = new logic(bColors,parent.getMainCode());
			int i = logic.ausfuehren();
			hint = logic.returnHint();
			setlabelhint(hint);
			
			if (i == 1) {
				hint[0]=2;
				hint[1]=2;
				hint[2]=2;
				hint[3]=2;
				setlabelhint(hint);
				beenden();
			}
			else {
				parent.NächsterZug();
			}
		}
	}

	private void beenden() {
		// TODO Auto-generated method stub
		JDialog gewonnen = new JDialog();
		sound.stopAll();
		sound.playj();
		Object[] options = { "Neues Spiel", "Verlassen" };
		int n = JOptionPane.showOptionDialog(null, "Herzlichen Glückwunsch! Das Rätsel wurde gelöst", "Gewonnen", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
		if (n == 0) {
			parent.dispose();
			parent = new Window();
		} else {
			System.exit(0);
		}
		System.out.println("gewonnen");
	}

	public void setlabelhint(int[] hint) {
		// TODO Auto-generated method stub
		if (hint[0] == 0) {
			ckeins.setBackground(Color.gray);
		}
		if (hint[0] == 1) {
			ckeins.setBackground(Color.white);
		}
		if (hint[0] == 2) {
			ckeins.setBackground(Color.black);
		}
		if (hint[1] == 0) {
			ckzwei.setBackground(Color.gray);
		}
		if (hint[1] == 1) {
			ckzwei.setBackground(Color.white);
		}
		if (hint[1] == 2) {
			ckzwei.setBackground(Color.black);
		}
		if (hint[2] == 0) {
			ckdrei.setBackground(Color.gray);
		}
		if (hint[2] == 1) {
			ckdrei.setBackground(Color.white);
		}
		if (hint[2] == 2) {
			ckdrei.setBackground(Color.black);
		}
		if (hint[3] == 0) {
			ckvier.setBackground(Color.gray);
		}
		if (hint[3] == 1) {
			ckvier.setBackground(Color.white);
		}
		if (hint[3] == 2) {
			ckvier.setBackground(Color.black);
		}
	}

	private void setColorsinbColors() {
		// TODO Auto-generated method stub
		bColors[0] = beins.getBackground();
		bColors[1] = bzwei.getBackground();
		bColors[2] = bdrei.getBackground();
		bColors[3] = bvier.getBackground();
	}

	public Color[] getbColors() {
		return bColors;
	}

	private void switchcolor0(JButton button) {
		// TODO Auto-generated method stub
		button.setBackground(Colors[counter0]);
		if (counter0 + 1 > 5) {
			counter0 = 0;
		} else {
			counter0++;
		}

	}

	private void switchcolor1(JButton button) {
		// TODO Auto-generated method stub
		button.setBackground(Colors[counter1]);
		if (counter1 + 1 > 5) {
			counter1 = 0;
		} else {
			counter1++;
		}

	}

	private void switchcolor2(JButton button) {
		// TODO Auto-generated method stub
		button.setBackground(Colors[counter2]);
		if (counter2 + 1 > 5) {
			counter2 = 0;
		} else {
			counter2++;
		}

	}

	private void switchcolor3(JButton button) {
		// TODO Auto-generated method stub
		button.setBackground(Colors[counter3]);
		if (counter3 + 1 > 5) {
			counter3 = 0;
		} else {
			counter3++;
		}
	}
	
	public void resizePanel(Dimension size) {
		
		ckeins.setBounds((int)(size.getHeight()/5), (int)(size.getWidth()/45), (int)(size.getWidth()/15), (int)(size.getWidth()/15));
		ckzwei.setBounds((int)(size.getHeight()/5), (int)(size.getWidth()/7.5), (int)(size.getWidth()/15), (int)(size.getWidth()/15));
		ckdrei.setBounds((int)(size.getWidth()/6.5), (int)(size.getWidth()/45), (int)(size.getWidth()/15), (int)(size.getWidth()/15));
		ckvier.setBounds((int)(size.getWidth()/6.5), (int)(size.getWidth()/7.5), (int)(size.getWidth()/15), (int)(size.getWidth()/15));
		
		beins.setBounds((int)(size.getWidth()/3.5), (int)(size.getWidth()/45), (int)(size.getWidth()/9), (int)(size.getWidth()/9));
		bzwei.setBounds((int)(size.getWidth()/2.142), (int)(size.getWidth()/45), (int)(size.getWidth()/9), (int)(size.getWidth()/9));
		bdrei.setBounds((int)(size.getWidth()/1.551), (int)(size.getWidth()/45), (int)(size.getWidth()/9), (int)(size.getWidth()/9));
		bvier.setBounds((int)(size.getWidth()/1.216), (int)(size.getWidth()/45), (int)(size.getWidth()/9), (int)(size.getWidth()/9));
		
		eingabe.setBounds((int)(size.getWidth()/3.5), (int)(size.getHeight()/1.428), (int)(size.getWidth()/1.551), (int)(size.getHeight()/5));
	}
}
