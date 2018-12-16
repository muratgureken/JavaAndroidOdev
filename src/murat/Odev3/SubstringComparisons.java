package murat.Odev3;

import java.util.Scanner;

public class SubstringComparisons {
	private Scanner scan;
	String[] sub_s;
	String latin_alfabesi = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public SubstringComparisons() {
		String s="";
		int k=0;
		scan = new Scanner(System.in);
		
		//string [1,1000] araliginda olmali.
		System.out.println("Bir kelime girin");
		s = scan.next();
		//girilecek sayinin string boyundan kucuk olma kosuluna bak.
		System.out.println("Bir sayi");
		k = scan.nextInt();
		
		getSmallestAndLargest(s,k);
	}

	private void getSmallestAndLargest(String s, int k) {
		sub_s = new String[s.length()-k+1];
		String smallest = "";
		String largest = "";
		int indeks1, indeks2, isSmall=0;
		
		smallest = s.substring(0,3);
		largest = s.substring(0,3);
				
		for(int i=1;i<(s.length()-k+1);i++)
		{
			isSmall = 0;
			sub_s[i] = s.substring(i, i+k);
			for (int j = 0; j < k; j++) 
			{
				indeks1 = latin_alfabesi.indexOf(sub_s[i].substring(j, j+1));
				indeks2 = latin_alfabesi.indexOf(smallest.substring(j, j+1));
				
				if(indeks1<indeks2)
				{
					smallest = sub_s[i];
					isSmall= 1;
					break;
				}
				else if(indeks1>indeks2)
				{
					break;
				}
			}
			
			for (int j = 0; j < k; j++) 
			{
				/*small olan subarraylargestkontrolune sokulmaz*/
				if(isSmall==0)
				{
					indeks1 = latin_alfabesi.indexOf(sub_s[i].substring(j, j+1));
					indeks2 = latin_alfabesi.indexOf(largest.substring(j, j+1));
					
					if(indeks1>indeks2)
					{
						largest = sub_s[i];
						break;
					}
					else if(indeks1<indeks2)
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
