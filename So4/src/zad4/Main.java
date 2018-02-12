package zad4;

public class Main {
	static int ileprocesow = 10;
	static int ileodwolan = 1000;
	static int ileramek = 100;
	static int progdolny = 5;    
	static int proggorny = 20;  
	static int ramkipoczatkowe = 5;
	static int prog = 50;
	static int I = 20;
	public static void main(String args[]){
		Proces proc = new Proces();
		Proces[] p = new Proces[ileprocesow];
		Proces[] p1 = new Proces[ileprocesow];
		Proces[] p2 = new Proces[ileprocesow];
		Proces[] p3 = new Proces[ileprocesow];
		p = proc.generator2(ileprocesow, proggorny, progdolny, ileodwolan);
		p1 = p.clone();
		p2 = p.clone();
		p3 = p.clone();
		Przydzial przydz = new Przydzial(ileramek);
		System.out.println("Przydzial rowny");
		System.out.println("Suma bledow: "+przydz.przydzialrowny(p, ileramek));
		System.out.println("Przydzial rownomierny");
		System.out.println("Suma bledow: "+przydz.przydzialproporcjonalny(p1, ileramek));
		System.out.println("Sterowanie czestoscia bledow stron: ");
		System.out.println("Suma bledow: "+przydz.zliczaniebledow(p2, ileramek, ramkipoczatkowe, prog));
		System.out.println("Model strefowy: ");
		System.out.println("Suma bledow: "+przydz.modelstrefowy(p3, ileramek, ramkipoczatkowe, prog, progdolny+proggorny, I));
	}

}
