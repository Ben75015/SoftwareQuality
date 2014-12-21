package application;

import ece.com.gui.Gui;
import ece.com.intefaces.ILandingGear;
import ece.com.model.Plane;


public class Main implements ILandingGear {
	public static void main(final String[] args) throws Exception{
		
		Plane mirage = new Plane();
		
		mirage.addLandingGears();
		Gui gui = new Gui(mirage);
		mirage.setGui(gui);
		mirage.addLandingControlers();
	}
}
