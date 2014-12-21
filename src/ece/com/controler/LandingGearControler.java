package ece.com.controler;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import ece.com.gui.Gui_Landing;
import ece.com.intefaces.ILandingGear;
import ece.com.model.Door;
import ece.com.model.Gear;
import ece.com.model.LandingGear;
import ece.com.model.TimeLanding;

public class LandingGearControler implements Observer, ILandingGear{

	private LandingGear l=null;
	private Gui_Landing guiLanding;
	
	public LandingGearControler(LandingGear l, Gui_Landing guiGear){
		this.l=l;
		this.guiLanding=guiGear;
	}
	
	@Override
	public void update(Observable obs, Object obj) {
		if(obs instanceof LandingGear){
			l = (LandingGear) obs;
			
			//action
			String action = (String) obj;
			System.out.println(action);
		
			
			
			//GEAR
			Gear g = l.getG();
			if(action.equals(ACTION_GEAR_DOWN_TO_UP) || action.equals(ACTION_DOOR_UP_TO_DOWN)){
				//vue majColor maneuvering
				guiLanding.majColorGear(Color.ORANGE);
			}
			else if(action.equals(ACTION_GEAR_LOCK_DOWN)){
				//vue majColor down
				guiLanding.majColorGear(Color.GREEN);
			}
			else if(action.equals(ACTION_GEAR_LOCK_UP)){
				//vue majColor up
				guiLanding.majColorGear(Color.BLACK);
			}
			guiLanding.majInfosGear(String.valueOf(l.getG().isLockedUp()), String.valueOf(l.getG().isLockedDown()), "");
			
			
			//DOOR
			Door d = l.getD();
			if(d.isClose())
				guiLanding.majColorDoor(Color.BLACK);
			else if ((d.isFromDownToHight() || d.isFromHightToDown()) && d.isUnlock())
				guiLanding.majColorDoor(Color.ORANGE);
			else if (d.isOpen()){
				guiLanding.majColorDoor(Color.GREEN);
			}
//			System.out.println(l.getG());
//			System.out.println(l.getD());
		}
		
		else if(obs instanceof TimeLanding){
			TimeLanding tg = (TimeLanding) obs;
	
			if(obj instanceof String){
				
				String action = (String) obj;
				l.setStopAll(true);
				System.out.println("Error : "+action+" !!!! Roue : "+tg.getG());
				//mettre toute la roue en rouge
				guiLanding.setBackground(Color.red);
			}
		}
	}

}
