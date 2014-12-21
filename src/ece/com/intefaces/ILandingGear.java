package ece.com.intefaces;

public interface ILandingGear {

	public static String FRONT = "Front";
	public static String RIGHT = "Right";
	public static String LEFT = "Left";
	
	//WHEEL
	public static String ACTION_GEAR_UP_TO_DOWN="openGear";
	public static String ACTION_GEAR_DOWN_TO_UP="closeGear";
	public static String ACTION_GEAR_UNLOCK_DOWN="unlockDownGear";
	public static String ACTION_GEAR_LOCK_DOWN="lockDownGear";
	public static String ACTION_GEAR_UNLOCK_UP="unlockUpGear";
	public static String ACTION_GEAR_LOCK_UP="lockUpGear";
	//DOOR
	public static String ACTION_DOOR_UP_TO_DOWN="openDoor";
	public static String ACTION_DOOR_DOWN_TO_UP="closeDoor";
	public static String ACTION_DOOR_UNLOCK_UP="unlockUpDoor";
	public static String ACTION_DOOR_LOCK_UP="lockUpDoor";
}
