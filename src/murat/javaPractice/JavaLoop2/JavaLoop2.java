package murat.javaPractice.JavaLoop2;

import java.util.Scanner;

public class JavaLoop2 {
	Scanner in;
	int[][] cikti;
	int[] boycikti = new int[2];
	
	public JavaLoop2() {
		// TODO Auto-generated constructor stub
		in = new Scanner(System.in);
		System.out.println("query sayisini girin.");
		int count = in.nextInt();
		int[] girdi = new int[3*count];
		int count2=1;
		cikti = new int[count][15];

		for(int i=0;i<count;i++)
		{
			System.out.println((i+1)+"/"+count+" adim 3 sayi girin.");
			//a, b, n constraintlerini gir 0<=a,b<=50  1<=n<=15
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			
			girdi[i*3] 	 = a;
			girdi[i*3+1] = b;
			girdi[i*3+2] = n;
			
			boycikti[i] = 0;
			SeriHesapla(a,b,n,i);
		}
		
		System.out.println(count);
		for(int i=0;i<girdi.length;i++)
		{
			System.out.print(girdi[i]);
			System.out.print(" ");
			if(count2%3==0)
			{
				System.out.println();
			}
			count2++;
		}
		
		for(int i=0;i<count;i++)
		{
			for (int j=0;j<boycikti[i];j++) 
			{
				System.out.print(cikti[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	private void SeriHesapla(int a, int b, int n, int j) {
		// TODO Auto-generated method stub
		int ikiuzeri=1,Sonuc=0;
		
		Sonuc = a;
		for(int i=0;i<n;i++)
		{
			Sonuc = Sonuc+ikiuzeri*b;
			ikiuzeri = ikiuzeri*2;
			cikti[j][i] = Sonuc;
			boycikti[j]++;
		}
	}
}
