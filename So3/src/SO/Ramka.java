package SO;

public class Ramka {
    int numer;
    int wartosc;
	
	public Ramka(){}
	
	public Ramka(int numer, int wartosc){
		this.numer = numer;
		this.wartosc = wartosc;
	}
	
	public int getwartosc(){
		return wartosc;
	}
	
	public int gernumer(){
		return numer;
	}
	
	public void wyswietl(){
		System.out.println(numer+" "+wartosc);
	}

}
