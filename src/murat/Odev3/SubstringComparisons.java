package murat.Odev3;

import java.util.Scanner;

public class SubstringComparisons {
	private Scanner scan;
	String[] sub_s;
	String latin_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	int maxLength=1000;
	
	public SubstringComparisons() {
		String s="";
		int k=0;
		scan = new Scanner(System.in);
		
		//string should be in [1,maxLength] range.
		System.out.println("Please enter a word.");
		s = scan.next();
		while(s.length()>maxLength)
		{
			System.out.println("The length of the word should be maximum "+maxLength+".");
			System.out.println("Please enter a word.");
			s = scan.next();			
		}
		//control the value of k. it should be less or equal to the length of s.
		System.out.println("Please enter an integer number");
		k = scan.nextInt();
		while(k>s.length())
		{
			System.out.println("The number should be less than or equal to "+s.length()+".");
			System.out.println("Please enter an integer number");
			k = scan.nextInt();			
		}
		
		System.out.println("Word="+s);
		System.out.println("Number="+k);
		getSmallestAndLargest(s,k);
	}

	private void getSmallestAndLargest(String s, int k) {
		sub_s = new String[s.length()-k+1];
		String smallest = "";
		String largest = "";
		int index1, index2, isSmall=0;
		
		smallest = s.substring(0,3);
		largest = s.substring(0,3);
				
		for(int i=1;i<(s.length()-k+1);i++)
		{
			isSmall = 0;
			sub_s[i] = s.substring(i, i+k);
			for (int j = 0; j < k; j++) 
			{
				index1 = latin_alphabet.indexOf(sub_s[i].substring(j, j+1));
				index2 = latin_alphabet.indexOf(smallest.substring(j, j+1));
				
				if(index1<index2)
				{
					smallest = sub_s[i];
					isSmall= 1;
					break;
				}
				else if(index1>index2)
				{
					break;
				}
			}
			
			for (int j = 0; j < k; j++) 
			{
				/*if sub_s is flagged as smallest, we skip the largest control.*/
				if(isSmall==0)
				{
					index1 = latin_alphabet.indexOf(sub_s[i].substring(j, j+1));
					index2 = latin_alphabet.indexOf(largest.substring(j, j+1));
					
					if(index1>index2)
					{
						largest = sub_s[i];
						break;
					}
					else if(index1<index2)
					{
						break;
					}
				}
			}
		}
		
		System.out.println("Smallest="+smallest);
		System.out.println("Largest="+largest);
	}
}
