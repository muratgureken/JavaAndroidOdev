package murat.Odev3;

import java.util.Scanner;

public class StringReverse {
	private Scanner scan;
	
	public StringReverse() {
		boolean caseControl,englishLetterControl;
		int stringLength;
		String s;
		scan = new Scanner(System.in);
		
		System.out.println("Please enter a string.");
		
		s= scan.next();
		stringLength = s.length();
		//control if the string has all lower case letters or not.
		caseControl = UpperLowerCaseControl(s,stringLength);
		//control English letter
		englishLetterControl = EnglishLettersControl(s,stringLength);
		
		//all the conditions are satisfied
		if((stringLength<51)&&caseControl&&englishLetterControl)
		{
			if(stringReverseControl(s,stringLength))
			{
				System.out.println("Yes");
			}
			else
			{
				System.out.println("No");
			}
		}
		else
		{
			System.out.println("WARNING! The string should have less than 51 letters, the letters must be in "
					+ "English alphabet and in lower case.");
			System.out.println("Length="+(stringLength<51)+", LowerCase="+caseControl+", Alphabet="+englishLetterControl);
		}
	}

	private boolean stringReverseControl(String s, int stringLength) {
		boolean reverseControl=true, durum;
		String a,b;
		for (int i = 0; i < (stringLength/2); i++) {
			a = s.substring(i, i+1);
			b = s.substring(stringLength-i-1, stringLength-i);
			durum = a.contentEquals(b);
			if(!durum)
			{
				reverseControl=false;
				break;
			}
		}
		return reverseControl;
	}

	private boolean EnglishLettersControl(String s, int stringLength) {
		boolean letterControl=true;
		String english_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";		
		
		for (int i = 0; i < stringLength; i++) {	
			//if once string has a letter different from English alphabet, return false.
			if(!(english_alphabet.contains(s.substring(i, i+1))))
			{
				letterControl = false;
				break;
			}
		}
		return letterControl;
	}

	private boolean UpperLowerCaseControl(String s, int stringLength) {
		boolean caseControl=true;
		
		for (int i = 0; i < stringLength; i++) {
			if(Character.isUpperCase(s.charAt(i)))
			{
				caseControl = false;
				break;
			}
		}
		return caseControl;
	}
}
