package murat.ilkOdev;

public class DortIslem {
	public DortIslem(float a, float b) {
		// TODO Auto-generated constructor stub
		System.out.println("a="+a+", b="+b);
		toplama(a,b);
		cikarma(a,b);
		carpma(a,b);
		float c = bolme(a,b);
		System.out.println("Bolme Cikti="+c);
	}

	private float bolme(float a, float b) {
		// TODO Auto-generated method stub
		float c;
		c = a/b;
		System.out.println("Bolme="+c);
		
		return c;
	}

	private void carpma(float a, float b) {
		// TODO Auto-generated method stub
		float c;
		c = a*b;
		System.out.println("Carpma="+c);		
	}

	private void cikarma(float a, float b) {
		// TODO Auto-generated method stub
		float c;
		c = a-b;
		System.out.println("Cikarma="+c);
	}

	private void toplama(float a, float b) {
		// TODO Auto-generated method stub
		float c;
		c = a+b;
		System.out.println("Toplama="+c);
	}
}
