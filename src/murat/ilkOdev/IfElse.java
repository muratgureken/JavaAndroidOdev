package murat.ilkOdev;

public class IfElse {
	public IfElse(int Sayi) {
		// TODO Auto-generated constructor stub
		if(Sayi<1 || Sayi>100)
		{
			System.out.println("1-100 aralýðýnda bir sayi giriniz!");
		}
		else if((Sayi%2)==1)
		{
			System.out.println("Weird");
		}
		else
		{
			if(Sayi>=2 && Sayi<=5)
			{
				System.out.println("Not Weird");
			}
			else if(Sayi>=6 && Sayi<=20)
			{
				System.out.println("Weird");				
			}
			else if(Sayi>20)
			{
				System.out.println("Not Weird");
			}
		}
	}
}
