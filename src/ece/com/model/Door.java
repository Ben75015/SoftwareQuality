package ece.com.model;

import java.util.Observable;

public class Door extends Observable {

	private boolean lock;
	private boolean unlock;
	private boolean fromDownToHight;
	private boolean fromHightToDown;
	
	public Door(String name){
		initLock();
		initTransfert();
		//la porte est par défaut fermée
		lock=true;
		fromDownToHight=true;
		this.name=name;
	}
	
	public void initLock(){
		lock=false;
		unlock=false;
	}
	
	public void initTransfert(){
		fromDownToHight=false;
		fromHightToDown=false;
	}
	
	public boolean isOpen(){
		return fromHightToDown && lock;
	}
	
	public boolean isClose(){
		return fromDownToHight && lock;
	}
	
	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		initLock();
		this.lock = lock;
	}

	public boolean isUnlock() {
		return unlock;
	}

	public void setUnlock(boolean unlock) {
		initLock();
		this.unlock = unlock;
	}

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isFromDownToHight() {
		return fromDownToHight;
	}

	public void setFromDownToHight(boolean fromDownToHight) {
		initTransfert();
		this.fromDownToHight = fromDownToHight;
	}

	public boolean isFromHightToDown() {
		return fromHightToDown;
	}

	public void setFromHightToDown(boolean fromHightToDown) {
		initTransfert();
		this.fromHightToDown = fromHightToDown;
	}

	@Override
	public String toString() {
		return "Door [lock=" + lock + ", unlock=" + unlock
				+ ", fromDownToHight=" + fromDownToHight + ", fromHightToDown="
				+ fromHightToDown + ", name=" + name + "]";
	}
}
