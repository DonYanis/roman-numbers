package com.uca;


public class RomanNumber extends Number implements Comparable{
	
	private String roman;
	
	private int value;
	
	public RomanNumber(){
		//Ignored
	}
	
	public RomanNumber(String roman){
		this.roman = roman.toUpperCase();
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	
	public RomanNumber(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	public RomanNumber(int value, String roman){
		this.value = value;
		this.roman = roman.toUpperCase();
	}
	
	public String getRoman(){
		return this.roman;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setRoman(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	public void setValue(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	
	
	
	/**
	* @{inheritDoc}
	*/
	@Override
	public double doubleValue() {
		return (double) this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public float floatValue() {
		return (float) this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public int intValue() {
		return this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public long longValue() {
		return (long) this.value;
	}

	@Override
	public String toString() {
		return "RomanNumber :  roman='" + this.roman + "', value=" + this.value;
	}

	
	@Override
	public int compareTo(Object o) {

    	if (o instanceof RomanNumber) {
			RomanNumber n = (RomanNumber) o;
        	return Integer.compare(this.value, n.value);

    	} else if (o instanceof Integer) {
        	return Integer.compare(this.value, (Integer) o);

    	} else if (o instanceof String) {
			try {
				 RomanNumber n = new RomanNumber((String) o);
				return Integer.compare(this.value, n.value);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Invalid Roman string");
			}
			
		} else {
			throw new IllegalArgumentException("Comparison with non valid Number / Roman Number");
		}
}

}