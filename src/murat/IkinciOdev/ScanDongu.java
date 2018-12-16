package murat.IkinciOdev;

import java.util.Scanner;

public class ScanDongu {
	private Scanner scan;
	
	public ScanDongu() {
		// TODO Auto-generated constructor stub
		int sayi, sayi2;
		boolean durum=true;
		scan = new Scanner(System.in);
		while(durum)
		{
			System.out.println("Geri sayim icin bir deger girin. Cikmak icin 0 yazin.");
			sayi = scan.nextInt();
			
			if(sayi<0)
			{
				System.out.println("Pozitif bir sayi giriniz!");
				continue;
			}
			
			switch(sayi)
			{
				case 0:
					durum = false;
					scan.close();
					System.out.println("Geri sayim sonlandirildi.");
					break;
				default:
					sayi2 = GeriSayimAraci(sayi);
					System.out.println("Geri sayim degerler toplamý = "+sayi2);
					break;
			}
		}
	}

	private int GeriSayimAraci(int sayi) {
		// TODO Auto-generated method stub
		int count=0;
		do
		{
			count = count+sayi;
			System.out.println(sayi--);
		}while(sayi>=0);
		return count;
	}
}
