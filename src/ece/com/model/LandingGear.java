package ece.com.model;

import java.util.Observable;
import java.util.Random;

import ece.com.controler.LandingGearControler;
import ece.com.intefaces.ILandingGear;

public class LandingGear extends Observable implements ILandingGear{
	private Gear g = null;
	private Door d = null;
	private LandingGearControler lgC;
	private boolean stopAll;

	public LandingGear(String name){
		g=new Gear(name);
		d=new Door(name);
		g.setLockedUp(true);
		this.stopAll=false;
	}
	
	public void action(final String action){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
					try {
						if(action.equals("open")){
							openGear();
						}
						else if(action.equals("close")){
							closeGear();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}).start();
	}
	
	public int generateTime(){
		Random r = new Random();
//		return (500 + r.nextInt(3000 - 500));
		return 1;
	}
	
	public void openDoor() throws InterruptedException{
		if(d.isClose()){
			
			//on dévérouille la porte
			new TimeLanding(ACTION_DOOR_UNLOCK_UP, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				d.setUnlock(true);
				setChanged();
				notifyObservers(ACTION_DOOR_UNLOCK_UP);
			}
			
			//on ouvre la porte
			new TimeLanding(ACTION_DOOR_UP_TO_DOWN, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				d.setFromHightToDown(true);
				setChanged();
				notifyObservers(ACTION_DOOR_UP_TO_DOWN);
			}
			
			//on vérouille la porte
			new TimeLanding(ACTION_DOOR_LOCK_UP, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				d.setLock(true);
				setChanged();
				notifyObservers(ACTION_DOOR_LOCK_UP);
			}
			
			
		}
	}
	
	public void openGear() throws InterruptedException{
		
		openDoor();
		
		if(g.isLockedUp() && d.isOpen()){
			
			//on dévérouille la roue
			new TimeLanding(ACTION_GEAR_UNLOCK_UP, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				g.setUnlockedUp(true);
				setChanged();
				notifyObservers(ACTION_GEAR_UNLOCK_UP);
			}
			
			//on la baisse
			new TimeLanding(ACTION_GEAR_UP_TO_DOWN, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				g.setFromHightToDown(true);
				setChanged();
				notifyObservers(ACTION_GEAR_UP_TO_DOWN);
			}
			
			
			//on vérouille la roue
			new TimeLanding(ACTION_GEAR_LOCK_DOWN, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				g.setLockedDown(true);
				setChanged();
				notifyObservers(ACTION_GEAR_LOCK_DOWN);
			}
		}
		
	}
	
	public void closeGear() throws InterruptedException{
		
		if(g.isLockedDown() && d.isOpen()){
			
			//on déveouille la roue
			new TimeLanding(ACTION_GEAR_UNLOCK_DOWN, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				g.setUnlockedDown(true);
				setChanged();
				notifyObservers(ACTION_GEAR_UNLOCK_DOWN);
			}
			
			// on passe la roue en up
			new TimeLanding(ACTION_GEAR_DOWN_TO_UP, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				g.setFromDownToHight(true);
				setChanged();
				notifyObservers(ACTION_GEAR_DOWN_TO_UP);
			}
			
			// on verrouille la roue
			new TimeLanding(ACTION_GEAR_LOCK_UP, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				g.setLockedUp(true);
				setChanged();
				notifyObservers(ACTION_GEAR_LOCK_UP);
			}
			closeDoor();
		}
	}

	private void closeDoor() throws InterruptedException {
		if(d.isUnlock()){
			
			//on dévérouille la porte
			new TimeLanding(ACTION_DOOR_UNLOCK_UP, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				d.setUnlock(true);
				setChanged();
				notifyObservers(ACTION_DOOR_UNLOCK_UP);
			}
			
			//on passe la porte en maneuvre
			new TimeLanding(ACTION_DOOR_DOWN_TO_UP, g, d).addObserver(lgC);
			if(!stopAll){
				Thread.sleep(generateTime());
				d.setFromDownToHight(true);
				setChanged();
				notifyObservers(ACTION_DOOR_DOWN_TO_UP);
			}
			
			//on verrouille la porte
			new TimeLanding(ACTION_DOOR_LOCK_UP, g, d);
			if(!stopAll){
				Thread.sleep(generateTime());
				d.setLock(true);
				setChanged();
				notifyObservers(ACTION_DOOR_LOCK_UP);
			}
		}
	}

	public Gear getG() {
		return g;
	}

	public void setG(Gear g) {
		this.g = g;
	}
	public LandingGearControler getLgC() {
		return lgC;
	}

	public void setLgC(LandingGearControler lgC) {
		this.lgC = lgC;
	}

	public boolean isStopAll() {
		return stopAll;
	}

	public void setStopAll(boolean stopAll) {
		this.stopAll = stopAll;
	}


	

	@Override
	public String toString() {
		return "LandingGear [g=" + g + ", d=" + d + ", stopAll=" + stopAll
				+ "]";
	}

	public Door getD() {
		return d;
	}

	public void setD(Door d) {
		this.d = d;
	}
}
