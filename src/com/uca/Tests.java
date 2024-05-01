package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testConverter(){
        //these should be converted successfully 
		assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
		assertThat(RomanConverter.getRomanFromNumber(10), equalTo("X"));
		assertThat(RomanConverter.getRomanFromNumber(3999), equalTo("MMMCMXCIX"));
		assertThat(RomanConverter.getNumberFromRoman("I"), equalTo(1));
		assertThat(RomanConverter.getNumberFromRoman("MMMCMXCIX"), equalTo(3999));

        //Test if the converter handles illegal values
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4037)), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("A")), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("HELLO")), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IC")), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VVV")), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("MMMMM")), instanceOf(IllegalArgumentException.class));
	}

    @Test
	public void testRomanNumber(){
        //test setters and getters
        RomanNumber number = new RomanNumber(5);
        assertThat(number.getRoman(), equalTo("V"));

        number.setRoman("IV");
        assertThat(number.getValue(), equalTo(4));

        number.setValue(10);
        assertThat(number.getRoman(), equalTo("X"));
    }


	@Test
    public void testComparator(){
        RomanNumber number = new RomanNumber(4);

        //1-compare with RomanNumber object
        RomanNumber number2 = new RomanNumber(4);
        assertThat(number.compareTo(number2), equalTo(0));
        number2.setRoman("X");
        assertThat(number.compareTo(number2), equalTo(-1));

        //2-compare with int
        assertThat(number.compareTo(1), equalTo(1));
        assertThat(number.compareTo(10), equalTo(-1));
        assertThat(number.compareTo(4), equalTo(0));

        //3-compare with string
        assertThat(number.compareTo("I"), equalTo(1));
        assertThat(number.compareTo("X"), equalTo(-1));
        assertThat(number.compareTo("IV"), equalTo(0));

        //4-Ivalide params
        assertThat(exceptionOf(() -> number.compareTo("VVV")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> number.compareTo("ABCD")), instanceOf(IllegalArgumentException.class));

    }

    @Test
    public void testTypes(){
        RomanNumber number = new RomanNumber(4);
        
        assertThat(number.intValue(), instanceOf(Integer.class));
        assertThat(number.longValue(), instanceOf(Long.class));
        assertThat(number.doubleValue(), instanceOf(Double.class));
        assertThat(number.floatValue(), instanceOf(Float.class));
        assertThat(number.toString(), instanceOf(String.class));
    }


    @Test
    public void testLowerCase(){
        //if user enters a roman number in lowercase the converter should recongnize it
        RomanNumber b = new RomanNumber("mcv");
        assertThat(b.getRoman(), equalTo("MCV"));
        assertThat(b.getValue(), equalTo(1105));

        RomanNumber a = new RomanNumber(1,"i");
        assertThat(a.getRoman(), equalTo("I"));
        assertThat(a.getValue(), equalTo(1));
    }

    @Test
    public void testValidty(){
        //test all numbers from 1 to 3999
        for (int i = 1; i < 4000; i++) {
            String roman = RomanConverter.getRomanFromNumber(i);
            assertThat(i, equalTo(RomanConverter.getNumberFromRoman(roman)));
        }
    }
	
    @Test
    public void testValidtyLowerCase(){
        //test all numbers from 1 to 3999
        for (int i = 1; i < 4000; i++) {
            String roman = RomanConverter.getRomanFromNumber(i).toLowerCase();
            assertThat(i, equalTo(RomanConverter.getNumberFromRoman(roman)));
        }
    }


    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
