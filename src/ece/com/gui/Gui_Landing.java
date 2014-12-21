package ece.com.gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Gui_Landing extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel lblNameGear;
	JPanel pnlColorGear, pnlColorDoor;
	JLabel lblLockedUp, lblLockedDown, lblManeuvering;
	
	public void majNameGear(String s){
		lblNameGear.setText(s);
	}

	public void majInfosGear(String up, String down, String maneuvering){
		lblLockedUp.setText(up);
		lblLockedDown.setText(down);
		lblManeuvering.setText(maneuvering);
	}
	
	public void majColorGear(Color c){
		pnlColorGear.setBackground(c);
	}
	
	public void majColorDoor(Color c){
		pnlColorDoor.setBackground(c);
	}

	
	public Gui_Landing(){
		
		JPanel pnlNameGear = new JPanel();
		JLabel lblInfosNameGear = new JLabel("Gear : ");
		lblNameGear = new JLabel("?");
		pnlNameGear.add(lblInfosNameGear);
		pnlNameGear.add(lblNameGear);
		
		pnlColorGear = new JPanel();
		pnlColorGear.setBackground(Color.BLACK);
		
		pnlColorDoor=new JPanel();
		pnlColorDoor.setBackground(Color.BLACK);
		
		JPanel pnlInfosRoue = new JPanel();
		pnlInfosRoue.setLayout(new GridLayout(3, 2));
		lblLockedUp = new JLabel("?");
		lblLockedDown = new JLabel("?"); 
		lblManeuvering = new JLabel("?");
		pnlInfosRoue.add(new JLabel("Blocked up : "));
		pnlInfosRoue.add(lblLockedUp);
		pnlInfosRoue.add(new JLabel("Maneuvering : "));
		pnlInfosRoue.add(lblManeuvering);
		pnlInfosRoue.add(new JLabel("Blocked down : "));
		pnlInfosRoue.add(lblLockedDown);
		
		this.setLayout(new GridLayout());
		this.add(pnlNameGear);
		this.add(pnlColorDoor);
		this.add(pnlColorGear);
		this.add(pnlInfosRoue);
		
	}
	
	public static void main(final String[] args) throws Exception{
		@SuppressWarnings("unused")
		Gui_Landing gui = new Gui_Landing();
		
	}
}
