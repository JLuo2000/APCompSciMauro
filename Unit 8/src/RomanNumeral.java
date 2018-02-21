//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

import java.util.Arrays;

public class RomanNumeral
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
		setRoman(str);
		number = 0;
	}

	public RomanNumeral(Integer orig)
	{
		setNumber(orig);
		roman = "";

	}

	public void setNumber(Integer num)
	{
		number = num;




	}

	public void setRoman(String rom)
	{
		roman = rom;


	}

	public Integer getNumber()
	{
		number = 0;
		roman = " " + roman + "  ";
		for (int i = 0; i<roman.length()-1; i++) {
			if (roman.charAt(i) != ' ') {
				if(Arrays.asList(LETTERS).contains(roman.substring(i, i+2))) {
					number = number + NUMBERS[java.util.Arrays.asList(LETTERS).indexOf(roman.substring(i, i+2))];
					i++;
				}
				else{
					number = number + NUMBERS[java.util.Arrays.asList(LETTERS).indexOf(roman.substring(i,i+1))];
				}
			}
			
		}
		return number;
	}

	public String toString()
	{
		roman = "";
		while (number >0) {
			for (int i = 0; i<LETTERS.length; i++) {
				while (number >= NUMBERS[i]) {
					number = number - NUMBERS[i];
					roman = roman + LETTERS[i];
				}
			}
		}
		return roman + "\n";
	}
}