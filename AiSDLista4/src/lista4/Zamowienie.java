package lista4;

public class Zamowienie {
	String nazwatowaru;
	int ilesztuk;
	Zamowienie nextorder;
	
	public Zamowienie(){
		nazwatowaru = null;
		ilesztuk = 0;
	}
	
	public Zamowienie(String nazwatowaru, int ilesztuk, Zamowienie nextorder){
		this.nazwatowaru=nazwatowaru;
		this.ilesztuk=ilesztuk;
		this.nextorder=nextorder;
	}
	
	public String getnazwa(){
		return nazwatowaru;
	}
	
	public int getile(){
		return ilesztuk;
	}
    
	public void wyswietl(){
		System.out.println("Nazawa towaru: "+nazwatowaru+ " Ilosc sztuk: "+ilesztuk);
	}
	
	public void setnext(Zamowienie zm){
		nextorder = zm;
	}
	
	public Zamowienie getnext(){
		return nextorder;
	}
}
