import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MasterMindPanel extends JPanel {

	private JLabel ckeins;
	private JLabel ckzwei;
	private JLabel ckdrei;
	private JLabel ckvier;
	
	private JButton beins;
	private JButton bzwei;
	private JButton bdrei;
	private JButton bvier;
	
	private JButton bestaetigen;
	
	private static final long serialVersionUID = 1L;

	public MasterMindPanel(Dimension mastermindpanelsize) {
		super();
				
		this.setLayout(null);
		
		this.setPreferredSize(mastermindpanelsize);
		this.setOpaque(true);
		this.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3, true));
		
		//1200x100
		
		//default:
		//Width: 1200
		//Height: 100

		
	    //SCHWARZ, WEIß, GRAU BUTTONS 1-4
	    ckeins = new JLabel();
	    ckeins.setOpaque(true);
	    ckeins.setBackground(Color.white);
	    ckeins.setBounds((int)(mastermindpanelsize.getHeight()/5), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/15), (int)(mastermindpanelsize.getWidth()/15));
	    this.add(ckeins);

	    ckzwei = new JLabel();
	    ckzwei.setOpaque(true);
	    ckzwei.setBackground(Color.black);
	    ckzwei.setBounds((int)(mastermindpanelsize.getHeight()/5), (int)(mastermindpanelsize.getWidth()/7.5), (int)(mastermindpanelsize.getWidth()/15), (int)(mastermindpanelsize.getWidth()/15));
	    this.add(ckzwei);
	    
	    ckdrei = new JLabel();
	    ckdrei.setOpaque(true);
	    ckdrei.setBackground(Color.black);
	    ckdrei.setBounds((int)(mastermindpanelsize.getWidth()/6.5), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/15), (int)(mastermindpanelsize.getWidth()/15));
	    this.add(ckdrei);

	    ckvier = new JLabel();
	    ckvier.setOpaque(true);
	    ckvier.setBackground(Color.white);
	    ckvier.setBounds((int)(mastermindpanelsize.getWidth()/6.5), (int)(mastermindpanelsize.getWidth()/7.5), (int)(mastermindpanelsize.getWidth()/15), (int)(mastermindpanelsize.getWidth()/15));
	    this.add(ckvier);


	    //FARB BUTTONS 1-4
	    beins = new JButton();
	    beins.setOpaque(true);
	    beins.setBackground(Color.blue);
	    beins.setBounds((int)(mastermindpanelsize.getWidth()/3), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/9), (int)(mastermindpanelsize.getWidth()/9));
	    this.add(beins);

	    bzwei = new JButton();
	    bzwei.setOpaque(true);
	    bzwei.setBackground(Color.magenta);
	    bzwei.setBounds((int)(mastermindpanelsize.getWidth()/2.141), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/9), (int)(mastermindpanelsize.getWidth()/9));
	    this.add(bzwei);
	    
	    bdrei = new JButton();
	    bdrei.setOpaque(true);
	    bdrei.setBackground(Color.red);
	    bdrei.setBounds((int)(mastermindpanelsize.getWidth()/1.551), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/9), (int)(mastermindpanelsize.getWidth()/9));
	    this.add(bdrei);
	    
	    bvier = new JButton();
	    bvier.setOpaque(true);
	    bvier.setBackground(Color.green);
	    bvier.setBounds((int)(mastermindpanelsize.getWidth()/1.216), (int)(mastermindpanelsize.getWidth()/45), (int)(mastermindpanelsize.getWidth()/9), (int)(mastermindpanelsize.getWidth()/9));
	    this.add(bvier);
	    
	    
	    //BESTÄTIGEN BUTTON
	    bestaetigen = new JButton();
	    bestaetigen.setOpaque(true);
	    bestaetigen.setBackground(Color.ORANGE);
	    bestaetigen.setFont(new Font("Spielzug beenden", 1, 40));
	    bestaetigen.setBounds((int)(mastermindpanelsize.getWidth()/3.5), (int)(mastermindpanelsize.getHeight()/1.428), (int)(mastermindpanelsize.getWidth()/1.551), (int)(mastermindpanelsize.getHeight()/5));
	    this.add(bestaetigen);

	    

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
		
		bestaetigen.setBounds((int)(size.getWidth()/3.5), (int)(size.getHeight()/1.428), (int)(size.getWidth()/1.551), (int)(size.getHeight()/5));
	}

}
