package ece.com.model;




public class Gear{

	private String name = "";
	private boolean unlockedDown;
	private boolean lockedDown;
	private boolean unlockedUp;
	private boolean lockedUp;
	private boolean fromDownToHight;
	private boolean fromHightToDown;

	public Gear(String name){
		this.name=name;
		initLock();
		initTransfert();
		//la roue est par défaut rétractée
		lockedDown=true;
	}
	
	public void initLock(){
		lockedDown=false;
		lockedUp=false;
		unlockedUp=false;
		unlockedDown=false;
	}
	
	public void initTransfert(){
		fromHightToDown=false;
		fromDownToHight=false;
	}
	
	public boolean isExtented(){
		return lockedDown;
	}
	
	public boolean isRetracted(){
		return lockedUp;
	}

	public boolean isFromHightToDown() {
		return fromHightToDown;
	}

	public void setFromHightToDown(boolean fromHightToDown) {
		initTransfert();
		this.fromHightToDown = fromHightToDown;
	}

	public boolean isFromDownToHight() {
		return fromDownToHight;
	}

	public void setFromDownToHight(boolean fromDownToHight) {
		initTransfert();
		this.fromDownToHight = fromDownToHight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLockedDown() {
		return lockedDown;
	}

	public void setLockedDown(boolean lockedDown) {
		initLock();
		this.lockedDown = lockedDown;
	}

	public boolean isLockedUp() {
		return lockedUp;
	}

	public void setLockedUp(boolean lockedUp) {
		initLock();
		this.lockedUp = lockedUp;
	}

	public boolean isUnlockedDown() {
		return unlockedDown;
	}

	public void setUnlockedDown(boolean unlockedDown) {
		initLock();
		this.unlockedDown = unlockedDown;
	}

	public boolean isUnlockedUp() {
		return unlockedUp;
	}

	public void setUnlockedUp(boolean unlockedUp) {
		initLock();
		this.unlockedUp = unlockedUp;
	}

	@Override
	public String toString() {
		return "Gear [name=" + name + ", unlockedDown=" + unlockedDown
				+ ", lockedDown=" + lockedDown + ", unlockedUp=" + unlockedUp
				+ ", lockedUp=" + lockedUp + ", fromDownToHight="
				+ fromDownToHight + ", fromHightToDown=" + fromHightToDown
				+ "]";
	}



}
