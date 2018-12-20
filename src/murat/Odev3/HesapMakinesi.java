package murat.Odev3;

import java.util.Scanner;

public class HesapMakinesi {
	boolean durum = true;
	double sonuc = 0.0;
	String IslemListesi, DortIslem="+-*/";
	String kabulEdilenGirdiler = "0123456789+-*/EC.";
	Scanner scan;
	int [] IslemTipi, IslemTipiSade;
	int gecersizIslem=0, sonIndis=0, islemBoyut;
	double [] sonIslem1, sonIslem2;
	String [] IslemSade;
	
	public HesapMakinesi() {
		String islemBul;
		
		while(durum)
		{
			gecersizIslem = 0;
			sonIndis = 0;
			
			scan = new Scanner(System.in);
			System.out.println("DORT ISLEM HESAP MAKINESI");
			System.out.println("Lutfen sadece rakam ve +,-,*,/ dort islem operatorlerini kullanin.");
			System.out.println("Cikis yapmak icin E, sonucu sifirlamak icin C'ye basiniz.");
			System.out.println("Sonuc="+sonuc);
			
			IslemListesi = scan.next();
			
			IslemTipi = new int[IslemListesi.length()];
			IslemTipiSade = new int[IslemListesi.length()+1];
			sonIslem1 = new double[IslemListesi.length()+1];
			sonIslem2 = new double[IslemListesi.length()+1];
			IslemSade = new String[IslemListesi.length()+1];
			for(int i=0;i<IslemListesi.length();i++)
			{
				islemBul = IslemListesi.substring(i, i+1);
				
				//girdi, istenilen aralikta degil
				if(!(kabulEdilenGirdiler.contains(islemBul)))
				{
					System.out.println("Yanlis formatta giris yapildi.");
					gecersizIslem = 1;
					break;
				}

				switch(islemBul)
				{
					case "*":
						IslemTipi[i] = 0;
						break;
					case "/":
						IslemTipi[i] = 1;
						break;
					case "+":
						IslemTipi[i] = 2;
						break;
					case "-":
						IslemTipi[i] = 3;
						break;
					case "E":
						durum = false;
						break;
					case "C":
						sonuc= 0.0;
						System.out.println("sonuc="+sonuc);
						break;
					default:
						IslemTipi[i] = 4;
						break;
				}
				
				if(durum==false)
				{
					System.out.println("Hesap makinesi sonlandirildi.");
					gecersizIslem = 1;
					break;
				}
				
				/*System.out.println("bura mi?");
				System.out.print(IslemTipi[i]+" ");
				System.out.println();*/
			}
			
			if(gecersizIslem==0)
			{
				IslemBasiniDuzelt();
				IslemleriSadelestir();
				IslemSonunuDuzelt();
				String2IntegerParse();
				DortIslem();
			}
		}
	}

	private void DortIslem() {

	}

	private void String2IntegerParse() {
		int count=0;
		String araIslem="";
		double araDeger;
		
		for(int i=0;i<islemBoyut;i++)
		{
			if(IslemTipiSade[i]==4)
			{
				araIslem = araIslem+IslemSade[i];
			}
			else
			{
				System.out.println("AraIslem="+araIslem);
				araDeger = Double.parseDouble(araIslem);
				sonIslem1[count] = araDeger;
				araIslem = "";
				//islemlerden 4 cikar. tum islemler negatif sayi olursa diger degerlerden ayirt edilebilir.
				count++;
				sonIslem1[count] = IslemTipiSade[i]-4;
				count++;
			}
			if(i==(islemBoyut-1))
			{
				araDeger = Double.parseDouble(araIslem);
				sonIslem1[count] = araDeger;		
			}
		}
		islemBoyut = count+1;
		
		System.out.println("Parse edilmiþ string");
		for(int i=0;i<islemBoyut;i++)
		{
			System.out.print(sonIslem1[i]+" ");
		}
		System.out.println();
	}

	private void IslemSonunuDuzelt() {
		int islemBoyut2=islemBoyut;
		System.out.println("Islem boyut="+islemBoyut);
		for(int i=islemBoyut-1;i>=0;i--)
		{
			//son islem tipi dort islem ise bu degerin kullanilmamasi icin boyutu 1 azalt.
			if(IslemTipiSade[i]!=4)
			{
				islemBoyut2--;
			}
			else
			{
				break;
			}
		}
		
		islemBoyut = islemBoyut2;
	}

	private void IslemleriSadelestir() {
		int Count=sonIndis-1;
		System.out.println("sade basindaki boyut="+Count);
		for(int i=sonIndis;i<IslemListesi.length();i++)
		{
			//rakam varsa
			if(IslemTipi[i]==4)
			{
				Count++;
				IslemTipiSade[Count] = IslemTipi[i];
				IslemSade[Count] = IslemListesi.substring(i, i+1);
				Count++;
			}
			else /*islem varsa*/
			{
				IslemTipiSade[Count] = IslemTipi[i];
				IslemSade[Count] = IslemListesi.substring(i,i+1);
			}
		}
		islemBoyut = Count+1;
		System.out.println("Sadelestirilmis string");
		for(int i=0;i<islemBoyut;i++)
		{
			System.out.print(IslemSade[i]+" ");
		}
		System.out.println();
	}

	private void IslemBasiniDuzelt() {		
		for(int i=0;i<IslemListesi.length();i++)
		{
			if(DortIslem.contains(IslemListesi.substring(i, i+1)))
			{
				if(i==0)
				{
					IslemSade[i] = "0";
					IslemTipiSade[0] = 4;
					
				}
				IslemSade[1] = IslemListesi.substring(i, i+1);
				IslemTipiSade[1] = IslemTipi[i];
				sonIndis = 2;
			}
			else
			{
				break;
			}
		}
	}
}
