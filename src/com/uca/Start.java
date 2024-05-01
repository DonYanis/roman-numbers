package com.uca;

public class Start{
	
	//Start class
	public static void main(String[] args){
		
		RomanNumber roman = new RomanNumber();

		if(args.length>0){
			try {
				int value = Integer.parseInt(args[0]);
				try {
					roman.setValue(value);
					System.out.println(roman.toString());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} catch (Exception e) {
				try {
					roman.setRoman(args[0]);
					System.out.println(roman.toString());
				} catch (Exception err) {
					System.out.println(err.getMessage());
				}
			}
		}
	}
}