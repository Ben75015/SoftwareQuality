package ece.com.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ece.com.model.Plane;


@SuppressWarnings("serial")
public class Gui extends JFrame implements ActionListener {
	
	private ArrayList<Gui_Landing> lstGuiGear;
	private boolean estEnVol;
	private Plane plane;
	private JButton btnLevier;
	private static String ACTION_BTN_LEVIER = "Action sur le levier";
	
	public ArrayList<Gui_Landing> getLstGuiGear() {
		return lstGuiGear;
	}

	public Gui(Plane plane) throws IOException{
		this.plane=plane;
		lstGuiGear=new ArrayList<Gui_Landing>();
		//par défaut l'avion est en vol, les roues sont rétractés
		estEnVol=true;
		
		JLabel pnlBackGround = new JLabel(new ImageIcon(ImageIO.read(new File("cabine.png"))));
		
		pnlBackGround.setLayout(new FlowLayout());
		//ajout du bouton levier
		btnLevier = new JButton(new ImageIcon(ImageIO.read(new File("levier_haut.png"))));
		btnLevier.addActionListener(this);
		btnLevier.setActionCommand(ACTION_BTN_LEVIER);
		
		for(int i=0;i<plane.getLstLandingGear().size();i++){
			Gui_Landing gr = new Gui_Landing();
			lstGuiGear.add(gr);
			pnlBackGround.add(gr);
		}
		pnlBackGround.add(btnLevier);
		
		//propriétés de la JFrame
		this.add(pnlBackGround);
		this.pack();
		this.setTitle("");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	private void disableBtnLevier(){
		new Thread(new Runnable() {
			@Override
			public void run() {btnLevier.setEnabled(false);
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				btnLevier.setEnabled(true);
				
			}
		}).start();
	}
	
	//action sur le bouton levier
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(ACTION_BTN_LEVIER)){
			

					try {
						if(estEnVol){//en vol : on sort les roues
							btnLevier.setIcon(new ImageIcon(ImageIO.read(new File("levier_bas.png"))));
							estEnVol = !estEnVol;
							//disableBtnLevier();
							plane.openGear();
						}else{
							btnLevier.setIcon(new ImageIcon(ImageIO.read(new File("levier_haut.png"))));
							estEnVol = !estEnVol;
							//disableBtnLevier();
							plane.closeGear();
						}
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
			
		}
	}
}
