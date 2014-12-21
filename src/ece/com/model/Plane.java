package ece.com.model;

import java.util.ArrayList;

import ece.com.controler.LandingGearControler;
import ece.com.gui.Gui;
import ece.com.gui.Gui_Landing;
import ece.com.intefaces.ILandingGear;


public class Plane implements ILandingGear{
	private ArrayList<LandingGear> lstLandingGear;
	
	private Gui gui;

	public ArrayList<LandingGear> getLstLandingGear() {
		return lstLandingGear;
	}

	public void setLstLandingGear(ArrayList<LandingGear> lstLandingGear) {
		this.lstLandingGear = lstLandingGear;
	}

	public Gui getGui() {
		return gui;
	}

	public void setGui(Gui gui) {
		this.gui = gui;
	}

	public Plane(){
		lstLandingGear = new ArrayList<LandingGear>();
	}
	
	/*
	 * Ajoute les roues standards
	 */
	public void addLandingGears(){
		lstLandingGear.add(new LandingGear(FRONT));
		lstLandingGear.add(new LandingGear(RIGHT));
		lstLandingGear.add(new LandingGear(LEFT));
	}
	
	public void addLandingGear(String nameGear){
		lstLandingGear.add(new LandingGear(nameGear));
	}

	public void openGear() {
		for(LandingGear lg : lstLandingGear){
			lg.action("open");
		}
		
	}
	
	public void closeGear() {
		for(LandingGear lg : lstLandingGear){
			lg.action("close");
		}
		
	}

	public void addLandingControlers() {
		LandingGear lg;
		Gui_Landing gg;
		for(int i=0;i<lstLandingGear.size();i++){
			lg = lstLandingGear.get(i);
			gg = gui.getLstGuiGear().get(i);
			lg.setLgC(new LandingGearControler(lg, gg));
			lg.addObserver(lg.getLgC());
			gg.majNameGear(lg.getG().getName());
			gg.majInfosGear(String.valueOf(lg.getG().isLockedUp()), String.valueOf(lg.getG().isLockedDown()), "");
		
		}
	}
	
	
}
