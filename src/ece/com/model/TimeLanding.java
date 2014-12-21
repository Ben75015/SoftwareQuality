package ece.com.model;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import ece.com.intefaces.ILandingGear;


public class TimeLanding extends Observable implements ILandingGear{
	private String action="";
	private Gear g=null;
	private Door d=null;
	int timeVal=0; // en millisecondes

	public TimeLanding(String action, Gear g, Door d){
		this.action=action;
		this.g=g;
		this.d=d;
		initTimeVal();
		executeTimer();
	}
	
	public void initTimeVal(){
		
		//GEAR
		if(action.equals(ACTION_GEAR_UP_TO_DOWN)){
			if(g.getName().equals(FRONT))
				timeVal=1200;
			else if(g.getName().equals(LEFT))
				timeVal=1600;
			else if(g.getName().equals(RIGHT))
				timeVal=1600;
		}
		else if (action.equals(ACTION_GEAR_DOWN_TO_UP)){
			if(g.getName().equals(FRONT))
				timeVal=1600;
			else if(g.getName().equals(LEFT))
				timeVal=2000;
			else if(g.getName().equals(RIGHT))
				timeVal=2000;
		}
		else if (action.equals(ACTION_GEAR_UNLOCK_DOWN)){
			if(g.getName().equals(FRONT))
				timeVal=800;
			else if(g.getName().equals(LEFT))
				timeVal=800;
			else if(g.getName().equals(RIGHT))
				timeVal=800;
		}
		else if (action.equals(ACTION_GEAR_LOCK_DOWN)){
			if(g.getName().equals(FRONT))
				timeVal=400;
			else if(g.getName().equals(LEFT))
				timeVal=400;
			else if(g.getName().equals(RIGHT))
				timeVal=400;
		}
		else if (action.equals(ACTION_GEAR_UNLOCK_UP)){
			if(g.getName().equals(FRONT))
				timeVal=800;
			else if(g.getName().equals(LEFT))
				timeVal=800;
			else if(g.getName().equals(RIGHT))
				timeVal=800;
		}
		else if (action.equals(ACTION_GEAR_LOCK_UP)){
			if(g.getName().equals(FRONT))
				timeVal=400;
			else if(g.getName().equals(LEFT))
				timeVal=400;
			else if(g.getName().equals(RIGHT))
				timeVal=400;
		}
		
		//DOOR
		if(action.equals(ACTION_DOOR_DOWN_TO_UP)){
			if(d.getName().equals(FRONT))
				timeVal=1200;
			else if(d.getName().equals(RIGHT))
				timeVal=1600;
			else if(d.getName().equals(LEFT))
				timeVal=1600;
		}
		else if(action.equals(ACTION_DOOR_UP_TO_DOWN)){
			if(d.getName().equals(FRONT))
				timeVal=1200;
			else if(d.getName().equals(RIGHT))
				timeVal=1500;
			else if(d.getName().equals(LEFT))
				timeVal=1500;
		}
		else if(action.equals(ACTION_DOOR_LOCK_UP)){
			if(d.getName().equals(FRONT))
				timeVal=300;
			else if(d.getName().equals(RIGHT))
				timeVal=300;
			else if(d.getName().equals(LEFT))
				timeVal=300;
		}
		else if(action.equals(ACTION_DOOR_UNLOCK_UP)){
			if(d.getName().equals(FRONT))
				timeVal=400;
			else if(d.getName().equals(RIGHT))
				timeVal=400;
			else if(d.getName().equals(LEFT))
				timeVal=400;
		}
	}
	
	public void executeTimer(){
		
		Timer time = new Timer();
		time.schedule(new TimerTask() {
			  @Override
			  public void run() {
				//GEAR
			    if(action.equals(ACTION_GEAR_UP_TO_DOWN) && !g.isFromHightToDown()){
			    	setChanged();
					notifyObservers(ACTION_GEAR_UP_TO_DOWN);
			    }
			    if(action.equals(ACTION_GEAR_DOWN_TO_UP) && !g.isFromDownToHight()){
			    	setChanged();
					notifyObservers(ACTION_GEAR_DOWN_TO_UP);
			    }
			    if(action.equals(ACTION_GEAR_UNLOCK_DOWN) && !g.isUnlockedDown()){
			    	setChanged();
					notifyObservers(ACTION_GEAR_UNLOCK_DOWN);
			    }
			    if(action.equals(ACTION_GEAR_LOCK_DOWN) && !g.isLockedDown()){
			    	setChanged();
					notifyObservers(ACTION_GEAR_LOCK_DOWN);
			    }
			    if(action.equals(ACTION_GEAR_UNLOCK_UP) && !g.isUnlockedUp()){
			    	setChanged();
					notifyObservers(ACTION_GEAR_UNLOCK_UP);
			    }
			    if(action.equals(ACTION_GEAR_LOCK_UP) && !g.isLockedUp()){
			    	setChanged();
					notifyObservers(ACTION_GEAR_LOCK_UP);
			    }
			    //DOOR
			    if(action.equals(ACTION_DOOR_UP_TO_DOWN) && !d.isFromHightToDown()){
			    	setChanged();
					notifyObservers(ACTION_DOOR_UP_TO_DOWN);
			    }
			    if(action.equals(ACTION_DOOR_DOWN_TO_UP) && !d.isFromDownToHight()){
			    	setChanged();
					notifyObservers(ACTION_DOOR_DOWN_TO_UP);
			    }
			    if(action.equals(ACTION_DOOR_UNLOCK_UP) && !d.isUnlock()){
			    	setChanged();
					notifyObservers(ACTION_DOOR_UNLOCK_UP);
			    }
			    if(action.equals(ACTION_DOOR_LOCK_UP) && !d.isLock()){
			    	setChanged();
					notifyObservers(ACTION_DOOR_LOCK_UP);
			    }
			    
//			    if(action.equals(ACTION_GEAR_UNLOCK_DOWN))
			    
			  }
			}, timeVal);
	}
	
	public Gear getG() {
		return g;
	}

	public void setG(Gear g) {
		this.g = g;
	}
}
