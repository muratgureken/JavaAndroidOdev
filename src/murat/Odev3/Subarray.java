package murat.Odev3;

import java.util.Scanner;

public class Subarray {
	int [] arrayInput;
	int arraySize, negativeCount=0;
	private Scanner scan;
	boolean durum=true;

	public Subarray() {
		scan = new Scanner(System.in);
		
		while(durum)
		{
			//control the size of the array
			System.out.println("Please enter the length of the array in range [1,100]");
			arraySize = scan.nextInt();
			if((arraySize>=1)&&(arraySize<=100))
			{
				durum=false;
			}
		}
		
		durum = true;
		
		while(durum)
		{
			durum = false;
			//control the elements of array
			System.out.println("Please enter Integer elements of the array in range [-10e4,10e4]");
			arrayInput = new int[arraySize];

			//??? control if the input is integer or not
			for(int i=0;i<arraySize;i++)
			{
				arrayInput[i] = scan.nextInt();
				if((arrayInput[i]<-10000)||(arrayInput[i]>10000))
				{
					durum = true;
				}
			}
		}
		
		for(int i=0;i<arraySize;i++)
		{
			NegativeSumCount(i);
		}
		System.out.println("The number of negative subarrays is "+negativeCount);
	}

	private void NegativeSumCount(int ArrayIndex) {
		int sum=0;
		
		for(int i=ArrayIndex;i<arraySize;i++)
		{
			sum = sum+arrayInput[i];
			//System.out.println("Sum="+sum);
			if(sum<0)
			{
				negativeCount++;
			}
		}
	}
}
