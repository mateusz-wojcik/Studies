package zad3;

public class Karta{
	int wartosc;
	int kolor;

	public Karta() {
		wartosc = 0;
		kolor = 0;
	}

	public Karta(int wartosc, int kolor) {
		this.wartosc = wartosc;
		this.kolor = kolor;
	}

	public int getwartosc() {
		return wartosc;
	}

	public int getkolor() {
		return kolor;
	}
	
	public void wyswietl(){
		System.out.println(wartosc + " " + kolor);
	}

	public void wyswietll() {
		String k = null;
		if(kolor==0){
			k = "kier";
		}
		if(kolor==1){
			k = "karo";
		}
		if(kolor==2){
			k = "trefl";
		}
		if(kolor==3){
			k = "pik";
		}
		if(wartosc==1){
			System.out.println("as" + "    " + k);
		}
		if(wartosc==10){
			System.out.println(wartosc + "    "+ k);
		}
		if(wartosc==11){
			System.out.println("walet" + " " + k);
		}
		if(wartosc==12){
			System.out.println("dama" + "  " + k);
		}
		if(wartosc==13){
			System.out.println("krol" + "  " + k);
		}
		if(wartosc==2 || wartosc==3 || wartosc==4 || wartosc==5 || wartosc==6 || wartosc==7 || wartosc==8 || wartosc==9){
			System.out.println(wartosc + "     " + k);	
		}
	}
	

	/*public static int znajdzwartosc(ArrayList<Karta> lista, int wart){
		int licznik = 0;
	    for(int j=0; j<lista.size(); j++){
	    	if(lista.get(j).getwartosc()==wart){
	    		licznik++;
	    	}
	    }
		return licznik;
	}*/
}
