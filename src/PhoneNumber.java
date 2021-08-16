//this is to demonstrate proper custom equals(), hashCode() and toString();

public final class PhoneNumber {
	
	private int hashCode;
	
	public PhoneNumber(short areaCode, short prefix, short lineNum) {
		
		this.areaCode = rangeCheck(areaCode, 999, "numer kierunkowy");
		this.prefix = rangeCheck(prefix, 999, "prefiks");
		this.lineNum = rangeCheck(lineNum, 9999, "numer linii");
	}

	private final short areaCode, prefix, lineNum;
	
	private static short rangeCheck(int val, int max, String arg) {
		if (val<0 || val>max) {
			throw new IllegalArgumentException(arg + ": " + val);
		}
		return (short) val;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (!(obj instanceof PhoneNumber))
			return false;
		
		PhoneNumber other = (PhoneNumber) obj;
		return areaCode == other.areaCode && lineNum == other.lineNum && prefix == other.prefix;
	}
	
	@Override
	public int hashCode() {
		int result = hashCode;
		if (result == 0) {
			result = Short.hashCode(areaCode);
			result = 31 * result + Short.hashCode(prefix);
			result = 31 * result + Short.hashCode(lineNum);
			hashCode = result;
		}
		
		return result;
	}
	
	/**
	 * Zwraca ci¹g reprezentuj¹cy ten numer telefonu
	 * Ci¹g sk³ada siê z 12 znaków w formacie
	 * xxx-yyy-zzzz, gdzie xxx jest numerem kierunkowym, yyy-prefiksem a zzzz-numerem linii
	 * 
	 * Je¿eli dowolna z trzech czêœci jest zbyt ma³a aby wype³niæ swoje pole
	 * to jest ono uzupe³niane zerami z lewej strony
	 * np. jeœli numerem linie jest 123 to ci¹g bêdzie mia³ postaæ 0123
	 */
	@Override
	public String toString() {
		return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
	}
}
