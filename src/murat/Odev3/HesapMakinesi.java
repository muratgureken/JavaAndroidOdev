package murat.Odev3;

import java.util.Scanner;

public class HesapMakinesi {
	boolean durum=true, detayliLog=false;
	double sonuc = 0.0;
	String IslemListesi, DortIslem="+-*/";
	String kabulEdilenGirdiler = "0123456789+-*/.";
	Scanner scan;
	int [] IslemTipi, IslemTipiSade;
	int gecersizIslem=0, sonIndis=0, islemBoyut, islemIndis=0, ilkDegerIslem=0;
	double [] sonIslem1, sonIslem2;
	String [] IslemSade;

	public HesapMakinesi() {
		String islemBul;

		System.out.println("DORT ISLEM HESAP MAKINESI");
		System.out.println("Lutfen sadece rakam ve +,-,*,/ dort islem operatorlerini kullanin.");
		System.out.println("Cikis yapmak icin E, sonucu sifirlamak icin C'ye basiniz.");
		System.out.println("ISLEM SONUCU="+sonuc);

		scan = new Scanner(System.in);

		while(durum)
		{
			gecersizIslem = 0;
			sonIndis = 0;
			islemIndis = 0;
			ilkDegerIslem = 0;

			IslemListesi = scan.next();

			IslemTipi = new int[IslemListesi.length()];
			IslemTipiSade = new int[IslemListesi.length()+1];
			sonIslem1 = new double[IslemListesi.length()+1];
			sonIslem2 = new double[IslemListesi.length()+1];
			IslemSade = new String[IslemListesi.length()+1];

			for(int i=0;i<IslemListesi.length();i++)
			{
				islemBul = IslemListesi.substring(i, i+1);

				if(IslemListesi.length()==1)
				{
					if(islemBul.contains("E"))
					{
						durum = false;
						break;
					}
					else if(islemBul.contains("C"))
					{
						sonuc= 0.0;
						System.out.println("ISLEM SONUCU="+sonuc);
						gecersizIslem = 1;
						break;
					}
				}

				//girdi, istenilen aralikta degil
				if(!(kabulEdilenGirdiler.contains(islemBul)))
				{
					System.out.println("UYARI: Yanlis formatta giris yapildi.");
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
				default:
					IslemTipi[i] = 4;
					break;
				}
			}

			if(durum==false)
			{
				System.out.println("HESAP MAKINESI KAPATILDI.");
				gecersizIslem = 1;
				break;
			}

			if(gecersizIslem==0)
			{
				IslemBasiniDuzelt();
				IslemleriSadelestir();
				IslemSonunuDuzelt();
				String2IntegerParse();
				DortIslem();
				System.out.println("ISLEM SONUCU="+sonuc);
			}
		}
	}

	private void IslemBasiniDuzelt() {		
		for(int i=0;i<IslemListesi.length();i++)
		{
			if(DortIslem.contains(IslemListesi.substring(i, i+1)))
			{
				if(i==0)
				{
					IslemSade[0] = "0";
					IslemTipiSade[0] = 4;					
				}
				IslemSade[1] = IslemListesi.substring(i, i+1);
				IslemTipiSade[1] = IslemTipi[i];
				sonIndis = 2;
				islemIndis = i+1;
				ilkDegerIslem = 1;
			}
			else
			{
				break;
			}
		}
	}

	private void IslemleriSadelestir() {
		int Count=sonIndis;
		boolean oncekiIslem=false, sonIslem=false;
		for(int i=islemIndis;i<IslemListesi.length();i++)
		{
			//rakam varsa
			if(IslemTipi[i]==4)
			{
				if(oncekiIslem)
				{
					Count++;
				}
				IslemTipiSade[Count] = IslemTipi[i];
				IslemSade[Count] = IslemListesi.substring(i, i+1);
				oncekiIslem = false;
				sonIslem = false;
				Count++;
			}
			else /*islem varsa*/
			{
				IslemTipiSade[Count] = IslemTipi[i];
				IslemSade[Count] = IslemListesi.substring(i,i+1);
				oncekiIslem = true;
				sonIslem = true;
			}
		}
		islemBoyut = Count;
		if(sonIslem)
		{
			islemBoyut = Count+1;
		}

		if(detayliLog)
		{
			System.out.println("Sadelestirilmis string");
			for(int i=0;i<islemBoyut;i++)
			{
				System.out.print(IslemSade[i]+" ");
			}
			System.out.println();
		}
	}

	private void IslemSonunuDuzelt() {
		int islemBoyut2=islemBoyut;
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
				/*System.out.println("AraIslem="+araIslem);*/
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
		if(ilkDegerIslem==1)
		{
			sonIslem1[0] = sonuc;
		}

		if(detayliLog)
		{
			System.out.println("Parse edilmiþ string");
			for(int i=0;i<islemBoyut;i++)
			{
				System.out.print(sonIslem1[i]+" ");
			}
			System.out.println();
		}
	}

	private void DortIslem() {
		int count=-1;
		boolean islemYap=true;
		for(int i=0;i<islemBoyut;i++)
		{
			if(sonIslem1[i]==-3.0)
			{
				sonIslem2[count] = sonIslem2[count]/sonIslem1[i+1];
				islemYap = false;
			}
			else if(sonIslem1[i]==-4.0)
			{
				sonIslem2[count] = sonIslem2[count]*sonIslem1[i+1];
				islemYap = false;
			}
			else
			{
				if(islemYap)
				{
					count++;
					sonIslem2[count] = sonIslem1[i];
				}
				islemYap = true;
			}
		}

		islemBoyut = count+1;
		sonuc = sonIslem2[0];
		for(int i=0;i<islemBoyut;i++)
		{
			if(sonIslem2[i]==-1.0)
			{
				sonuc = sonuc - sonIslem2[i+1];
			}
			else if(sonIslem2[i]==-2.0)
			{
				sonuc = sonuc + sonIslem2[i+1];                    
			}
		}
	}
}