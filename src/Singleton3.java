// this is to demonstrate singleton design pattern implementation with enum

public enum Singleton3 {
	INSTANCE;
	
	private int value = 0;
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int val) {
		value = val;
	}
}
