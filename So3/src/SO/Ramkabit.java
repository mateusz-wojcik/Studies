package SO;

public class Ramkabit {
	int numer;
    int wartosc;
    int bit;
	
	public Ramkabit(){}
	
	public Ramkabit(int numer, int wartosc, int bit){
		this.numer = numer;
		this.wartosc = wartosc;
		this.bit = bit;
	}
	
	public int getwartosc(){
		return wartosc;
	}
	
	public int gernumer(){
		return numer;
	}
	
	public int getbit(){
		return bit;
	}
	
	public void wyswietl(){
		System.out.println(numer+" "+wartosc);
	}

}
