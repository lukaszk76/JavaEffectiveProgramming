//serializable singleton 

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton2 implements Serializable {
	private transient int value;
	public static final Singleton2 INSTANCE = new Singleton2(100);
	private Singleton2(int val) {value = val;}
	
	private Object readResolve() throws ObjectStreamException{
		return INSTANCE;
	}
}
